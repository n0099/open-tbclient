package d.b.i0.h2.d;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import d.b.h0.r.s.a;
/* loaded from: classes5.dex */
public class d implements d.b.i0.h2.h.a {

    /* renamed from: a  reason: collision with root package name */
    public int f55204a = -1;

    /* renamed from: b  reason: collision with root package name */
    public String f55205b = "";

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f55206c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.h0.r.f0.a f55207d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.r.f0.c f55208e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f55209f;

    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnCancelListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            MessageManager.getInstance().removeMessage(d.this.f55209f);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
        public b(d dVar) {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            if (Build.VERSION.SDK_INT < 11) {
                aVar.dismiss();
                d.this.f55206c.showToast(R.string.frs_header_games_unavailable);
                return;
            }
            TiebaStatic.log("c10038");
            aVar.dismiss();
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) d.this.f55206c.getPageActivity(), 2, true, 5);
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
            if (!StringUtils.isNULL("4010001002")) {
                memberPayActivityConfig.setSceneId("4010001002");
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    /* renamed from: d.b.i0.h2.d.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1268d implements a.e {
        public C1268d(d dVar) {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserMuteAddAndDelCustomMessage f55212e;

        public e(UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            this.f55212e = userMuteAddAndDelCustomMessage;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            d.this.g();
            MessageManager.getInstance().sendMessage(this.f55212e);
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements a.e {
        public f(d dVar) {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f55206c = tbPageContext;
        d.b.h0.r.f0.c cVar = new d.b.h0.r.f0.c();
        this.f55208e = cVar;
        cVar.f50484a = 1000L;
        this.f55209f = bdUniqueId;
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        BdUniqueId bdUniqueId2 = this.f55209f;
        userMuteAddAndDelCustomMessage.mId = bdUniqueId2;
        userMuteAddAndDelCustomMessage.from = 0;
        userMuteAddAndDelCustomMessage.setTag(bdUniqueId2);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        BdUniqueId bdUniqueId3 = this.f55209f;
        userMuteCheckCustomMessage.mId = bdUniqueId3;
        userMuteCheckCustomMessage.setTag(bdUniqueId3);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    @Override // d.b.i0.h2.h.a
    public void a(int i, int i2, String str, int i3, String str2) {
        d.b.h0.r.f0.a aVar = this.f55207d;
        if (aVar != null) {
            aVar.h(false);
        }
        this.f55204a = i2;
        this.f55205b = str;
        if (i3 == 0) {
            if (i == 1) {
                this.f55208e.c(this.f55206c.getString(R.string.mute_success));
            } else if (i == 2) {
                this.f55208e.c(this.f55206c.getResources().getString(R.string.un_mute_success));
            }
        } else if (i3 == 220017) {
            if (TextUtils.isEmpty(str2)) {
                str2 = this.f55206c.getString(R.string.mute_error_beyond_limit);
            }
            i(str2);
        } else if (i3 == 1990043) {
            h();
        } else {
            if (d.b.b.e.p.k.isEmpty(str2)) {
                if (i == 1) {
                    str2 = this.f55206c.getResources().getString(R.string.mute_fail);
                } else if (i == 2) {
                    str2 = this.f55206c.getResources().getString(R.string.un_mute_fail);
                }
            }
            this.f55208e.b(str2);
        }
    }

    public String d() {
        return this.f55205b;
    }

    public int e() {
        return this.f55204a;
    }

    public BdUniqueId f() {
        return this.f55209f;
    }

    public void g() {
        if (this.f55207d == null) {
            d.b.h0.r.f0.a aVar = new d.b.h0.r.f0.a(this.f55206c);
            this.f55207d = aVar;
            aVar.e(new a());
        }
        this.f55207d.h(true);
    }

    public void h() {
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f55206c.getPageActivity());
        aVar.setMessage(this.f55206c.getString(R.string.mute_is_super_member_function));
        aVar.setPositiveButton(R.string.open_now, new c());
        aVar.setNegativeButton(R.string.cancel, new C1268d(this));
        aVar.create(this.f55206c).show();
    }

    public void i(String str) {
        if (str == null) {
            str = "";
        }
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f55206c.getPageActivity());
        aVar.setMessage(str);
        aVar.setNegativeButton(R.string.know, new b(this));
        aVar.create(this.f55206c).show();
    }

    public void j(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            g();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f55206c.getPageActivity());
        if (d.b.b.e.p.k.isEmpty(str)) {
            aVar.setMessage(this.f55206c.getResources().getString(R.string.block_mute_message_alert, str2));
        } else {
            aVar.setMessage(str);
        }
        aVar.setPositiveButton(R.string.confirm, new e(userMuteAddAndDelCustomMessage));
        aVar.setNegativeButton(R.string.cancel, new f(this));
        aVar.create(this.f55206c).show();
    }
}
