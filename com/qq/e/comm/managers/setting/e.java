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
/* loaded from: classes4.dex */
class e {

    /* renamed from: a  reason: collision with root package name */
    protected JSONObject f7572a;

    /* loaded from: classes4.dex */
    static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final String f7573a;
        private final T b;

        private a(String str, T t) {
            this.f7573a = str;
            this.b = t;
        }

        /* synthetic */ a(String str, Object obj, byte b) {
            this(str, obj);
        }

        public final String a() {
            return this.f7573a;
        }

        public final T b() {
            return this.b;
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
                this.f7572a = new JSONObject(str);
            } catch (JSONException e) {
                GDTLogger.e("JsonException While build" + simpleName + " Instance from JSON", e);
            }
        }
        if (this.f7572a == null) {
            this.f7572a = new JSONObject();
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

    /* JADX WARN: Removed duplicated region for block: B:27:0x0080 A[Catch: Exception -> 0x0084, TRY_LEAVE, TryCatch #8 {Exception -> 0x0084, blocks: (B:25:0x007b, B:27:0x0080), top: B:48:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean b(Context context, String str, String str2, String str3) {
        FileWriter fileWriter;
        FileWriter fileWriter2;
        File dir = context.getDir(SystemUtil.buildNewPathByProcessName("e_qq_com_setting"), 0);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(dir, str + ".cfg");
        File file2 = new File(dir, str + ".sig");
        try {
            fileWriter2 = new FileWriter(file);
        } catch (Exception e) {
            fileWriter = null;
            fileWriter2 = null;
        } catch (Throwable th) {
            th = th;
            fileWriter = null;
            fileWriter2 = null;
        }
        try {
            fileWriter2.write(str3);
            fileWriter = new FileWriter(file2);
            try {
                try {
                    fileWriter.write(str2);
                    try {
                        fileWriter2.close();
                        fileWriter.close();
                    } catch (Exception e2) {
                    }
                    return true;
                } catch (Exception e3) {
                    file.delete();
                    file2.delete();
                    if (fileWriter2 != null) {
                        try {
                            fileWriter2.close();
                        } catch (Exception e4) {
                            return false;
                        }
                    }
                    if (fileWriter != null) {
                        fileWriter.close();
                        return false;
                    }
                    return false;
                }
            } catch (Throwable th2) {
                th = th2;
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
            fileWriter = null;
        } catch (Throwable th3) {
            th = th3;
            fileWriter = null;
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
