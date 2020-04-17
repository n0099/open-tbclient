package com.kascend.chushou.player.ui.pk;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kascend.chushou.a;
import com.kascend.chushou.player.ui.pk.LivePKBar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class LivePKBarStatus extends FrameLayout implements View.OnClickListener {
    private long b;
    private int c;
    private io.reactivex.disposables.b d;
    private long e;
    private TextView f;
    private LinearLayout g;
    private TextView h;
    private TextView i;
    private TextView j;
    private io.reactivex.disposables.b mAR;
    private a mCc;
    private LivePKBar.b mCd;

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    public LivePKBarStatus(Context context) {
        super(context);
        this.c = 30;
        a(context);
    }

    public LivePKBarStatus(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 30;
        a(context);
    }

    public LivePKBarStatus(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = 30;
        a(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        d();
        super.onDetachedFromWindow();
    }

    private void a(Context context) {
        inflate(context, a.h.layout_online_live_pk_bar_status, this);
        this.f = (TextView) findViewById(a.f.tv_pk_last_seconds);
        this.g = (LinearLayout) findViewById(a.f.ll_pk_counter);
        this.h = (TextView) findViewById(a.f.tv_pk_counter_tip);
        this.i = (TextView) findViewById(a.f.tv_pk_counter_time);
        this.j = (TextView) findViewById(a.f.tv_pk_stop_pk);
        this.j.setOnClickListener(this);
    }

    public void a() {
        d();
        setVisibility(8);
    }

    public void a(long j) {
        setVisibility(0);
        e();
        this.e = j;
        this.g.setVisibility(0);
        this.f.setVisibility(8);
        this.h.setVisibility(8);
        this.i.setVisibility(0);
        this.d = io.reactivex.g.a(0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.dCH()).b(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.pk.LivePKBarStatus.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // io.reactivex.c.g
            /* renamed from: a */
            public void accept(Long l) throws Exception {
                long longValue = LivePKBarStatus.this.e - l.longValue();
                LivePKBarStatus.this.i.setText(LivePKBarStatus.this.d(longValue));
                if (longValue <= 0) {
                    LivePKBarStatus.this.g();
                }
                if (LivePKBarStatus.this.mCd != null) {
                    LivePKBarStatus.this.mCd.b(longValue);
                }
            }
        });
    }

    public void b() {
        this.f.setVisibility(8);
    }

    private void d() {
        e();
    }

    public void c() {
        setVisibility(0);
        d();
        this.g.setVisibility(0);
        this.f.setVisibility(8);
        this.h.setVisibility(0);
        this.h.setText(a.i.str_live_online_live_pk_wait);
        this.i.setVisibility(8);
        this.j.setVisibility(8);
    }

    public void b(long j) {
        setVisibility(0);
        e();
        this.b = j;
        this.mAR = io.reactivex.g.a(0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.dCH()).b(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.pk.LivePKBarStatus.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // io.reactivex.c.g
            /* renamed from: a */
            public void accept(Long l) throws Exception {
                LivePKBarStatus.this.c(LivePKBarStatus.this.b - l.longValue());
            }
        });
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(int i, boolean z) {
        this.h.setVisibility(0);
        this.h.setText(i == 2 ? a.i.str_live_online_live_pk_in_stopping : a.i.str_live_online_live_pk_loss);
        this.j.setVisibility(z ? 0 : 8);
    }

    public void b(int i, boolean z) {
        if (i == 2) {
            this.h.setVisibility(0);
            this.h.setText(a.i.str_live_online_live_pk_in_stopping);
        } else {
            this.h.setVisibility(8);
        }
        this.j.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        if (j <= this.c) {
            this.g.setVisibility(8);
            this.f.setVisibility(0);
            this.f.setText(String.valueOf(j));
        } else {
            this.g.setVisibility(0);
            this.f.setVisibility(8);
            this.h.setVisibility(0);
            this.h.setText(a.i.str_live_online_live_pk_ing);
            this.i.setVisibility(0);
            this.j.setVisibility(8);
            this.i.setText(d(j));
        }
        if (j <= 0) {
            f();
        }
        if (this.mCd != null) {
            this.mCd.a(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(long j) {
        if (j <= 0) {
            return "00:00";
        }
        long minutes = TimeUnit.SECONDS.toMinutes(j);
        return String.format(Locale.CHINA, "%02d:%02d", Long.valueOf(minutes), Long.valueOf(TimeUnit.SECONDS.toSeconds(j - TimeUnit.MINUTES.toSeconds(minutes))));
    }

    private void e() {
        f();
        g();
    }

    private void f() {
        if (this.mAR != null) {
            this.mAR.dispose();
            this.mAR = null;
            this.b = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.d != null) {
            this.d.dispose();
            this.d = null;
            this.e = 0L;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.j && this.mCc != null) {
            this.mCc.a();
        }
    }

    public void setClickListener(a aVar) {
        this.mCc = aVar;
    }

    public void setCounterListener(LivePKBar.b bVar) {
        this.mCd = bVar;
    }
}
