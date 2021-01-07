package com.bytedance.tea.crash.a;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.ar.pose.PoseAR;
import com.bytedance.tea.crash.g.j;
import com.bytedance.tea.crash.g.m;
import com.bytedance.tea.crash.h;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    static volatile boolean f7912a = true;
    private final Context d;
    private volatile long e;
    private volatile boolean f = false;
    private final SharedPreferences pgI;
    private a ppM;
    private d ppN;

    public c(Context context) {
        if (context == null || !(context instanceof Application)) {
            throw new IllegalArgumentException("context must not be null or not application");
        }
        this.d = context;
        this.pgI = this.d.getSharedPreferences("anr_monitor_table", 0);
        this.e = this.pgI.getLong("trace_anr_happen_time", 0L);
        g.a(100, 100);
    }

    public void a() {
        if (!this.f) {
            if (Build.VERSION.SDK_INT < 21) {
                this.ppM = new a(this, "/data/anr/", 8);
                this.ppM.startWatching();
            } else {
                this.ppN = new d(this);
            }
            this.f = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i, String str, int i2) {
        JSONObject z;
        JSONObject jSONObject = null;
        JSONArray b2 = g.b();
        long uptimeMillis = SystemClock.uptimeMillis();
        JSONObject it = g.it(uptimeMillis);
        JSONArray C = g.C(100, uptimeMillis);
        try {
            jSONObject = e.AP(f7912a);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String a2 = e.a(this.d, i2);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        if (i == 200 && (z = z(str, Process.myPid(), this.d.getPackageName())) != null && z.length() > 0) {
            jSONObject = z;
        }
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                jSONObject.put("pid", Process.myPid());
                jSONObject.put("package", this.d.getPackageName());
                jSONObject.put("is_remote_process", 0);
                com.bytedance.tea.crash.c.a aVar = new com.bytedance.tea.crash.c.a(new JSONObject());
                aVar.a("data", jSONObject.toString());
                aVar.a("is_anr", 1);
                aVar.a("timestamp", Long.valueOf(System.currentTimeMillis()));
                aVar.a(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, "anr");
                aVar.a("history_message", b2);
                aVar.a("current_message", it);
                aVar.a("pending_messages", C);
                aVar.a("anr_time", Long.valueOf(System.currentTimeMillis()));
                aVar.a("crash_time", Long.valueOf(System.currentTimeMillis()));
                aVar.a("anr_info", a2);
                aVar.a("all_thread_stacks", m.a((String) null));
                com.bytedance.tea.crash.c.a a3 = com.bytedance.tea.crash.e.a.e.esA().a(com.bytedance.tea.crash.c.ANR, aVar);
                com.bytedance.tea.crash.g.d.a(this.d, com.bytedance.tea.crash.c.ANR.a(), null);
                com.bytedance.tea.crash.upload.a.esK().b(a3.a());
                a(a2);
            } catch (Throwable th) {
                j.b(th);
            }
        }
        return true;
    }

    private static void a(String str) {
        for (com.bytedance.tea.crash.e eVar : h.esG().c()) {
            eVar.a(com.bytedance.tea.crash.c.ANR, str, null);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [248=8] */
    public JSONObject z(String str, int i, String str2) {
        BufferedReader bufferedReader;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || !file.canRead()) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                try {
                    Pattern compile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                    Pattern compile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                    Pattern compile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                    Pattern compile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                    Object[] a2 = a(bufferedReader, compile);
                    if (a2 == null) {
                        com.bytedance.tea.crash.g.f.a(bufferedReader);
                        return null;
                    }
                    long parseLong = Long.parseLong(a2[1].toString().split("\\s")[2]);
                    long time = simpleDateFormat.parse(a2[1].toString().split("\\s")[4] + " " + a2[1].toString().split("\\s")[5]).getTime();
                    Object[] a3 = a(bufferedReader, compile3);
                    if (a3 == null) {
                        com.bytedance.tea.crash.g.f.a(bufferedReader);
                        return null;
                    }
                    String str3 = a3[1].toString().split("\\s")[2];
                    if (parseLong != i || !str3.equalsIgnoreCase(str2)) {
                        com.bytedance.tea.crash.g.f.a(bufferedReader);
                        return null;
                    } else if (this.e != 0 && Math.abs(this.e - time) < 20000) {
                        com.bytedance.tea.crash.g.f.a(bufferedReader);
                        return null;
                    } else {
                        this.e = time;
                        if (this.pgI != null) {
                            this.pgI.edit().putLong("trace_anr_happen_time", this.e).apply();
                        }
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("anrTime", time);
                        boolean z = false;
                        while (true) {
                            Object[] a4 = a(bufferedReader, compile2, compile4);
                            if (a4 == null || a4[0] != compile4) {
                                break;
                            }
                            int i2 = -1;
                            Matcher matcher = Pattern.compile("\".+\"").matcher(a4[1].toString());
                            String substring = matcher.find() ? matcher.group().substring(1, matcher.group().length() - 1) : "";
                            Matcher matcher2 = Pattern.compile("tid=\\d+").matcher(a4[1].toString());
                            if (matcher2.find()) {
                                String group = matcher2.group();
                                i2 = Integer.parseInt(group.substring(group.indexOf("=") + 1));
                            }
                            String b2 = b(bufferedReader);
                            if (i2 != -1 && !TextUtils.isEmpty(substring) && !TextUtils.isEmpty(b2) && substring.equalsIgnoreCase("main")) {
                                jSONObject.put("mainStackFromTrace", b2);
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            com.bytedance.tea.crash.g.f.a(bufferedReader);
                            return null;
                        }
                        jSONObject.put("thread_number", 1);
                        com.bytedance.tea.crash.g.f.a(bufferedReader);
                        return jSONObject;
                    }
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    com.bytedance.tea.crash.g.f.a(bufferedReader);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                com.bytedance.tea.crash.g.f.a(bufferedReader);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
            com.bytedance.tea.crash.g.f.a(bufferedReader);
            throw th;
        }
    }

    private Object[] a(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        if (bufferedReader == null || patternArr == null || patternArr.length <= 0) {
            return null;
        }
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                int length = patternArr.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        Pattern pattern = patternArr[i];
                        if (pattern.matcher(readLine).matches()) {
                            return new Object[]{pattern, readLine};
                        }
                        i++;
                    }
                }
            } catch (Throwable th) {
            }
        }
        return null;
    }

    private String b(BufferedReader bufferedReader) throws IOException {
        if (bufferedReader == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null || readLine.trim().length() <= 0) {
                break;
            }
            sb.append(readLine).append("\n");
        }
        return sb.toString();
    }
}
