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
/* loaded from: classes6.dex */
public class ShareDanmakuView extends RelativeLayout implements Handler.Callback, View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f4145a;
    private JSONObject afu;
    private int e;
    private boolean g;
    private SimpleDraweeSpanTextView oiA;
    private final LinkedList<ChatInfo> orA;
    private final c orx;
    private a ory;
    private ChatInfo orz;

    /* loaded from: classes6.dex */
    public interface a {
        void a(ChatInfo chatInfo);
    }

    public ShareDanmakuView(Context context) {
        super(context);
        this.orx = new c(this);
        this.g = false;
        this.orA = new LinkedList<>();
        a(context);
    }

    public ShareDanmakuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orx = new c(this);
        this.g = false;
        this.orA = new LinkedList<>();
        a(context);
    }

    public ShareDanmakuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orx = new c(this);
        this.g = false;
        this.orA = new LinkedList<>();
        a(context);
    }

    private void a(Context context) {
        this.f4145a = context;
        LayoutInflater.from(this.f4145a).inflate(a.h.view_share_danmaku, (ViewGroup) this, true);
        this.oiA = (SimpleDraweeSpanTextView) findViewById(a.f.tv_content);
        TextView textView = (TextView) findViewById(a.f.tv_share_room);
        textView.setText(new tv.chushou.zues.widget.a.c().append(this.f4145a.getString(a.i.videoplayer_danmaku_share)).N(this.f4145a, a.e.videoplayer_danmaku_share_icon));
        textView.setOnClickListener(this);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                ChatInfo poll = this.orA.poll();
                if (poll != null) {
                    a(poll);
                }
                if (this.orA.isEmpty()) {
                    this.orx.D(2, TimeUnit.SECONDS.toMillis(3L));
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
        if (this.orz != null && this.orz.mItem != null) {
            e.a(this.f4145a, this.orz.mItem, this.afu);
        }
    }

    public void a(Context context, @ColorInt int i, a aVar, String str) {
        if (context != null) {
            this.f4145a = context;
        }
        this.e = i;
        this.ory = aVar;
        if (!h.isEmpty(str)) {
            try {
                this.afu = new JSONObject(str);
            } catch (JSONException e) {
            }
        }
    }

    public void a(List<ChatInfo> list) {
        if (!h.isEmpty(list)) {
            this.orx.removeMessages(2);
            this.orx.removeMessages(1);
            if (!this.g) {
                c();
                a(list.remove(0));
            }
            this.orA.addAll(list);
            if (h.isEmpty(this.orA)) {
                this.orx.D(2, TimeUnit.SECONDS.toMillis(3L));
                return;
            }
            int size = this.orA.size();
            for (int i = 0; i < size; i++) {
                this.orx.D(1, TimeUnit.SECONDS.toMillis(i + 1));
            }
        }
    }

    public void a() {
        this.orA.clear();
        this.orx.co(null);
    }

    public void b() {
        this.orz = null;
        this.orA.clear();
        this.orx.co(null);
        d();
    }

    private void c() {
        if (!this.g) {
            this.g = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f4145a, a.C0897a.videoplayer_share_danmaku_in);
            setVisibility(0);
            startAnimation(loadAnimation);
        }
    }

    private void d() {
        if (this.g) {
            this.g = false;
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f4145a, a.C0897a.videoplayer_share_danmaku_out);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.ShareDanmakuView.1
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    ShareDanmakuView.this.setVisibility(8);
                    if (ShareDanmakuView.this.orz != null && ShareDanmakuView.this.ory != null) {
                        ShareDanmakuView.this.ory.a(ShareDanmakuView.this.orz);
                    }
                    ShareDanmakuView.this.orz = null;
                }
            });
            startAnimation(loadAnimation);
        }
    }

    private void a(ChatInfo chatInfo) {
        if (this.orz != null && this.ory != null) {
            this.ory.a(this.orz);
        }
        this.orz = chatInfo;
        tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
        if (!b.a(this.f4145a, cVar, chatInfo.mContentRichText, 14, this.e, this.oiA, null, null)) {
            cVar.a(chatInfo.mContent, new ForegroundColorSpan(this.f4145a.getResources().getColor(a.c.banrrage_chat_text_color)));
        }
        this.oiA.setDraweeSpanStringBuilder(cVar);
    }
}
