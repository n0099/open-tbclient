package d.b.i0.d1.f;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.widget.ShareFromFrsView;
import com.baidu.tieba.im.widget.ShareFromGameCenter;
import com.baidu.tieba.im.widget.ShareFromPBView;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView;
import java.util.Calendar;
/* loaded from: classes4.dex */
public class e extends d.b.b.a.c<MsglistActivity<?>> {

    /* renamed from: b  reason: collision with root package name */
    public d.b.b.e.h.a f53648b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.b.e.h.b f53649c;

    /* renamed from: d  reason: collision with root package name */
    public long f53650d;

    /* renamed from: e  reason: collision with root package name */
    public Calendar f53651e;

    /* renamed from: f  reason: collision with root package name */
    public int f53652f;

    /* renamed from: g  reason: collision with root package name */
    public long f53653g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f53654h;
    public TbRichTextView i;
    public ChatVoiceView j;
    public GifView k;
    public Invite2GroupView l;
    public ShareFromPBView m;
    public ShareFromFrsView n;
    public ShareFromGameCenter o;
    public ChatImageWithTailView p;
    public boolean q;
    public boolean r;
    public int s;

    /* loaded from: classes4.dex */
    public class a implements View.OnLongClickListener {
        public a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            e eVar = e.this;
            eVar.f53649c.onItemViewLongClick(view, 10, eVar.f53652f, 0L);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar = e.this;
            eVar.f53648b.onItemViewClick(view, 15, eVar.f53652f, 0L);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnLongClickListener {
        public c() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            e eVar = e.this;
            eVar.f53649c.onItemViewLongClick(view, 15, eVar.f53652f, 0L);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar = e.this;
            eVar.f53648b.onItemViewClick(view, 11, eVar.f53652f, 0L);
        }
    }

    /* renamed from: d.b.i0.d1.f.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1191e implements View.OnClickListener {
        public View$OnClickListenerC1191e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar = e.this;
            eVar.f53648b.onItemViewClick(view, 12, eVar.f53652f, 0L);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnLongClickListener {
        public f() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            e eVar = e.this;
            eVar.f53649c.onItemViewLongClick(view, 11, eVar.f53652f, 0L);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnLongClickListener {
        public g() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            e eVar = e.this;
            eVar.f53649c.onItemViewLongClick(view, 17, eVar.f53652f, 0L);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbRichTextView tbRichTextView = e.this.i;
            if (tbRichTextView == null || tbRichTextView.getTextView() == null) {
                return;
            }
            CharSequence text = e.this.i.getTextView().getText();
            if (TextUtils.isEmpty(text)) {
                return;
            }
            if (text.toString().contains("删贴") || text.toString().contains("删除")) {
                if (text.toString().contains("http://") || text.toString().contains("https://")) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) d.b.b.a.j.a(view.getContext()), new String[]{"http://tieba.baidu.com/mo/q/wise-bawu-core/recycle-station#/recycle-post?noshare=1"});
                    d.b.h0.r.d0.b.i().s(d.b.h0.r.d0.b.m("key_person_post_recycle_bin_red_tip_show"), false);
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SITE_SERVICE).param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnLongClickListener {
        public i() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            e eVar = e.this;
            eVar.f53649c.onItemViewLongClick(view, 5, eVar.f53652f, 0L);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar = e.this;
            eVar.f53648b.onItemViewClick(view, 4, eVar.f53652f, 0L);
        }
    }

    /* loaded from: classes4.dex */
    public class k implements View.OnLongClickListener {
        public k() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            e eVar = e.this;
            eVar.f53649c.onItemViewLongClick(view, 4, eVar.f53652f, 0L);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar = e.this;
            eVar.f53648b.onItemViewClick(view, 13, eVar.f53652f, 0L);
        }
    }

    /* loaded from: classes4.dex */
    public class m implements View.OnLongClickListener {
        public m() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            e eVar = e.this;
            eVar.f53649c.onItemViewLongClick(view, 3, eVar.f53652f, 0L);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar = e.this;
            eVar.f53648b.onItemViewClick(view, 7, eVar.f53652f, 0L);
        }
    }

    /* loaded from: classes4.dex */
    public class o implements View.OnLongClickListener {
        public o() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            e eVar = e.this;
            eVar.f53649c.onItemViewLongClick(view, 7, eVar.f53652f, 0L);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class p implements View.OnClickListener {
        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar = e.this;
            eVar.f53648b.onItemViewClick(view, 10, eVar.f53652f, 0L);
        }
    }

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, int i2) {
        super(tbPageContext, i2);
        this.f53648b = null;
        this.f53649c = null;
        this.f53652f = 0;
        this.f53653g = 0L;
        this.q = true;
        this.r = false;
        this.f53650d = 0L;
        this.f53651e = null;
        this.mContext = tbPageContext;
    }

    public void A(View view, ChatMessage chatMessage, String str) {
        d.b.b.a.f<T> fVar = this.mContext;
        d.b.i0.d1.f.h.c((TbPageContext) fVar, fVar.getContext(), view, this.l, chatMessage, str);
    }

    public void B(View view, ChatMessage chatMessage, String str) {
        d.b.i0.d1.f.h.d(this.mContext.getContext(), view, this.p, chatMessage, this.f53653g, str);
    }

    public void E(ChatMessage chatMessage, String str) {
        d.b.i0.d1.f.h.e(this.mContext.getContext(), this.i, chatMessage, str, this.s);
        if (chatMessage == null || chatMessage.getContent() == null) {
            return;
        }
        String[] split = chatMessage.getContent().split("#");
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : split) {
            stringBuffer.append(str2);
        }
        this.i.setContentDescription(stringBuffer.toString());
        this.i.getTextView().setContentDescription(stringBuffer.toString());
    }

    public void F(ChatMessage chatMessage, String str) {
        d.b.i0.d1.f.h.f(this.mContext.getContext(), this.j, chatMessage, str);
    }

    public final String f(long j2) {
        if (j2 < 1000) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j2 * 1000);
        Calendar calendar2 = this.f53651e;
        if (calendar2 != null && calendar2.get(1) == calendar.get(1) && this.f53651e.get(6) == calendar.get(6)) {
            return d.b.b.e.p.k.getDateStringHm(calendar.getTime());
        }
        return d.b.b.e.p.k.getDateStringMdHm(calendar.getTime());
    }

    public void h() {
        this.f53654h = (TextView) d(R.id.tex_msgitem_time);
        TbRichTextView tbRichTextView = (TbRichTextView) d(R.id.tex_msgitem_text);
        this.i = tbRichTextView;
        tbRichTextView.setLinkTextColor(-14845754);
        this.p = (ChatImageWithTailView) d(R.id.img_msgitem_image);
        this.l = (Invite2GroupView) d(R.id.lay_msgitem_invite_view);
        this.m = (ShareFromPBView) d(R.id.lay_msgitem_share_view);
        this.n = (ShareFromFrsView) d(R.id.lay_msgitem_share_frs);
        this.o = (ShareFromGameCenter) d(R.id.lay_msgitem_share_game);
        ChatVoiceView chatVoiceView = (ChatVoiceView) d(R.id.lay_msgitem_voice);
        this.j = chatVoiceView;
        chatVoiceView.setClickable(true);
        ChatVoiceView chatVoiceView2 = this.j;
        chatVoiceView2.setOnClickListener(chatVoiceView2);
        this.i.setOnClickListener(new h());
        this.j.setLongClickable(true);
        this.j.setOnLongClickListener(new i());
        this.p.getImage().setClickable(true);
        this.p.getImage().setOnClickListener(new j());
        this.p.getImage().setLongClickable(true);
        this.p.getImage().setOnLongClickListener(new k());
        this.p.getTail().setClickable(true);
        this.p.getTail().setOnClickListener(new l());
        this.i.setLongClickable(true);
        this.i.setOnLongClickListener(new m());
        GifView gifView = (GifView) d(R.id.emotion_msgitem_image);
        this.k = gifView;
        gifView.setSupportNoImage(false);
        this.k.setOnClickListener(new n());
        this.k.setLongClickable(true);
        this.k.setOnLongClickListener(new o());
        this.m.setClickable(true);
        this.m.setOnClickListener(new p());
        this.m.setLongClickable(true);
        this.m.setOnLongClickListener(new a());
        this.n.setClickable(true);
        this.n.setOnClickListener(new b());
        this.n.setLongClickable(true);
        this.n.setOnLongClickListener(new c());
        this.o.getContentBody().setClickable(true);
        this.o.getContentBody().setOnClickListener(new d());
        this.o.getTail().setClickable(true);
        this.o.getTail().setOnClickListener(new View$OnClickListenerC1191e());
        this.o.getContentBody().setLongClickable(true);
        this.o.getContentBody().setOnLongClickListener(new f());
        Invite2GroupView invite2GroupView = this.l;
        if (invite2GroupView != null) {
            invite2GroupView.setOnLongClickListener(new g());
        }
    }

    public final boolean i(long j2) {
        if (j2 < 1000) {
            return false;
        }
        long j3 = this.f53650d;
        return j3 == 0 || j2 - j3 >= 180;
    }

    public void k(long j2) {
        Calendar calendar = Calendar.getInstance();
        this.f53651e = calendar;
        calendar.setTimeInMillis(j2 * 1000);
    }

    public void l(View view, ChatMessage chatMessage) {
        if (chatMessage != null) {
            chatMessage.getMsgId();
        }
    }

    public void m(int i2) {
        this.p.setVisibility(i2);
    }

    public void n(boolean z) {
        this.r = z;
    }

    public void o(long j2) {
        this.f53650d = j2;
    }

    public void q(boolean z) {
        this.q = z;
    }

    public void r(d.b.b.e.h.a aVar) {
        this.f53648b = aVar;
    }

    public void s(d.b.b.e.h.b bVar) {
        this.f53649c = bVar;
    }

    public void u(int i2) {
        this.f53652f = i2;
    }

    public void v(View view, ChatMessage chatMessage) {
    }

    public void w(int i2) {
        this.s = i2;
    }

    public void x(ChatMessage chatMessage, boolean z) {
        d.b.i0.d1.f.h.a(this.mContext.getContext(), this.k, chatMessage, z);
    }

    public void y(View view, ChatMessage chatMessage, String str) {
        d.b.i0.d1.f.h.b(this.mContext.getContext(), view, this.m, this.n, this.o, chatMessage, str);
    }

    public void z(ChatMessage chatMessage) {
        boolean z = chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1;
        boolean i2 = i(chatMessage.getTime());
        if (!z && !i2) {
            this.f53654h.setVisibility(8);
        } else {
            this.f53654h.setVisibility(0);
            this.f53654h.setText(f(chatMessage.getTime()));
        }
        if (z || !i2) {
            return;
        }
        MsgCacheData cacheData = chatMessage.getCacheData();
        if (cacheData == null) {
            MsgCacheData msgCacheData = new MsgCacheData();
            msgCacheData.setIs_show_time(1);
            chatMessage.setCacheData(msgCacheData);
            return;
        }
        cacheData.setIs_show_time(1);
    }
}
