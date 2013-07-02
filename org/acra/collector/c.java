package org.acra.collector;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Environment;
import android.text.format.Time;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.acra.ReportField;
/* loaded from: classes.dex */
public final class c {
    private final Context a;
    private final SharedPreferences b;
    private final List c;
    private final Map d = new HashMap();
    private final Time e;
    private final String f;

    public c(Context context, SharedPreferences sharedPreferences, Time time, String str) {
        this.a = context;
        this.b = sharedPreferences;
        this.e = time;
        this.f = str;
        org.acra.d d = org.acra.a.d();
        ReportField[] d2 = d.d();
        if (d2.length != 0) {
            Log.d(org.acra.a.a, "Using custom Report Fields");
        } else if (d.o() == null || "".equals(d.o())) {
            Log.d(org.acra.a.a, "Using default Report Fields");
            d2 = org.acra.a.d;
        } else {
            Log.d(org.acra.a.a, "Using default Mail Report Fields");
            d2 = org.acra.a.c;
        }
        this.c = Arrays.asList(d2);
    }

    public String a(String str, String str2) {
        return (String) this.d.put(str, str2);
    }

    public CrashReportData a(Throwable th, boolean z, Thread thread) {
        String a;
        CrashReportData crashReportData = new CrashReportData();
        try {
            crashReportData.put((CrashReportData) ReportField.STACK_TRACE, (ReportField) a(th));
            crashReportData.put((CrashReportData) ReportField.USER_APP_START_DATE, (ReportField) this.e.format3339(false));
            if (z) {
                crashReportData.put((CrashReportData) ReportField.IS_SILENT, (ReportField) "true");
            }
            if (this.c.contains(ReportField.REPORT_ID)) {
                crashReportData.put((CrashReportData) ReportField.REPORT_ID, (ReportField) UUID.randomUUID().toString());
            }
            if (this.c.contains(ReportField.INSTALLATION_ID)) {
                crashReportData.put((CrashReportData) ReportField.INSTALLATION_ID, (ReportField) org.acra.util.e.a(this.a));
            }
            if (this.c.contains(ReportField.INITIAL_CONFIGURATION)) {
                crashReportData.put((CrashReportData) ReportField.INITIAL_CONFIGURATION, (ReportField) this.f);
            }
            if (this.c.contains(ReportField.CRASH_CONFIGURATION)) {
                crashReportData.put((CrashReportData) ReportField.CRASH_CONFIGURATION, (ReportField) b.a(this.a));
            }
            if (!(th instanceof OutOfMemoryError) && this.c.contains(ReportField.DUMPSYS_MEMINFO)) {
                crashReportData.put((CrashReportData) ReportField.DUMPSYS_MEMINFO, (ReportField) f.a());
            }
            if (this.c.contains(ReportField.PACKAGE_NAME)) {
                crashReportData.put((CrashReportData) ReportField.PACKAGE_NAME, (ReportField) this.a.getPackageName());
            }
            if (this.c.contains(ReportField.BUILD)) {
                crashReportData.put((CrashReportData) ReportField.BUILD, (ReportField) j.a(Build.class));
            }
            if (this.c.contains(ReportField.PHONE_MODEL)) {
                crashReportData.put((CrashReportData) ReportField.PHONE_MODEL, (ReportField) Build.MODEL);
            }
            if (this.c.contains(ReportField.ANDROID_VERSION)) {
                crashReportData.put((CrashReportData) ReportField.ANDROID_VERSION, (ReportField) Build.VERSION.RELEASE);
            }
            if (this.c.contains(ReportField.BRAND)) {
                crashReportData.put((CrashReportData) ReportField.BRAND, (ReportField) Build.BRAND);
            }
            if (this.c.contains(ReportField.PRODUCT)) {
                crashReportData.put((CrashReportData) ReportField.PRODUCT, (ReportField) Build.PRODUCT);
            }
            if (this.c.contains(ReportField.TOTAL_MEM_SIZE)) {
                crashReportData.put((CrashReportData) ReportField.TOTAL_MEM_SIZE, (ReportField) Long.toString(org.acra.util.h.b()));
            }
            if (this.c.contains(ReportField.AVAILABLE_MEM_SIZE)) {
                crashReportData.put((CrashReportData) ReportField.AVAILABLE_MEM_SIZE, (ReportField) Long.toString(org.acra.util.h.a()));
            }
            if (this.c.contains(ReportField.FILE_PATH)) {
                crashReportData.put((CrashReportData) ReportField.FILE_PATH, (ReportField) org.acra.util.h.b(this.a));
            }
            if (this.c.contains(ReportField.DISPLAY)) {
                crashReportData.put((CrashReportData) ReportField.DISPLAY, (ReportField) org.acra.util.h.c(this.a));
            }
            if (this.c.contains(ReportField.USER_CRASH_DATE)) {
                Time time = new Time();
                time.setToNow();
                crashReportData.put((CrashReportData) ReportField.USER_CRASH_DATE, (ReportField) time.format3339(false));
            }
            if (this.c.contains(ReportField.CUSTOM_DATA)) {
                crashReportData.put((CrashReportData) ReportField.CUSTOM_DATA, (ReportField) a());
            }
            if (this.c.contains(ReportField.USER_EMAIL)) {
                crashReportData.put((CrashReportData) ReportField.USER_EMAIL, (ReportField) this.b.getString("acra.user.email", "N/A"));
            }
            if (this.c.contains(ReportField.DEVICE_FEATURES)) {
                crashReportData.put((CrashReportData) ReportField.DEVICE_FEATURES, (ReportField) d.a(this.a));
            }
            if (this.c.contains(ReportField.ENVIRONMENT)) {
                crashReportData.put((CrashReportData) ReportField.ENVIRONMENT, (ReportField) j.b(Environment.class));
            }
            if (this.c.contains(ReportField.SETTINGS_SYSTEM)) {
                crashReportData.put((CrashReportData) ReportField.SETTINGS_SYSTEM, (ReportField) k.a(this.a));
            }
            if (this.c.contains(ReportField.SETTINGS_SECURE)) {
                crashReportData.put((CrashReportData) ReportField.SETTINGS_SECURE, (ReportField) k.b(this.a));
            }
            if (this.c.contains(ReportField.SHARED_PREFERENCES)) {
                crashReportData.put((CrashReportData) ReportField.SHARED_PREFERENCES, (ReportField) l.a(this.a));
            }
            org.acra.util.g gVar = new org.acra.util.g(this.a);
            PackageInfo a2 = gVar.a();
            if (a2 != null) {
                if (this.c.contains(ReportField.APP_VERSION_CODE)) {
                    crashReportData.put((CrashReportData) ReportField.APP_VERSION_CODE, (ReportField) Integer.toString(a2.versionCode));
                }
                if (this.c.contains(ReportField.APP_VERSION_NAME)) {
                    crashReportData.put((CrashReportData) ReportField.APP_VERSION_NAME, (ReportField) (a2.versionName != null ? a2.versionName : "not set"));
                }
            } else {
                crashReportData.put((CrashReportData) ReportField.APP_VERSION_NAME, (ReportField) "Package info unavailable");
            }
            if (this.c.contains(ReportField.DEVICE_ID) && this.b.getBoolean("acra.deviceid.enable", true) && gVar.a("android.permission.READ_PHONE_STATE") && (a = org.acra.util.h.a(this.a)) != null) {
                crashReportData.put((CrashReportData) ReportField.DEVICE_ID, (ReportField) a);
            }
            if ((this.b.getBoolean("acra.syslog.enable", true) && gVar.a("android.permission.READ_LOGS")) || a.a() >= 16) {
                Log.i(org.acra.a.a, "READ_LOGS granted! ACRA can include LogCat and DropBox data.");
                if (this.c.contains(ReportField.LOGCAT)) {
                    crashReportData.put((CrashReportData) ReportField.LOGCAT, (ReportField) g.a(null));
                }
                if (this.c.contains(ReportField.EVENTSLOG)) {
                    crashReportData.put((CrashReportData) ReportField.EVENTSLOG, (ReportField) g.a("events"));
                }
                if (this.c.contains(ReportField.RADIOLOG)) {
                    crashReportData.put((CrashReportData) ReportField.RADIOLOG, (ReportField) g.a("radio"));
                }
                if (this.c.contains(ReportField.DROPBOX)) {
                    crashReportData.put((CrashReportData) ReportField.DROPBOX, (ReportField) e.a(this.a, org.acra.a.d().a()));
                }
            } else {
                Log.i(org.acra.a.a, "READ_LOGS not allowed. ACRA will not include LogCat and DropBox data.");
            }
            if (this.c.contains(ReportField.APPLICATION_LOG)) {
                crashReportData.put((CrashReportData) ReportField.APPLICATION_LOG, (ReportField) h.a(this.a, org.acra.a.d().I(), org.acra.a.d().J()));
            }
            if (this.c.contains(ReportField.MEDIA_CODEC_LIST)) {
                crashReportData.put((CrashReportData) ReportField.MEDIA_CODEC_LIST, (ReportField) MediaCodecListCollector.a());
            }
            if (this.c.contains(ReportField.THREAD_DETAILS)) {
                crashReportData.put((CrashReportData) ReportField.THREAD_DETAILS, (ReportField) m.a(thread));
            }
        } catch (FileNotFoundException e) {
            Log.e(org.acra.a.a, "Error : application log file " + org.acra.a.d().I() + " not found.", e);
        } catch (IOException e2) {
            Log.e(org.acra.a.a, "Error while reading application log file " + org.acra.a.d().I() + ".", e2);
        } catch (RuntimeException e3) {
            Log.e(org.acra.a.a, "Error while retrieving crash data", e3);
        }
        return crashReportData;
    }

    private String a() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.d.keySet()) {
            sb.append(str);
            sb.append(" = ");
            sb.append((String) this.d.get(str));
            sb.append("\n");
        }
        return sb.toString();
    }

    private String a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        while (th != null) {
            th.printStackTrace(printWriter);
            th = th.getCause();
        }
        String obj = stringWriter.toString();
        printWriter.close();
        return obj;
    }
}
