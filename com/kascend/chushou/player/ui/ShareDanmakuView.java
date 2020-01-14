package com.kascend.chushou.player.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.ColorInt;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.span.SimpleDraweeSpanTextView;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.ChatInfo;
import com.kascend.chushou.d.e;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import tv.chushou.zues.c;
import tv.chushou.zues.toolkit.richtext.b;
import tv.chushou.zues.utils.h;
/* loaded from: classes4.dex */
public class ShareDanmakuView extends RelativeLayout implements Handler.Callback, View.OnClickListener {
    private JSONObject Jc;
    private Context a;
    private int e;
    private boolean g;
    private final LinkedList<ChatInfo> i;
    private SimpleDraweeSpanTextView mPX;
    private final c mZe;
    private a mZf;
    private ChatInfo mZg;

    /* loaded from: classes4.dex */
    public interface a {
        void a(ChatInfo chatInfo);
    }

    public ShareDanmakuView(Context context) {
        super(context);
        this.mZe = new c(this);
        this.g = false;
        this.i = new LinkedList<>();
        a(context);
    }

    public ShareDanmakuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mZe = new c(this);
        this.g = false;
        this.i = new LinkedList<>();
        a(context);
    }

    public ShareDanmakuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mZe = new c(this);
        this.g = false;
        this.i = new LinkedList<>();
        a(context);
    }

    private void a(Context context) {
        this.a = context;
        LayoutInflater.from(this.a).inflate(a.h.view_share_danmaku, (ViewGroup) this, true);
        this.mPX = (SimpleDraweeSpanTextView) findViewById(a.f.tv_content);
        TextView textView = (TextView) findViewById(a.f.tv_share_room);
        textView.setText(new tv.chushou.zues.widget.a.c().append(this.a.getString(a.i.videoplayer_danmaku_share)).O(this.a, a.e.videoplayer_danmaku_share_icon));
        textView.setOnClickListener(this);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                ChatInfo poll = this.i.poll();
                if (poll != null) {
                    a(poll);
                }
                if (this.i.isEmpty()) {
                    this.mZe.L(2, TimeUnit.SECONDS.toMillis(3L));
                    return true;
                }
                return true;
            case 2:
                d();
                return true;
            default:
                return true;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mZg != null && this.mZg.mItem != null) {
            e.a(this.a, this.mZg.mItem, this.Jc);
        }
    }

    public void a(Context context, @ColorInt int i, a aVar, String str) {
        if (context != null) {
            this.a = context;
        }
        this.e = i;
        this.mZf = aVar;
        if (!h.isEmpty(str)) {
            try {
                this.Jc = new JSONObject(str);
            } catch (JSONException e) {
            }
        }
    }

    public void a(List<ChatInfo> list) {
        if (!h.isEmpty(list)) {
            this.mZe.removeMessages(2);
            this.mZe.removeMessages(1);
            if (!this.g) {
                c();
                a(list.remove(0));
            }
            this.i.addAll(list);
            if (h.isEmpty(this.i)) {
                this.mZe.L(2, TimeUnit.SECONDS.toMillis(3L));
                return;
            }
            int size = this.i.size();
            for (int i = 0; i < size; i++) {
                this.mZe.L(1, TimeUnit.SECONDS.toMillis(i + 1));
            }
        }
    }

    public void a() {
        this.i.clear();
        this.mZe.cp(null);
    }

    public void b() {
        this.mZg = null;
        this.i.clear();
        this.mZe.cp(null);
        d();
    }

    private void c() {
        if (!this.g) {
            this.g = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this.a, a.C0682a.videoplayer_share_danmaku_in);
            setVisibility(0);
            startAnimation(loadAnimation);
        }
    }

    private void d() {
        if (this.g) {
            this.g = false;
            Animation loadAnimation = AnimationUtils.loadAnimation(this.a, a.C0682a.videoplayer_share_danmaku_out);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.ShareDanmakuView.1
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    ShareDanmakuView.this.setVisibility(8);
                    if (ShareDanmakuView.this.mZg != null && ShareDanmakuView.this.mZf != null) {
                        ShareDanmakuView.this.mZf.a(ShareDanmakuView.this.mZg);
                    }
                    ShareDanmakuView.this.mZg = null;
                }
            });
            startAnimation(loadAnimation);
        }
    }

    private void a(ChatInfo chatInfo) {
        if (this.mZg != null && this.mZf != null) {
            this.mZf.a(this.mZg);
        }
        this.mZg = chatInfo;
        tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
        if (!b.a(this.a, cVar, chatInfo.mContentRichText, 14, this.e, this.mPX, null, null)) {
            cVar.a(chatInfo.mContent, new ForegroundColorSpan(this.a.getResources().getColor(a.c.banrrage_chat_text_color)));
        }
        this.mPX.setDraweeSpanStringBuilder(cVar);
    }
}
