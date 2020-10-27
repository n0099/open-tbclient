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
    private Context f4143a;
    private JSONObject afv;
    private int e;
    private boolean g;
    private SimpleDraweeSpanTextView oZP;
    private final c piO;
    private a piP;
    private ChatInfo piQ;
    private final LinkedList<ChatInfo> piR;

    /* loaded from: classes6.dex */
    public interface a {
        void a(ChatInfo chatInfo);
    }

    public ShareDanmakuView(Context context) {
        super(context);
        this.piO = new c(this);
        this.g = false;
        this.piR = new LinkedList<>();
        a(context);
    }

    public ShareDanmakuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.piO = new c(this);
        this.g = false;
        this.piR = new LinkedList<>();
        a(context);
    }

    public ShareDanmakuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.piO = new c(this);
        this.g = false;
        this.piR = new LinkedList<>();
        a(context);
    }

    private void a(Context context) {
        this.f4143a = context;
        LayoutInflater.from(this.f4143a).inflate(a.h.view_share_danmaku, (ViewGroup) this, true);
        this.oZP = (SimpleDraweeSpanTextView) findViewById(a.f.tv_content);
        TextView textView = (TextView) findViewById(a.f.tv_share_room);
        textView.setText(new tv.chushou.zues.widget.a.c().append(this.f4143a.getString(a.i.videoplayer_danmaku_share)).Q(this.f4143a, a.e.videoplayer_danmaku_share_icon));
        textView.setOnClickListener(this);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                ChatInfo poll = this.piR.poll();
                if (poll != null) {
                    a(poll);
                }
                if (this.piR.isEmpty()) {
                    this.piO.E(2, TimeUnit.SECONDS.toMillis(3L));
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
        if (this.piQ != null && this.piQ.mItem != null) {
            e.a(this.f4143a, this.piQ.mItem, this.afv);
        }
    }

    public void a(Context context, @ColorInt int i, a aVar, String str) {
        if (context != null) {
            this.f4143a = context;
        }
        this.e = i;
        this.piP = aVar;
        if (!h.isEmpty(str)) {
            try {
                this.afv = new JSONObject(str);
            } catch (JSONException e) {
            }
        }
    }

    public void a(List<ChatInfo> list) {
        if (!h.isEmpty(list)) {
            this.piO.removeMessages(2);
            this.piO.removeMessages(1);
            if (!this.g) {
                c();
                a(list.remove(0));
            }
            this.piR.addAll(list);
            if (h.isEmpty(this.piR)) {
                this.piO.E(2, TimeUnit.SECONDS.toMillis(3L));
                return;
            }
            int size = this.piR.size();
            for (int i = 0; i < size; i++) {
                this.piO.E(1, TimeUnit.SECONDS.toMillis(i + 1));
            }
        }
    }

    public void a() {
        this.piR.clear();
        this.piO.cs(null);
    }

    public void b() {
        this.piQ = null;
        this.piR.clear();
        this.piO.cs(null);
        d();
    }

    private void c() {
        if (!this.g) {
            this.g = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f4143a, a.C0969a.videoplayer_share_danmaku_in);
            setVisibility(0);
            startAnimation(loadAnimation);
        }
    }

    private void d() {
        if (this.g) {
            this.g = false;
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f4143a, a.C0969a.videoplayer_share_danmaku_out);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.ShareDanmakuView.1
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    ShareDanmakuView.this.setVisibility(8);
                    if (ShareDanmakuView.this.piQ != null && ShareDanmakuView.this.piP != null) {
                        ShareDanmakuView.this.piP.a(ShareDanmakuView.this.piQ);
                    }
                    ShareDanmakuView.this.piQ = null;
                }
            });
            startAnimation(loadAnimation);
        }
    }

    private void a(ChatInfo chatInfo) {
        if (this.piQ != null && this.piP != null) {
            this.piP.a(this.piQ);
        }
        this.piQ = chatInfo;
        tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
        if (!b.a(this.f4143a, cVar, chatInfo.mContentRichText, 14, this.e, this.oZP, null, null)) {
            cVar.a(chatInfo.mContent, new ForegroundColorSpan(this.f4143a.getResources().getColor(a.c.banrrage_chat_text_color)));
        }
        this.oZP.setDraweeSpanStringBuilder(cVar);
    }
}
