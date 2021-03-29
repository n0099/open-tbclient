package d.f.b.a;

import android.os.Process;
import android.util.Log;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes6.dex */
public class h extends a {

    /* renamed from: d  reason: collision with root package name */
    public StringBuffer f66026d;

    /* renamed from: e  reason: collision with root package name */
    public int f66027e;

    /* renamed from: f  reason: collision with root package name */
    public long f66028f;

    /* renamed from: g  reason: collision with root package name */
    public long f66029g;

    public h(long j) {
        super(j);
        this.f66026d = new StringBuffer();
        this.f66027e = 0;
        this.f66028f = 0L;
        this.f66029g = 0L;
    }

    @Override // d.f.b.a.a
    public void b() {
        BufferedReader bufferedReader;
        this.f66026d.setLength(0);
        BufferedReader bufferedReader2 = null;
        try {
            try {
                BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/stat")), 1000);
                try {
                    String readLine = bufferedReader3.readLine();
                    String str = "";
                    if (readLine == null) {
                        readLine = "";
                    }
                    if (this.f66027e == 0) {
                        this.f66027e = Process.myPid();
                    }
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + this.f66027e + "/stat")), 1000);
                    try {
                        String readLine2 = bufferedReader.readLine();
                        if (readLine2 != null) {
                            str = readLine2;
                        }
                        f(readLine, str);
                        bufferedReader3.close();
                        bufferedReader.close();
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader2 = bufferedReader3;
                        try {
                            Log.e("SampleCpuSampler", "doSample: ", th);
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                        } catch (Throwable th2) {
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e2) {
                                    Log.e("SampleCpuSampler", "doSample: ", e2);
                                    throw th2;
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
        } catch (IOException e3) {
            Log.e("SampleCpuSampler", "doSample: ", e3);
        }
    }

    @Override // d.f.b.a.a
    public void c() {
        super.c();
        g();
    }

    public String e() {
        return this.f66026d.toString();
    }

    public final void f(String str, String str2) {
        String[] split = str.split(" ");
        if (split.length < 9) {
            return;
        }
        long parseLong = Long.parseLong(split[2]);
        long parseLong2 = Long.parseLong(split[3]);
        long parseLong3 = Long.parseLong(split[4]);
        long parseLong4 = Long.parseLong(split[5]);
        long parseLong5 = parseLong + parseLong2 + parseLong3 + parseLong4 + Long.parseLong(split[6]) + Long.parseLong(split[7]) + Long.parseLong(split[8]);
        if (str2.split(" ").length < 17) {
            return;
        }
        if (parseLong5 != 0) {
            long j = parseLong5 - this.f66029g;
            this.f66026d.append(((j - (parseLong4 - this.f66028f)) * 100) / j);
        }
        this.f66028f = parseLong4;
        this.f66029g = parseLong5;
    }

    public final void g() {
        this.f66028f = 0L;
        this.f66029g = 0L;
    }
}
