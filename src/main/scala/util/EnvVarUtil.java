package util;

/**
 * EnvVarUtil: util for getting system enviroment variables
 * author: Chengjs, version:1.0.0, 2017-05-05
 */
public class EnvVarUtil {

  /**
   * 获取项目根路径
   * @return
   */
  public static String getClassRelativePath() {
    return System.getProperty("user.dir");
  }

}
