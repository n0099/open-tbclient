package com.qq.e.comm.managers.setting;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.comm.util.SystemUtil;
import java.io.File;
import java.io.FileWriter;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f38615a;

    /* loaded from: classes6.dex */
    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final String f38616a;

        /* renamed from: b  reason: collision with root package name */
        public final T f38617b;

        public a(String str, T t) {
            this.f38616a = str;
            this.f38617b = t;
        }

        public /* synthetic */ a(String str, Object obj, byte b2) {
            this(str, obj);
        }

        public final String a() {
            return this.f38616a;
        }

        public final T b() {
            return this.f38617b;
        }
    }

    public e() {
        this(null);
    }

    public e(String str) {
        String simpleName = getClass().getSimpleName();
        GDTLogger.d("Initialize " + simpleName + ",Json=" + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                this.f38615a = new JSONObject(str);
            } catch (JSONException e2) {
                GDTLogger.e("JsonException While build" + simpleName + " Instance from JSON", e2);
            }
        }
        if (this.f38615a == null) {
            this.f38615a = new JSONObject();
        }
    }

    public static Pair<String, String> a(Context context, String str) {
        File dir = context.getDir(SystemUtil.buildNewPathByProcessName("e_qq_com_setting"), 0);
        if (dir.exists()) {
            File file = new File(dir, str + ".sig");
            File file2 = new File(dir, str + ".cfg");
            if (file.exists() && file2.exists()) {
                try {
                    String readAll = StringUtil.readAll(file);
                    String readAll2 = StringUtil.readAll(file2);
                    if (!TextUtils.isEmpty(readAll) && !TextUtils.isEmpty(readAll2) && com.qq.e.comm.util.a.a().a(readAll, readAll2)) {
                        return new Pair<>(readAll, new String(Base64.decode(readAll2, 0), "UTF-8"));
                    }
                    GDTLogger.e("verify " + str + " setting fail");
                } catch (Exception e2) {
                    GDTLogger.e("exception while loading local " + str, e2);
                }
            }
            return null;
        }
        return null;
    }

    public static a<com.qq.e.comm.managers.setting.a> a(Context context) {
        Pair<String, String> a2 = a(context, "devCloudSetting");
        if (a2 == null) {
            return null;
        }
        return new a<>((String) a2.first, new com.qq.e.comm.managers.setting.a((String) a2.second), (byte) 0);
    }

    public static boolean a(Context context, String str, String str2) {
        return a(context, "sdkCloudSetting", str, str2);
    }

    public static final boolean a(Context context, String str, String str2, String str3) {
        String format;
        if (StringUtil.isEmpty(str2) || StringUtil.isEmpty(str3)) {
            format = String.format("Fail to update Cloud setting due to sig or setting is empty,name=%s\tsig=%s\tsetting=%s", str, str2, str3);
        } else if (com.qq.e.comm.util.a.a().a(str2, str3)) {
            return b(context, str, str2, str3);
        } else {
            format = String.format("Fail to update Cloud setting due to sig verify fail,name=%s\tsig=%s\tsetting=%s", str, str2, str3);
        }
        GDTLogger.e(format);
        return false;
    }

    public static a<d> b(Context context) {
        Pair<String, String> a2 = a(context, "sdkCloudSetting");
        if (a2 == null) {
            return null;
        }
        return new a<>((String) a2.first, new d((String) a2.second), (byte) 0);
    }

    public static boolean b(Context context, String str, String str2) {
        return a(context, "devCloudSetting", str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0084 A[Catch: Exception -> 0x0087, TRY_LEAVE, TryCatch #5 {Exception -> 0x0087, blocks: (B:30:0x007f, B:32:0x0084), top: B:42:0x007f }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(Context context, String str, String str2, String str3) {
        FileWriter fileWriter;
        Throwable th;
        FileWriter fileWriter2;
        File dir = context.getDir(SystemUtil.buildNewPathByProcessName("e_qq_com_setting"), 0);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(dir, str + ".cfg");
        File file2 = new File(dir, str + ".sig");
        FileWriter fileWriter3 = null;
        try {
            fileWriter2 = new FileWriter(file);
            try {
                fileWriter2.write(str3);
                fileWriter = new FileWriter(file2);
                try {
                    fileWriter.write(str2);
                    try {
                        fileWriter2.close();
                        fileWriter.close();
                        return true;
                    } catch (Exception unused) {
                        return true;
                    }
                } catch (Exception unused2) {
                    fileWriter3 = fileWriter2;
                    try {
                        file.delete();
                        file2.delete();
                        if (fileWriter3 != null) {
                            try {
                                fileWriter3.close();
                            } catch (Exception unused3) {
                                return false;
                            }
                        }
                        if (fileWriter != null) {
                            fileWriter.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        fileWriter2 = fileWriter3;
                        th = th2;
                        if (fileWriter2 != null) {
                            try {
                                fileWriter2.close();
                            } catch (Exception unused4) {
                                throw th;
                            }
                        }
                        if (fileWriter != null) {
                            fileWriter.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (fileWriter2 != null) {
                    }
                    if (fileWriter != null) {
                    }
                    throw th;
                }
            } catch (Exception unused5) {
                fileWriter = null;
            } catch (Throwable th4) {
                fileWriter = null;
                th = th4;
            }
        } catch (Exception unused6) {
            fileWriter = null;
        } catch (Throwable th5) {
            fileWriter = null;
            th = th5;
            fileWriter2 = null;
        }
    }

    public static a<c> c(Context context) {
        Pair<String, String> a2 = a(context, "placementCloudSetting");
        if (a2 == null) {
            return null;
        }
        return new a<>((String) a2.first, new c((String) a2.second), (byte) 0);
    }

    public static boolean c(Context context, String str, String str2) {
        return a(context, "placementCloudSetting", str, str2);
    }

    public static void d(Context context) {
        File dir = context.getDir(SystemUtil.buildNewPathByProcessName("e_qq_com_setting"), 0);
        if (dir.exists()) {
            File file = new File(dir, "placementCloudSetting.cfg");
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(dir, "placementCloudSetting.sig");
            if (file2.exists()) {
                file2.delete();
            }
        }
    }
}
