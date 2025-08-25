Feature: Test User Login

  @smoke
  Scenario Outline: Test Login Cases
    Given user has opened login page
    When user types in username "<username>" and password "<password>"
    And user clicks on login button
    Then system should display "<expected_message>"

    Examples:
      | username | password | expected_message |
      | salewond | 123456   | 登录成功             |
      | aaaa1    | 123456   | 登录帐号不存在          |
      | salewond | 999999   | 密码错误             |
      | salewond |          | 密码格式 6~18 个字符    |
      | test     | 12345    | 密码格式 6~18 个字符    |
      |          | 123456   | 请填写登录账号          |