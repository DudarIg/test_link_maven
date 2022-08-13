import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.annotations.AfterClass
import org.testng.annotations.Test

const  val COUNT: Int  = 3

class LinkTest {

    init {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe")
    }

    val driver = ChromeDriver()
    var menu: List<WebElement>? = null

    private fun setUp() {
        driver.get("https://swetotehnika.ru")
        menu  = driver.findElements(By.cssSelector(".main_menu_item"))
    }

    @Test
    fun testMenuLink0() {
        setUp()
        menu!![0].click()
        driver.get("https://swetotehnika.ru/catalog/")
        var links : MutableList<WebElement>? = null
        for (i in 1..COUNT) {
            links = driver.findElements(By.cssSelector("a[href^='/catalog/']"))
            val randoms = (0..links.size-1).random()
            links[randoms].click()
            driver.executeScript("window.history.go(-1)")
        }

    }

    @Test
    fun testMenuLink1() {
        setUp()
        menu!![1].click()
        driver.get("https://swetotehnika.ru/shop/apparatura_puskoreguliruyushchaya/")
        var links : MutableList<WebElement>? = null
        for (i in 1..COUNT) {
            links = driver.findElements(By.cssSelector("a[href^='/shop/']"))
            val randoms = (0..links.size-1).random()
            links[randoms].click()
            driver.executeScript("window.history.go(-1)")
        }

    }

    @Test
    fun testMenuLink2() {
        setUp()
        menu!![2].click()
        var links : MutableList<WebElement>? = null
        driver.get("https://swetotehnika.ru/services/")
        for (i in 1..COUNT) {
            links = driver.findElements(By.cssSelector("a[href^='/services/']"))
            val randoms = (0..links.size-1).random()
            links[randoms].click()
            driver.executeScript("window.history.go(-1)")
        }
    }

    @Test
    fun testMenuLink3() {
        setUp()
        menu!![3].click()
        driver.executeScript("window.history.go(-1)")
    }


    @Test
    fun testMenuLink4() {
        setUp()
        menu!![4].click()
        var links : MutableList<WebElement>? = null
        driver.get("https://swetotehnika.ru/proizvoditeli-svetotekhniki/")
        for (i in 1..COUNT) {
            links = driver.findElements(By.cssSelector("a[href^='/proizvoditeli-svetotekhniki/']"))
            val randoms = (0..links.size-1).random()
            links[randoms].click()
            driver.executeScript("window.history.go(-1)")
        }

    }

    @Test
    fun testMenuLink5() {
        setUp()
        menu!![5].click()
        driver.executeScript("window.history.go(-1)")
    }




    @Test
    fun testMenuLink6() {
        setUp()
        menu!![6].click()
        var links : MutableList<WebElement>? = null
        driver.get("https://swetotehnika.ru/news/")
        for (i in 1..COUNT) {
            links = driver.findElements(By.cssSelector(".news-detail-link"))
            val randoms = (0..links.size-1).random()
            links[randoms].click()
            driver.executeScript("window.history.go(-1)")
        }
    }


    @Test
    fun testMenuLink7() {
        setUp()
        menu!![7].click()
        driver.executeScript("window.history.go(-1)")
    }

    @AfterClass
    fun exit() {
        driver.quit()
    }
}