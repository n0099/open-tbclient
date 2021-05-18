package d.a.k0.q0.n2;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.FrsRequestData;
/* loaded from: classes4.dex */
public class k {
    public static void a() {
        try {
            SharedPreferences.Editor edit = c().edit();
            edit.clear();
            edit.commit();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String b() {
        return "pref_name_frs_sortType_" + TbadkCoreApplication.getCurrentAccount();
    }

    public static SharedPreferences c() {
        return TbadkCoreApplication.getInst().getSharedPreferences(b(), 0);
    }

    public static int d(int i2) {
        if (i2 != 2) {
            if (i2 != 3) {
                if (i2 != 5) {
                    if (i2 != 6) {
                        if (i2 != 7) {
                            return i2 != 8 ? -1 : 4;
                        }
                        return 3;
                    }
                    return 2;
                }
                return 0;
            }
            return 1;
        }
        return 0;
    }

    public static int e(int i2, FrsRequestData frsRequestData) {
        if (i2 != 2) {
            if (i2 != 3) {
                if (i2 != 5) {
                    if (i2 != 6) {
                        if (i2 != 7) {
                            if (i2 == 8 && frsRequestData != null) {
                                frsRequestData.setSortType(4);
                                frsRequestData.G(0);
                            }
                        } else if (frsRequestData != null) {
                            frsRequestData.setSortType(3);
                            frsRequestData.G(0);
                        }
                    } else if (frsRequestData != null) {
                        frsRequestData.setSortType(2);
                        frsRequestData.G(0);
                    }
                } else if (frsRequestData != null) {
                    frsRequestData.setSortType(0);
                    frsRequestData.G(1);
                }
            } else if (frsRequestData != null) {
                frsRequestData.setSortType(1);
                frsRequestData.G(0);
            }
        } else if (frsRequestData != null) {
            frsRequestData.setSortType(0);
            frsRequestData.G(0);
        }
        return 1;
    }

    public static int f(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return i2 != 4 ? -1 : 8;
                    }
                    return 7;
                }
                return 6;
            }
            return 3;
        }
        return 2;
    }

    public static int g(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        return 1;
                    }
                    if (i2 != 4) {
                        return -1;
                    }
                }
                return 4;
            }
            return 3;
        }
        return 2;
    }

    public static int h(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return c().getInt(str, -1);
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static void i(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            SharedPreferences.Editor edit = c().edit();
            edit.putInt(str, i2);
            edit.apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
