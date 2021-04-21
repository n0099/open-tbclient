package d.b.j0.u1;

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
    public volatile boolean f63192a;

    /* renamed from: b  reason: collision with root package name */
    public Context f63193b;

    /* renamed from: c  reason: collision with root package name */
    public HandlerThread f63194c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f63195d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f63196e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f63197f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f63198g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f63199h;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f63196e != null) {
                ((WindowManager) c.this.f63193b.getSystemService("window")).removeViewImmediate(c.this.f63196e);
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
            cVar.k(cVar.f63193b.getString(R.string.data_init));
        }
    }

    /* renamed from: d.b.j0.u1.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1669c {
        c getSplash();
    }

    /* loaded from: classes3.dex */
    public class d extends TextView {

        /* renamed from: e  reason: collision with root package name */
        public LinearGradient f63202e;

        /* renamed from: f  reason: collision with root package name */
        public Matrix f63203f;

        /* renamed from: g  reason: collision with root package name */
        public Paint f63204g;

        /* renamed from: h  reason: collision with root package name */
        public int f63205h;
        public int i;
        public boolean j;

        public d(c cVar, Context context) {
            super(context);
            this.f63205h = 0;
            this.i = 0;
            this.j = true;
        }

        @Override // android.widget.TextView, android.view.View
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (!this.j || this.f63203f == null) {
                return;
            }
            int i = this.i;
            int i2 = this.f63205h;
            int i3 = i + (i2 / 10);
            this.i = i3;
            if (i3 > i2 * 2) {
                this.i = -i2;
            }
            this.f63203f.setTranslate(this.i, 0.0f);
            this.f63202e.setLocalMatrix(this.f63203f);
            postInvalidateDelayed(50L);
        }

        @Override // android.view.View
        public void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            if (this.f63205h == 0) {
                int measuredWidth = getMeasuredWidth();
                this.f63205h = measuredWidth;
                if (measuredWidth > 0) {
                    this.f63204g = getPaint();
                    LinearGradient linearGradient = new LinearGradient(-this.f63205h, 0.0f, 0.0f, 0.0f, new int[]{1610612736, Integer.MAX_VALUE, 1610612736}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
                    this.f63202e = linearGradient;
                    this.f63204g.setShader(linearGradient);
                    this.f63203f = new Matrix();
                }
            }
        }
    }

    public c(Context context) {
        this.f63193b = context;
    }

    public final void e() {
        Handler handler = this.f63195d;
        if (handler != null) {
            handler.removeCallbacks(this.f63198g);
            this.f63195d.removeCallbacks(this.f63199h);
            this.f63199h = null;
            this.f63198g = null;
            this.f63195d = null;
        }
        HandlerThread handlerThread = this.f63194c;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        if (this.f63197f != null) {
            this.f63197f = null;
        }
        if (this.f63196e != null) {
            this.f63196e = null;
        }
        this.f63192a = false;
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
        if (this.f63196e == null || this.f63197f == null) {
            return;
        }
        this.f63195d.removeCallbacks(this.f63198g);
        this.f63195d.post(this.f63198g);
    }

    public final boolean h() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) this.f63193b.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return false;
        }
        String packageName = this.f63193b.getPackageName();
        int myPid = Process.myPid();
        for (int i = 0; i < runningAppProcesses.size(); i++) {
            if (runningAppProcesses.get(i).pid == myPid && TextUtils.equals(runningAppProcesses.get(i).processName, packageName)) {
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
        List<String> f2 = f(this.f63193b);
        if (f2 != null && f2.size() != 0) {
            ActivityManager.RunningTaskInfo runningTaskInfo = ((ActivityManager) this.f63193b.getSystemService("activity")).getRunningTasks(1).get(0);
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
        if (!this.f63192a && h() && i()) {
            if (this.f63194c == null) {
                HandlerThread handlerThread = new HandlerThread("splash-thread");
                this.f63194c = handlerThread;
                handlerThread.start();
            }
            if (this.f63195d == null) {
                this.f63195d = new Handler(this.f63194c.getLooper());
            }
            if (this.f63198g == null) {
                this.f63198g = new a();
            }
            if (this.f63199h == null) {
                this.f63199h = new b();
            }
            this.f63195d.removeCallbacks(this.f63199h);
            this.f63195d.postAtFrontOfQueue(this.f63199h);
            this.f63192a = true;
            this.f63195d.postDelayed(this.f63198g, 20000L);
        }
    }

    public final void k(String str) {
        if (this.f63197f == null) {
            d dVar = new d(this, this.f63193b);
            this.f63197f = dVar;
            dVar.setTextSize(1, 18.0f);
        }
        this.f63197f.setText(str);
        RelativeLayout relativeLayout = new RelativeLayout(this.f63193b);
        this.f63196e = relativeLayout;
        relativeLayout.setBackgroundResource(R.drawable.pic_splash_logo);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        this.f63196e.addView(this.f63197f, layoutParams);
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        layoutParams2.type = 2005;
        layoutParams2.format = 1;
        layoutParams2.gravity = 17;
        layoutParams2.x = 0;
        layoutParams2.y = 0;
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        layoutParams2.flags = 1280;
        ((WindowManager) this.f63193b.getSystemService("window")).addView(this.f63196e, layoutParams2);
    }
}
