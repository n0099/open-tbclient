package com.kascend.chushou.player.ui.pk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kascend.chushou.a;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class LivePKPrepareAnimView extends RelativeLayout {
    private TextView a;
    private ImageView b;
    private io.reactivex.disposables.b d;
    private int[] e;
    private AnimationSet mCy;
    private a mCz;

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    public LivePKPrepareAnimView(Context context) {
        super(context);
        this.e = new int[]{a.e.icon_live_pk_prepare_1, a.e.icon_live_pk_prepare_2, a.e.icon_live_pk_prepare_3, a.e.icon_live_pk_prepare_4, a.e.icon_live_pk_prepare_5, a.e.icon_live_pk_prepare_6, a.e.icon_live_pk_prepare_7, a.e.icon_live_pk_prepare_8, a.e.icon_live_pk_prepare_9};
        a(context);
    }

    public LivePKPrepareAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new int[]{a.e.icon_live_pk_prepare_1, a.e.icon_live_pk_prepare_2, a.e.icon_live_pk_prepare_3, a.e.icon_live_pk_prepare_4, a.e.icon_live_pk_prepare_5, a.e.icon_live_pk_prepare_6, a.e.icon_live_pk_prepare_7, a.e.icon_live_pk_prepare_8, a.e.icon_live_pk_prepare_9};
        a(context);
    }

    public LivePKPrepareAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new int[]{a.e.icon_live_pk_prepare_1, a.e.icon_live_pk_prepare_2, a.e.icon_live_pk_prepare_3, a.e.icon_live_pk_prepare_4, a.e.icon_live_pk_prepare_5, a.e.icon_live_pk_prepare_6, a.e.icon_live_pk_prepare_7, a.e.icon_live_pk_prepare_8, a.e.icon_live_pk_prepare_9};
        a(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        b();
        super.onDetachedFromWindow();
    }

    private void a(Context context) {
        inflate(context, a.h.layout_live_pk_prepare_anim_view, this);
        this.a = (TextView) findViewById(a.f.tv_live_pk_prepare);
        this.b = (ImageView) findViewById(a.f.img_live_pk_prepare);
        this.mCy = (AnimationSet) AnimationUtils.loadAnimation(context, a.C0736a.pk_live_online_count_down_last_three);
    }

    private void b() {
        a();
    }

    public void a(final long j) {
        if (j <= 0) {
            if (this.mCz != null) {
                this.mCz.a();
                return;
            }
            return;
        }
        setVisibility(0);
        this.d = io.reactivex.g.a(0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.dCE()).b(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.pk.LivePKPrepareAnimView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // io.reactivex.c.g
            /* renamed from: a */
            public void accept(Long l) throws Exception {
                int longValue = (int) (j - l.longValue());
                if (longValue == j) {
                    LivePKPrepareAnimView.this.a.setVisibility(0);
                    LivePKPrepareAnimView.this.b.setVisibility(8);
                } else if (longValue > 0) {
                    if (longValue <= LivePKPrepareAnimView.this.e.length) {
                        LivePKPrepareAnimView.this.a.setVisibility(8);
                        LivePKPrepareAnimView.this.b.setVisibility(0);
                        LivePKPrepareAnimView.this.b.setImageResource(LivePKPrepareAnimView.this.e[longValue - 1]);
                        LivePKPrepareAnimView.this.b.startAnimation(LivePKPrepareAnimView.this.mCy);
                    }
                } else if (longValue <= 0) {
                    LivePKPrepareAnimView.this.a();
                    if (LivePKPrepareAnimView.this.mCz != null) {
                        LivePKPrepareAnimView.this.mCz.a();
                    }
                }
            }
        });
    }

    public void a() {
        if (this.d != null) {
            this.d.dispose();
            this.d = null;
        }
        this.b.clearAnimation();
        this.b.setVisibility(8);
        this.a.setVisibility(8);
        setVisibility(8);
    }

    public void setCallBack(a aVar) {
        this.mCz = aVar;
    }
}
