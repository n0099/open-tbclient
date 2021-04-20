package d.b.i0.q0.n2;

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

    public static int d(int i) {
        if (i != 2) {
            if (i != 3) {
                if (i != 5) {
                    if (i != 6) {
                        if (i != 7) {
                            return i != 8 ? -1 : 4;
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

    public static int e(int i, FrsRequestData frsRequestData) {
        if (i != 2) {
            if (i != 3) {
                if (i != 5) {
                    if (i != 6) {
                        if (i != 7) {
                            if (i == 8 && frsRequestData != null) {
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

    public static int f(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return i != 4 ? -1 : 8;
                    }
                    return 7;
                }
                return 6;
            }
            return 3;
        }
        return 2;
    }

    public static int g(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return 1;
                    }
                    if (i != 4) {
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

    public static void i(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            SharedPreferences.Editor edit = c().edit();
            edit.putInt(str, i);
            edit.apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
