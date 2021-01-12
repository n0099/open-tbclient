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
/* loaded from: classes3.dex */
class e {

    /* renamed from: a  reason: collision with root package name */
    protected JSONObject f11556a;

    /* loaded from: classes3.dex */
    static final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final String f11557a;

        /* renamed from: b  reason: collision with root package name */
        private final T f11558b;

        private a(String str, T t) {
            this.f11557a = str;
            this.f11558b = t;
        }

        /* synthetic */ a(String str, Object obj, byte b2) {
            this(str, obj);
        }

        public final String a() {
            return this.f11557a;
        }

        public final T b() {
            return this.f11558b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(String str) {
        String simpleName = getClass().getSimpleName();
        GDTLogger.d("Initialize " + simpleName + ",Json=" + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                this.f11556a = new JSONObject(str);
            } catch (JSONException e) {
                GDTLogger.e("JsonException While build" + simpleName + " Instance from JSON", e);
            }
        }
        if (this.f11556a == null) {
            this.f11556a = new JSONObject();
        }
    }

    private static Pair<String, String> a(Context context, String str) {
        Pair<String, String> pair = null;
        File dir = context.getDir(SystemUtil.buildNewPathByProcessName("e_qq_com_setting"), 0);
        if (dir.exists()) {
            File file = new File(dir, str + ".sig");
            File file2 = new File(dir, str + ".cfg");
            if (file.exists() && file2.exists()) {
                try {
                    String readAll = StringUtil.readAll(file);
                    String readAll2 = StringUtil.readAll(file2);
                    if (TextUtils.isEmpty(readAll) || TextUtils.isEmpty(readAll2) || !com.qq.e.comm.util.a.a().a(readAll, readAll2)) {
                        GDTLogger.e("verify " + str + " setting fail");
                    } else {
                        pair = new Pair<>(readAll, new String(Base64.decode(readAll2, 0), "UTF-8"));
                    }
                } catch (Exception e) {
                    GDTLogger.e("exception while loading local " + str, e);
                }
            }
        }
        return pair;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a<com.qq.e.comm.managers.setting.a> a(Context context) {
        Pair<String, String> a2 = a(context, "devCloudSetting");
        if (a2 == null) {
            return null;
        }
        return new a<>((String) a2.first, new com.qq.e.comm.managers.setting.a((String) a2.second), (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context, String str, String str2) {
        return a(context, "sdkCloudSetting", str, str2);
    }

    private static final boolean a(Context context, String str, String str2, String str3) {
        if (StringUtil.isEmpty(str2) || StringUtil.isEmpty(str3)) {
            GDTLogger.e(String.format("Fail to update Cloud setting due to sig or setting is empty,name=%s\tsig=%s\tsetting=%s", str, str2, str3));
            return false;
        } else if (com.qq.e.comm.util.a.a().a(str2, str3)) {
            return b(context, str, str2, str3);
        } else {
            GDTLogger.e(String.format("Fail to update Cloud setting due to sig verify fail,name=%s\tsig=%s\tsetting=%s", str, str2, str3));
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a<d> b(Context context) {
        Pair<String, String> a2 = a(context, "sdkCloudSetting");
        if (a2 == null) {
            return null;
        }
        return new a<>((String) a2.first, new d((String) a2.second), (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(Context context, String str, String str2) {
        return a(context, "devCloudSetting", str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0083 A[Catch: Exception -> 0x0098, TRY_LEAVE, TryCatch #2 {Exception -> 0x0098, blocks: (B:25:0x007e, B:27:0x0083), top: B:42:0x007e }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean b(Context context, String str, String str2, String str3) {
        FileWriter fileWriter;
        FileWriter fileWriter2;
        Throwable th;
        FileWriter fileWriter3;
        FileWriter fileWriter4;
        File dir = context.getDir(SystemUtil.buildNewPathByProcessName("e_qq_com_setting"), 0);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(dir, str + ".cfg");
        File file2 = new File(dir, str + ".sig");
        try {
            fileWriter3 = new FileWriter(file);
        } catch (Exception e) {
            fileWriter3 = null;
            fileWriter4 = null;
        } catch (Throwable th2) {
            fileWriter = null;
            fileWriter2 = null;
            th = th2;
        }
        try {
            fileWriter3.write(str3);
            fileWriter4 = new FileWriter(file2);
            try {
                try {
                    fileWriter4.write(str2);
                    try {
                        fileWriter3.close();
                        fileWriter4.close();
                    } catch (Exception e2) {
                    }
                    return true;
                } catch (Exception e3) {
                    file.delete();
                    file2.delete();
                    if (fileWriter3 != null) {
                        try {
                            fileWriter3.close();
                        } catch (Exception e4) {
                            return false;
                        }
                    }
                    if (fileWriter4 != null) {
                        fileWriter4.close();
                        return false;
                    }
                    return false;
                }
            } catch (Throwable th3) {
                fileWriter = fileWriter4;
                fileWriter2 = fileWriter3;
                th = th3;
                if (fileWriter2 != null) {
                    try {
                        fileWriter2.close();
                    } catch (Exception e5) {
                        throw th;
                    }
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
                throw th;
            }
        } catch (Exception e6) {
            fileWriter4 = null;
        } catch (Throwable th4) {
            fileWriter = null;
            fileWriter2 = fileWriter3;
            th = th4;
            if (fileWriter2 != null) {
            }
            if (fileWriter != null) {
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a<c> c(Context context) {
        Pair<String, String> a2 = a(context, "placementCloudSetting");
        if (a2 == null) {
            return null;
        }
        return new a<>((String) a2.first, new c((String) a2.second), (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(Context context, String str, String str2) {
        return a(context, "placementCloudSetting", str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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
