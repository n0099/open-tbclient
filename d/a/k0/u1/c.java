package d.a.k0.u1;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f62133a;

    /* renamed from: b  reason: collision with root package name */
    public Context f62134b;

    /* renamed from: c  reason: collision with root package name */
    public HandlerThread f62135c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f62136d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f62137e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f62138f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f62139g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f62140h;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f62137e != null) {
                ((WindowManager) c.this.f62134b.getSystemService("window")).removeViewImmediate(c.this.f62137e);
                c.this.e();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            cVar.k(cVar.f62134b.getString(R.string.data_init));
        }
    }

    /* renamed from: d.a.k0.u1.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1674c {
        c getSplash();
    }

    /* loaded from: classes3.dex */
    public class d extends TextView {

        /* renamed from: e  reason: collision with root package name */
        public LinearGradient f62143e;

        /* renamed from: f  reason: collision with root package name */
        public Matrix f62144f;

        /* renamed from: g  reason: collision with root package name */
        public Paint f62145g;

        /* renamed from: h  reason: collision with root package name */
        public int f62146h;

        /* renamed from: i  reason: collision with root package name */
        public int f62147i;
        public boolean j;

        public d(c cVar, Context context) {
            super(context);
            this.f62146h = 0;
            this.f62147i = 0;
            this.j = true;
        }

        @Override // android.widget.TextView, android.view.View
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (!this.j || this.f62144f == null) {
                return;
            }
            int i2 = this.f62147i;
            int i3 = this.f62146h;
            int i4 = i2 + (i3 / 10);
            this.f62147i = i4;
            if (i4 > i3 * 2) {
                this.f62147i = -i3;
            }
            this.f62144f.setTranslate(this.f62147i, 0.0f);
            this.f62143e.setLocalMatrix(this.f62144f);
            postInvalidateDelayed(50L);
        }

        @Override // android.view.View
        public void onSizeChanged(int i2, int i3, int i4, int i5) {
            super.onSizeChanged(i2, i3, i4, i5);
            if (this.f62146h == 0) {
                int measuredWidth = getMeasuredWidth();
                this.f62146h = measuredWidth;
                if (measuredWidth > 0) {
                    this.f62145g = getPaint();
                    LinearGradient linearGradient = new LinearGradient(-this.f62146h, 0.0f, 0.0f, 0.0f, new int[]{1610612736, Integer.MAX_VALUE, 1610612736}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
                    this.f62143e = linearGradient;
                    this.f62145g.setShader(linearGradient);
                    this.f62144f = new Matrix();
                }
            }
        }
    }

    public c(Context context) {
        this.f62134b = context;
    }

    public final void e() {
        Handler handler = this.f62136d;
        if (handler != null) {
            handler.removeCallbacks(this.f62139g);
            this.f62136d.removeCallbacks(this.f62140h);
            this.f62140h = null;
            this.f62139g = null;
            this.f62136d = null;
        }
        HandlerThread handlerThread = this.f62135c;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        if (this.f62138f != null) {
            this.f62138f = null;
        }
        if (this.f62137e != null) {
            this.f62137e = null;
        }
        this.f62133a = false;
    }

    public final List<String> f(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("com.baidu.tieba.SPLASH_PIPELINE_ACTION");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 64);
        ArrayList arrayList = new ArrayList();
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            String packageName = context.getPackageName();
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                String str = resolveInfo.activityInfo.name;
                arrayList.add(StringUtil.ARRAY_START + packageName + "/" + str + "}");
            }
        }
        return arrayList;
    }

    public void g() {
        if (this.f62137e == null || this.f62138f == null) {
            return;
        }
        this.f62136d.removeCallbacks(this.f62139g);
        this.f62136d.post(this.f62139g);
    }

    public final boolean h() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) this.f62134b.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return false;
        }
        String packageName = this.f62134b.getPackageName();
        int myPid = Process.myPid();
        for (int i2 = 0; i2 < runningAppProcesses.size(); i2++) {
            if (runningAppProcesses.get(i2).pid == myPid && TextUtils.equals(runningAppProcesses.get(i2).processName, packageName)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean i() {
        List<String> f2 = f(this.f62134b);
        if (f2 != null && f2.size() != 0) {
            ActivityManager.RunningTaskInfo runningTaskInfo = ((ActivityManager) this.f62134b.getSystemService("activity")).getRunningTasks(1).get(0);
            String shortString = runningTaskInfo.baseActivity.toShortString();
            String shortString2 = runningTaskInfo.topActivity.toShortString();
            for (String str : f2) {
                if (shortString.equals(str) || shortString2.equals(str)) {
                    return true;
                }
                while (r0.hasNext()) {
                }
            }
        }
        return false;
    }

    public void j() {
        if (!this.f62133a && h() && i()) {
            if (this.f62135c == null) {
                HandlerThread handlerThread = new HandlerThread("splash-thread");
                this.f62135c = handlerThread;
                handlerThread.start();
            }
            if (this.f62136d == null) {
                this.f62136d = new Handler(this.f62135c.getLooper());
            }
            if (this.f62139g == null) {
                this.f62139g = new a();
            }
            if (this.f62140h == null) {
                this.f62140h = new b();
            }
            this.f62136d.removeCallbacks(this.f62140h);
            this.f62136d.postAtFrontOfQueue(this.f62140h);
            this.f62133a = true;
            this.f62136d.postDelayed(this.f62139g, 20000L);
        }
    }

    public final void k(String str) {
        if (this.f62138f == null) {
            d dVar = new d(this, this.f62134b);
            this.f62138f = dVar;
            dVar.setTextSize(1, 18.0f);
        }
        this.f62138f.setText(str);
        RelativeLayout relativeLayout = new RelativeLayout(this.f62134b);
        this.f62137e = relativeLayout;
        relativeLayout.setBackgroundResource(R.drawable.pic_splash_logo);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        this.f62137e.addView(this.f62138f, layoutParams);
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        layoutParams2.type = 2005;
        layoutParams2.format = 1;
        layoutParams2.gravity = 17;
        layoutParams2.x = 0;
        layoutParams2.y = 0;
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        layoutParams2.flags = 1280;
        ((WindowManager) this.f62134b.getSystemService("window")).addView(this.f62137e, layoutParams2);
    }
}
