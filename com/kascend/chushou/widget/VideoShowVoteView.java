package com.kascend.chushou.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.kascend.chushou.a;
import com.kascend.chushou.bean.KaraokeBean;
import com.kascend.chushou.player.ui.pk.MutiTextHorizontalMarqueeView;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import tv.chushou.zues.c;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
/* loaded from: classes6.dex */
public class VideoShowVoteView extends FrameLayout implements View.OnClickListener {
    private TextView a;
    private int[] akn;
    private ProgressBar b;
    private LinearLayout d;
    private TextView f;
    private boolean h;
    private int i;
    private String j;
    private String k;
    private boolean m;
    private MutiTextHorizontalMarqueeView nFS;
    private c nFT;
    private a nFU;
    private FrescoThumbnailView nzJ;
    private String o;

    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    public VideoShowVoteView(@NonNull Context context) {
        this(context, null);
    }

    public VideoShowVoteView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = false;
        this.i = -1;
        this.j = "NO_ICON";
        this.k = "NO_MUSIC";
        this.akn = new int[]{a.e.icon_rank_0, a.e.icon_rank_1, a.e.icon_rank_2, a.e.icon_rank_3, a.e.icon_rank_4, a.e.icon_rank_5, a.e.icon_rank_6, a.e.icon_rank_7, a.e.icon_rank_8, a.e.icon_rank_9};
        inflate(context, a.h.layout_video_show_vote, this);
        this.a = (TextView) findViewById(a.f.tv_time);
        this.nzJ = (FrescoThumbnailView) findViewById(a.f.ftv_avatar);
        this.b = (ProgressBar) findViewById(a.f.pb);
        this.f = (TextView) findViewById(a.f.tv_current);
        this.d = (LinearLayout) findViewById(a.f.ll_level);
        this.nFS = (MutiTextHorizontalMarqueeView) findViewById(a.f.view_marquee);
        this.nFT = new c(new Handler.Callback() { // from class: com.kascend.chushou.widget.VideoShowVoteView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        long longValue = ((Long) message.obj).longValue();
                        if (longValue <= 0) {
                            VideoShowVoteView.this.a.setText(String.format(Locale.CHINA, "%02d:%02d", 0, 0));
                            break;
                        } else {
                            long minutes = TimeUnit.MILLISECONDS.toMinutes(longValue);
                            VideoShowVoteView.this.a.setText(String.format(Locale.CHINA, "%02d:%02d", Long.valueOf(minutes), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(longValue - TimeUnit.MINUTES.toMillis(minutes)))));
                            Message LV = VideoShowVoteView.this.nFT.LV(1);
                            LV.obj = Long.valueOf(longValue - 1000);
                            VideoShowVoteView.this.nFT.b(LV, 1000L);
                            break;
                        }
                }
                return false;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.fl_to_vote) {
        }
    }

    public void setStatusChangeListener(a aVar) {
        this.nFU = aVar;
    }

    public void a(KaraokeBean karaokeBean, String str, String str2) {
        String string;
        if (karaokeBean != null && karaokeBean.actingInfo != null && karaokeBean.actorState != -1) {
            setVisibility(0);
            if (!TextUtils.equals(this.o, karaokeBean.actingInfo.roomId)) {
                this.o = karaokeBean.actingInfo.roomId;
            }
            if (!this.m) {
                this.m = true;
                if (this.nFU != null) {
                    this.nFU.a();
                }
            }
            if (!this.h) {
                this.nFT.ch(null);
                long j = karaokeBean.actingInfo.finishTime - karaokeBean.actingInfo.currentTime;
                if (j > 0) {
                    this.h = true;
                    Message LV = this.nFT.LV(1);
                    LV.obj = Long.valueOf(j);
                    LV.sendToTarget();
                }
            }
            if (!TextUtils.equals(this.j, str)) {
                this.j = str;
                this.nzJ.bS(str, com.kascend.chushou.view.a.a(str2));
            }
            if (!TextUtils.equals(this.k, karaokeBean.actingInfo.musicName)) {
                if (!TextUtils.isEmpty(karaokeBean.actingInfo.musicName)) {
                    string = karaokeBean.actingInfo.musicName;
                } else {
                    string = getContext().getString(a.i.str_no_music);
                }
                if (!TextUtils.equals(this.k, string)) {
                    this.k = string;
                    a(string);
                }
            }
            KaraokeBean.GiftPower giftPower = karaokeBean.actingInfo.giftPower;
            if (giftPower != null) {
                a(giftPower.rank);
                long j2 = giftPower.end - giftPower.start;
                long j3 = giftPower.current - giftPower.start;
                if (j2 > 0) {
                    this.b.setProgress((int) ((j3 * 100) / j2));
                } else {
                    this.b.setProgress(100);
                }
                this.f.setText(String.valueOf(giftPower.current));
                return;
            }
            return;
        }
        setVisibility(8);
        this.nFT.ch(null);
        this.h = false;
        this.j = "NO_ICON";
        this.k = "NO_MUSIC";
        this.i = -1;
        this.m = false;
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            int dip2px = tv.chushou.zues.utils.a.dip2px(getContext(), 14.0f);
            int dip2px2 = tv.chushou.zues.utils.a.dip2px(getContext(), 75.0f);
            this.nFS.g();
            this.nFS.a();
            this.nFS.a(dip2px2);
            this.nFS.a(str, getResources().getColor(a.c.white), 9, 0, dip2px, true, 1, 2, 2, getResources().getColor(a.c.black));
            this.nFS.setScrollDirection(2);
            this.nFS.setDuration(4500);
            this.nFS.d();
            return;
        }
        this.nFS.g();
        this.nFS.a();
    }

    public String getRoomId() {
        return this.o;
    }

    private void a(int i) {
        if (i != this.i) {
            this.i = i;
            String valueOf = String.valueOf(i);
            int[] iArr = new int[valueOf.length()];
            for (int i2 = 0; i2 < valueOf.length(); i2++) {
                iArr[i2] = Integer.parseInt(String.valueOf(valueOf.charAt(i2)));
            }
            this.d.removeAllViews();
            for (int i3 : iArr) {
                int i4 = this.akn[i3];
                ImageView imageView = new ImageView(getContext());
                imageView.setImageResource(i4);
                this.d.addView(imageView, new LinearLayout.LayoutParams(-2, -2));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.nFS != null) {
            this.nFS.g();
        }
    }
}
