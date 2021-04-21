package d.b.j0.d2.o.n;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.b.i0.a0.d;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.d0;
import d.b.i0.r.q.l0;
import d.b.i0.r.q.w1;
import d.b.i0.r.s.a;
import d.b.i0.r.s.b;
import d.b.i0.r.s.l;
import d.b.j0.d2.k.e.f0;
import d.b.j0.d2.k.e.g0;
import d.b.j0.d2.k.e.w0;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumToolPerm;
/* loaded from: classes3.dex */
public class a {
    public static int O = 0;
    public static int P = 3;
    public TbRichTextMemeInfo A;
    public BdUniqueId B;
    public Object C;
    public PermissionJudgePolicy D;
    public String F;
    public Runnable G;
    public d.b.i0.r.b0.a H;
    public d.b.j0.d3.h0.e I;
    public boolean M;

    /* renamed from: a  reason: collision with root package name */
    public VideoPbFragment f55074a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.r.s.j f55075b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.r.s.l f55076c;
    public List<CustomBlueCheckRadioButton> m;
    public d.b.j0.d2.k.f.a v;
    public PbFragment.n2 w;
    public w0 x;
    public d.b.c.j.d.a y;
    public String z;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.r.s.j f55077d = null;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.r.s.a f55078e = null;

    /* renamed from: f  reason: collision with root package name */
    public Dialog f55079f = null;

    /* renamed from: g  reason: collision with root package name */
    public Dialog f55080g = null;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.r.s.e f55081h = null;
    public View i = null;
    public LinearLayout j = null;
    public TextView k = null;
    public TextView l = null;
    public String n = null;
    public ScrollView o = null;
    public CompoundButton.OnCheckedChangeListener p = null;
    public d.b.i0.r.s.j q = null;
    public d.b.i0.r.f0.a r = null;
    public d.b.i0.r.s.b s = null;
    public AlertDialog t = null;
    public f0 u = null;
    public PostData E = null;
    public boolean J = d.b.i0.b.d.U();
    public final View.OnLongClickListener K = new n();
    public l.e L = new p();
    public final b.c N = new t();

    /* renamed from: d.b.j0.d2.o.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1255a implements a.e {
        public C1255a(a aVar) {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements l.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f55082e;

        public b(boolean z) {
            this.f55082e = z;
        }

        @Override // d.b.i0.r.s.l.e
        public void onItemClick(d.b.i0.r.s.l lVar, int i, View view) {
            a.this.q.dismiss();
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
                return;
            }
            switch (i) {
                case 10:
                    a.this.d0(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    return;
                case 11:
                    if (a.this.w != null) {
                        a.this.w.a(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                        return;
                    }
                    return;
                case 12:
                    a.this.R(this.f55082e, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements b.c {
        public c() {
        }

        @Override // d.b.i0.r.s.b.c
        public void a(d.b.i0.r.s.b bVar, int i, View view) {
            if (i == 0) {
                TiebaStatic.eventStat(a.this.f55074a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                a aVar = a.this;
                aVar.F = aVar.F.trim();
                UtilHelper.callPhone(a.this.f55074a.getPageContext().getPageActivity(), a.this.F);
                new d.b.j0.d2.k.e.d(a.this.f55074a.L().O0(), a.this.F, "1").start();
                bVar.e();
            } else if (i == 1) {
                TiebaStatic.eventStat(a.this.f55074a.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                a aVar2 = a.this;
                aVar2.F = aVar2.F.trim();
                UtilHelper.smsPhone(a.this.f55074a.getPageContext().getPageActivity(), a.this.F);
                new d.b.j0.d2.k.e.d(a.this.f55074a.L().O0(), a.this.F, "2").start();
                bVar.e();
            } else if (i == 2) {
                a aVar3 = a.this;
                aVar3.F = aVar3.F.trim();
                UtilHelper.startBaiDuBar(a.this.f55074a.getPageContext().getPageActivity(), a.this.F);
                bVar.e();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements l.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.r.s.j f55085e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f55086f;

        public d(d.b.i0.r.s.j jVar, View view) {
            this.f55085e = jVar;
            this.f55086f = view;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x004d, code lost:
            if (r4.f55087g.f55074a.L().L0() != 3) goto L5;
         */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00d5  */
        /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
        @Override // d.b.i0.r.s.l.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onItemClick(d.b.i0.r.s.l lVar, int i, View view) {
            boolean X1;
            this.f55085e.dismiss();
            int i2 = 3;
            if (a.this.f55074a.L().L0() != 1 || i != 1) {
                if (a.this.f55074a.L().L0() == 2 && i == 0) {
                    i2 = 1;
                } else if (a.this.f55074a.L().L0() == 3 && i != 2) {
                    i2 = 2;
                } else if (i == 2) {
                }
                TiebaStatic.log("c12097");
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f55086f.getId() != R.id.pb_sort ? 1 : 0).param("obj_type", i2));
                if (a.this.f55074a.L().y0().f54241f != null && a.this.f55074a.L().y0().f54241f.size() > i) {
                    i = a.this.f55074a.L().y0().f54241f.get(i).sort_type.intValue();
                }
                X1 = a.this.f55074a.L().X1(i);
                this.f55086f.setTag(Integer.valueOf(a.this.f55074a.L().K0()));
                if (X1) {
                    return;
                }
                a.this.f55074a.s4(true);
                return;
            }
            i2 = 0;
            TiebaStatic.log("c12097");
            TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f55086f.getId() != R.id.pb_sort ? 1 : 0).param("obj_type", i2));
            if (a.this.f55074a.L().y0().f54241f != null) {
                i = a.this.f55074a.L().y0().f54241f.get(i).sort_type.intValue();
            }
            X1 = a.this.f55074a.L().X1(i);
            this.f55086f.setTag(Integer.valueOf(a.this.f55074a.L().K0()));
            if (X1) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f55088e;

        public e(a aVar, MetaData metaData) {
            this.f55088e = metaData;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f55088e.getUserId()).param("obj_locate", 2));
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f55089e;

        public f(MetaData metaData) {
            this.f55089e = metaData;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f55089e.getUserId()).param("obj_locate", 1));
            aVar.dismiss();
            if (a.this.f55074a.N2() != null) {
                a.this.f55074a.N2().m(!this.f55089e.hadConcerned(), this.f55089e.getPortrait(), this.f55089e.getUserId(), this.f55089e.isGod(), "6", a.this.f55074a.getPageContext().getUniqueId(), a.this.f55074a.L().getForumId(), "0");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements a.e {
        public g(a aVar) {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class h implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserMuteAddAndDelCustomMessage f55091e;

        public h(UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            this.f55091e = userMuteAddAndDelCustomMessage;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            a.this.q0();
            MessageManager.getInstance().sendMessage(this.f55091e);
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class i implements a.e {
        public i(a aVar) {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.t != null) {
                d.b.c.e.m.g.a(a.this.t, a.this.f55074a.getPageContext().getPageActivity());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements l.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f55094e;

        public k(b.c cVar) {
            this.f55094e = cVar;
        }

        @Override // d.b.i0.r.s.l.e
        public void onItemClick(d.b.i0.r.s.l lVar, int i, View view) {
            a.this.f55077d.dismiss();
            this.f55094e.a(null, i, view);
        }
    }

    /* loaded from: classes3.dex */
    public class l implements CompoundButton.OnCheckedChangeListener {
        public l() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                a.this.n = (String) compoundButton.getTag();
                if (a.this.m != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : a.this.m) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && a.this.n != null && !str.equals(a.this.n)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f55080g instanceof Dialog) {
                d.b.c.e.m.g.b(a.this.f55080g, a.this.f55074a.getPageContext());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements View.OnLongClickListener {
        public n() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return a.this.D(view);
        }
    }

    /* loaded from: classes3.dex */
    public class o implements PbFragment.n2 {
        public o() {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.n2
        public void a(Object obj) {
            if (!d.b.c.e.p.j.z()) {
                a.this.f55074a.showToast(R.string.network_not_available);
                return;
            }
            Object[] objArr = (Object[]) obj;
            a.this.f55074a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(a.this.f55074a.getPageContext().getPageActivity(), a.this.f55074a.L().y0().l().getId(), a.this.f55074a.L().y0().l().getName(), a.this.f55074a.L().y0().L().o0(), String.valueOf(a.this.f55074a.L().y0().R().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
        }
    }

    /* loaded from: classes3.dex */
    public class p implements l.e {

        /* renamed from: d.b.j0.d2.o.n.a$p$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1256a implements a.e {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ SparseArray f55101e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f55102f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ boolean f55103g;

            public C1256a(SparseArray sparseArray, int i, boolean z) {
                this.f55101e = sparseArray;
                this.f55102f = i;
                this.f55103g = z;
            }

            @Override // d.b.i0.r.s.a.e
            public void onClick(d.b.i0.r.s.a aVar) {
                if (aVar != null) {
                    aVar.dismiss();
                }
                a.this.f55074a.H2(((Integer) this.f55101e.get(R.id.tag_del_post_type)).intValue(), (String) this.f55101e.get(R.id.tag_del_post_id), this.f55102f, this.f55103g);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements a.e {
            public b(p pVar) {
            }

            @Override // d.b.i0.r.s.a.e
            public void onClick(d.b.i0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        public p() {
        }

        @Override // d.b.i0.r.s.l.e
        public void onItemClick(d.b.i0.r.s.l lVar, int i, View view) {
            SparseArray sparseArray;
            if (a.this.f55075b != null) {
                a.this.f55075b.dismiss();
            }
            a.this.z0(i);
            int i2 = 4;
            switch (i) {
                case -4:
                    View view2 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_share);
                    a.this.i0(view2);
                    if (view2 != null) {
                        view2.performClick();
                        return;
                    }
                    return;
                case -3:
                    View view3 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_reply);
                    a.this.i0(view3);
                    if (view3 != null) {
                        view3.performClick();
                        return;
                    }
                    return;
                case -2:
                    View view4 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_zan_2);
                    AgreeView agreeView = (AgreeView) view4;
                    a.this.i0(view4);
                    if (agreeView == null || agreeView.getImgDisagree() == null) {
                        return;
                    }
                    agreeView.getImgDisagree().performClick();
                    return;
                case -1:
                    View view5 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_zan_2);
                    a.this.i0(view5);
                    AgreeView agreeView2 = (AgreeView) view5;
                    if (agreeView2 == null || agreeView2.getImgAgree() == null) {
                        return;
                    }
                    agreeView2.getImgAgree().performClick();
                    return;
                case 0:
                default:
                    return;
                case 1:
                    if (a.this.y == null || TextUtils.isEmpty(a.this.z)) {
                        return;
                    }
                    if (a.this.A == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, a.this.z));
                    } else {
                        d.a aVar = new d.a();
                        aVar.f50415a = a.this.z;
                        String str = "";
                        if (a.this.A.memeInfo.pck_id.intValue() >= 0) {
                            str = "" + a.this.A.memeInfo.pck_id;
                        }
                        aVar.f50416b = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                    a.this.y = null;
                    a.this.z = null;
                    return;
                case 2:
                    if (a.this.y == null || TextUtils.isEmpty(a.this.z)) {
                        return;
                    }
                    if (a.this.D == null) {
                        a.this.D = new PermissionJudgePolicy();
                    }
                    a.this.D.clearRequestPermissionList();
                    a.this.D.appendRequestPermission(a.this.f55074a.getPageContext().getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                    if (a.this.D.startRequestPermission(a.this.f55074a.getPageContext().getPageActivity())) {
                        return;
                    }
                    if (a.this.x == null) {
                        a aVar2 = a.this;
                        aVar2.x = new w0(aVar2.f55074a.getPageContext());
                    }
                    a.this.x.b(a.this.z, a.this.y.n());
                    a.this.y = null;
                    a.this.z = null;
                    return;
                case 3:
                    a aVar3 = a.this;
                    PostData postData = aVar3.E;
                    if (postData != null) {
                        postData.h0(aVar3.f55074a.getPageContext().getPageActivity());
                        a.this.E = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                    if (a.this.f55074a.checkUpIsLogin()) {
                        a.this.a0(view);
                        if (a.this.f55074a.L().y0().L() == null || a.this.f55074a.L().y0().L().T() == null || a.this.f55074a.L().y0().L().T().getUserId() == null || a.this.f55074a.Y2() == null) {
                            return;
                        }
                        a aVar4 = a.this;
                        int Q = aVar4.Q(aVar4.f55074a.L().y0());
                        a2 L = a.this.f55074a.L().y0().L();
                        if (L.O1()) {
                            i2 = 2;
                        } else if (L.R1()) {
                            i2 = 3;
                        } else if (!L.P1()) {
                            i2 = L.Q1() ? 5 : 1;
                        }
                        TiebaStatic.log(new StatisticItem("c12526").param("tid", a.this.f55074a.L().O0()).param("obj_locate", 2).param("obj_id", a.this.f55074a.L().y0().L().T().getUserId()).param("obj_type", !a.this.f55074a.Y2().e()).param("obj_source", Q).param("obj_param1", i2));
                        return;
                    }
                    return;
                case 5:
                    if (!d.b.c.e.p.j.z()) {
                        a.this.f55074a.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new StatisticItem("c13079"));
                        a.this.S((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                        SparseArray<Object> sparseArray2 = (SparseArray) tag;
                        if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray2.put(R.id.tag_from, 0);
                            sparseArray2.put(R.id.tag_check_mute_from, 2);
                            a.this.A(sparseArray2);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 6:
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null && (sparseArray3.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_id) instanceof String) && (sparseArray3.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                        boolean booleanValue = ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue();
                        int intValue = ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue();
                        if (!((Boolean) sparseArray3.get(R.id.tag_has_sub_post)).booleanValue()) {
                            d.b.j0.d2.k.e.d1.a.d(a.this.f55074a.getActivity(), a.this.f55074a.getPageContext(), new C1256a(sparseArray3, intValue, booleanValue), new b(this));
                            return;
                        } else {
                            a.this.d0(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
                            return;
                        }
                    }
                    return;
                case 7:
                    if (!d.b.c.e.p.j.z()) {
                        a.this.f55074a.showToast(R.string.network_not_available);
                        return;
                    }
                    SparseArray<Object> sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 == null) {
                        return;
                    }
                    boolean booleanValue2 = ((Boolean) sparseArray4.get(R.id.tag_should_manage_visible)).booleanValue();
                    boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.tag_should_delete_visible)).booleanValue();
                    boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                    if (!booleanValue2) {
                        if (booleanValue3) {
                            a.this.d0(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        }
                        return;
                    } else if (booleanValue4) {
                        sparseArray4.put(R.id.tag_from, 1);
                        sparseArray4.put(R.id.tag_check_mute_from, 2);
                        a.this.A(sparseArray4);
                        return;
                    } else {
                        sparseArray4.put(R.id.tag_check_mute_from, 2);
                        a.this.g0(view);
                        return;
                    }
                case 8:
                    if (ViewHelper.checkUpIsLogin(a.this.f55074a.getContext()) && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData2 = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData2.r() == null) {
                            return;
                        }
                        d.b.i0.i0.c f2 = TbPageExtraHelper.f(view);
                        if (f2 != null) {
                            postData2.r().objSource = f2.a();
                        }
                        a.this.B(postData2.r());
                        return;
                    }
                    return;
                case 9:
                    VideoPbFragment videoPbFragment = a.this.f55074a;
                    if (videoPbFragment == null || videoPbFragment.L() == null || a.this.f55074a.L().y0() == null || !ViewHelper.checkUpIsLogin(a.this.f55074a.getContext()) || a.this.f55074a.P() == null) {
                        return;
                    }
                    a.this.f55074a.P().showBlockDialog(d.b.j0.n3.a.b(view));
                    return;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q implements l.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f55105e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f55106f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f55107g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f55108h;

        public q(SparseArray sparseArray, boolean z, String str, String str2) {
            this.f55105e = sparseArray;
            this.f55106f = z;
            this.f55107g = str;
            this.f55108h = str2;
        }

        @Override // d.b.i0.r.s.l.e
        public void onItemClick(d.b.i0.r.s.l lVar, int i, View view) {
            if (a.this.f55075b != null) {
                a.this.f55075b.dismiss();
            }
            if (i == 0) {
                a.this.d0(((Integer) this.f55105e.get(R.id.tag_del_post_type)).intValue(), (String) this.f55105e.get(R.id.tag_del_post_id), ((Integer) this.f55105e.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.f55105e.get(R.id.tag_del_post_is_self)).booleanValue());
            } else if (i == 1) {
                String str = (String) this.f55105e.get(R.id.tag_user_mute_mute_username);
                String str2 = (String) this.f55105e.get(R.id.tag_user_mute_thread_id);
                String str3 = (String) this.f55105e.get(R.id.tag_user_mute_post_id);
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                userMuteAddAndDelCustomMessage.setData(this.f55106f, this.f55107g, str, str2, str3, 1, this.f55108h, a.this.B);
                userMuteAddAndDelCustomMessage.setTag(a.this.B);
                a.this.y0(this.f55106f, userMuteAddAndDelCustomMessage, this.f55108h, str, (String) this.f55105e.get(R.id.tag_user_mute_mute_nameshow));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r implements a.e {
        public r() {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            TiebaStatic.log("c10025");
            aVar.dismiss();
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) a.this.f55074a.getFragmentActivity(), 2, true, 4);
            if (!StringUtils.isNULL("4010001001")) {
                memberPayActivityConfig.setSceneId("4010001001");
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    /* loaded from: classes3.dex */
    public class s implements a.e {
        public s(a aVar) {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class t implements b.c {
        public t() {
        }

        @Override // d.b.i0.r.s.b.c
        public void a(d.b.i0.r.s.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.e();
            }
            if (a.this.y == null || TextUtils.isEmpty(a.this.z)) {
                return;
            }
            if (i == 0) {
                if (a.this.A == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, a.this.z));
                } else {
                    d.a aVar = new d.a();
                    aVar.f50415a = a.this.z;
                    String str = "";
                    if (a.this.A.memeInfo.pck_id.intValue() >= 0) {
                        str = "" + a.this.A.memeInfo.pck_id;
                    }
                    aVar.f50416b = str;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                }
            } else if (i == 1) {
                if (a.this.D == null) {
                    a.this.D = new PermissionJudgePolicy();
                }
                a.this.D.clearRequestPermissionList();
                a.this.D.appendRequestPermission(a.this.f55074a.getPageContext().getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                if (a.this.D.startRequestPermission(a.this.f55074a.getPageContext().getPageActivity())) {
                    return;
                }
                if (a.this.x == null) {
                    a aVar2 = a.this;
                    aVar2.x = new w0(aVar2.f55074a.getPageContext());
                }
                a.this.x.b(a.this.z, a.this.y.n());
            }
            a.this.y = null;
            a.this.z = null;
        }
    }

    /* loaded from: classes3.dex */
    public class u implements a.e {
        public u() {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            a.this.f55074a.G2(aVar, null);
        }
    }

    public a(VideoPbFragment videoPbFragment) {
        this.f55074a = videoPbFragment;
        this.B = videoPbFragment.getUniqueId();
        d.b.j0.d2.k.f.a aVar = new d.b.j0.d2.k.f.a(this.f55074a.getContext());
        this.v = aVar;
        aVar.a(this.f55074a.getUniqueId());
        this.w = new o();
    }

    public void A(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        q0();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = d.b.c.e.m.b.f(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = d.b.c.e.m.b.f((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        BdUniqueId bdUniqueId = this.B;
        userMuteCheckCustomMessage.mId = bdUniqueId;
        userMuteCheckCustomMessage.setTag(bdUniqueId);
        this.C = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public final void A0() {
        f0 f0Var = this.u;
        if (f0Var == null) {
            return;
        }
        f0Var.x();
    }

    public final void B(AgreeData agreeData) {
        VideoPbFragment videoPbFragment;
        if (agreeData == null) {
            return;
        }
        if (this.H == null) {
            this.H = new d.b.i0.r.b0.a();
        }
        if (this.I == null) {
            d.b.j0.d3.h0.e eVar = new d.b.j0.d3.h0.e();
            this.I = eVar;
            eVar.f55239a = this.f55074a.getUniqueId();
        }
        d.b.i0.r.q.e eVar2 = new d.b.i0.r.q.e();
        eVar2.f51506b = 5;
        eVar2.f51512h = 8;
        eVar2.f51511g = 2;
        VideoPbFragment videoPbFragment2 = this.f55074a;
        if (videoPbFragment2 != null && videoPbFragment2.L() != null) {
            eVar2.f51510f = this.f55074a.L().x0();
        }
        eVar2.f51505a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                eVar2.i = 0;
                this.H.c(agreeData, i2, this.f55074a.getUniqueId(), false);
                this.H.d(agreeData, this.I);
                videoPbFragment = this.f55074a;
                if (videoPbFragment != null || videoPbFragment.L() == null || this.f55074a.L().y0() == null) {
                    return;
                }
                this.H.b(this.f55074a.P(), eVar2, agreeData, this.f55074a.L().y0().L());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            eVar2.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            eVar2.i = 1;
        }
        i2 = 0;
        this.H.c(agreeData, i2, this.f55074a.getUniqueId(), false);
        this.H.d(agreeData, this.I);
        videoPbFragment = this.f55074a;
        if (videoPbFragment != null) {
        }
    }

    public final CustomBlueCheckRadioButton C(String str, String str2) {
        Activity pageActivity = this.f55074a.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, d.b.c.e.p.l.g(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.p);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public final boolean D(View view) {
        SparseArray sparseArray;
        boolean z;
        boolean z2;
        List<d.b.i0.r.s.h> b2;
        d.b.i0.r.s.h hVar;
        d.b.i0.r.s.h hVar2;
        d.b.i0.r.s.h hVar3;
        d.b.i0.r.s.h hVar4;
        d.b.c.j.d.a aVar;
        SparseArray sparseArray2;
        VideoPbFragment videoPbFragment = this.f55074a;
        if (videoPbFragment == null || !videoPbFragment.isAdded()) {
            return true;
        }
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e2) {
            e2.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray == null) {
            if (W(view)) {
                if (view instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) view;
                    this.y = tbImageView.getBdImage();
                    String url = tbImageView.getUrl();
                    this.z = url;
                    if (this.y == null || TextUtils.isEmpty(url)) {
                        return true;
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.A = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.A = null;
                    }
                } else if (view instanceof GifView) {
                    GifView gifView = (GifView) view;
                    if (gifView.getBdImage() == null) {
                        return true;
                    }
                    this.y = gifView.getBdImage();
                    if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                        this.z = gifView.getBdImage().q();
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.A = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.A = null;
                    }
                } else if (view instanceof TbMemeImageView) {
                    TbMemeImageView tbMemeImageView = (TbMemeImageView) view;
                    if (tbMemeImageView.getBdImage() != null) {
                        this.y = tbMemeImageView.getBdImage();
                        if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                            this.z = tbMemeImageView.getBdImage().q();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.A = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.A = null;
                        }
                    }
                }
                if (view.getParent() instanceof TbRichTextView) {
                    try {
                        sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                    } catch (ClassCastException e3) {
                        e3.printStackTrace();
                    }
                } else if (view.getParent().getParent() instanceof TbRichTextView) {
                    try {
                        sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                    } catch (ClassCastException e4) {
                        e4.printStackTrace();
                    }
                } else {
                    t0(this.N, this.y.t());
                }
                sparseArray = sparseArray2;
            }
            if (sparseArray == null) {
                return true;
            }
        }
        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
        this.E = postData;
        if (postData == null || this.f55074a.Y2() == null) {
            return true;
        }
        boolean z3 = this.f55074a.Y2().e() && this.E.E() != null && this.E.E().equals(this.f55074a.L().t0());
        boolean z4 = this.f55074a.L().y0() != null && this.f55074a.L().y0().a0();
        if (this.f55076c == null) {
            d.b.i0.r.s.l lVar = new d.b.i0.r.s.l(this.f55074a.getContext());
            this.f55076c = lVar;
            lVar.n(this.L);
        }
        ArrayList arrayList = new ArrayList();
        if (view == null || sparseArray == null) {
            return true;
        }
        boolean z5 = W(view) && !z4;
        boolean z6 = (!W(view) || (aVar = this.y) == null || aVar.t()) ? false : true;
        boolean booleanValue = sparseArray.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue() : false;
        boolean booleanValue2 = sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false;
        boolean booleanValue3 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
        boolean booleanValue4 = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
        boolean booleanValue5 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
        boolean booleanValue6 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
        String str = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
        if (z5) {
            z2 = booleanValue6;
            z = booleanValue5;
            arrayList.add(new d.b.i0.r.s.h(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), this.f55076c));
        } else {
            z = booleanValue5;
            z2 = booleanValue6;
        }
        if (z6) {
            arrayList.add(new d.b.i0.r.s.h(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), this.f55076c));
        }
        if (!z5 && !z6) {
            d.b.i0.r.s.h hVar5 = new d.b.i0.r.s.h(3, TbadkCoreApplication.getInst().getString(R.string.copy), this.f55076c);
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_clip_board, this.E);
            hVar5.f51748d.setTag(sparseArray3);
            arrayList.add(hVar5);
        }
        if (!booleanValue && !z4) {
            if (z3) {
                hVar4 = new d.b.i0.r.s.h(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), this.f55076c);
            } else {
                hVar4 = new d.b.i0.r.s.h(4, TbadkCoreApplication.getInst().getString(R.string.mark), this.f55076c);
            }
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(R.id.tag_clip_board, this.E);
            sparseArray4.put(R.id.tag_is_subpb, Boolean.FALSE);
            hVar4.f51748d.setTag(sparseArray4);
            arrayList.add(hVar4);
        }
        if (TbadkCoreApplication.isLogin() && !this.J) {
            if (!V() && !booleanValue4 && booleanValue3) {
                d.b.i0.r.s.h hVar6 = new d.b.i0.r.s.h(5, TbadkCoreApplication.getInst().getString(R.string.mute_option), this.f55076c);
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                int i2 = R.id.tag_is_mem;
                sparseArray5.put(i2, sparseArray.get(i2));
                int i3 = R.id.tag_user_mute_mute_userid;
                sparseArray5.put(i3, sparseArray.get(i3));
                int i4 = R.id.tag_user_mute_mute_username;
                sparseArray5.put(i4, sparseArray.get(i4));
                int i5 = R.id.tag_user_mute_mute_nameshow;
                sparseArray5.put(i5, sparseArray.get(i5));
                int i6 = R.id.tag_user_mute_post_id;
                sparseArray5.put(i6, sparseArray.get(i6));
                int i7 = R.id.tag_user_mute_thread_id;
                sparseArray5.put(i7, sparseArray.get(i7));
                int i8 = R.id.tag_del_post_is_self;
                sparseArray5.put(i8, sparseArray.get(i8));
                int i9 = R.id.tag_del_post_type;
                sparseArray5.put(i9, sparseArray.get(i9));
                int i10 = R.id.tag_del_post_id;
                sparseArray5.put(i10, sparseArray.get(i10));
                int i11 = R.id.tag_manage_user_identity;
                sparseArray5.put(i11, sparseArray.get(i11));
                hVar6.f51748d.setTag(sparseArray5);
                arrayList.add(hVar6);
            } else {
                if ((Y(booleanValue2) && TbadkCoreApplication.isLogin()) && !z4) {
                    d.b.i0.r.s.h hVar7 = new d.b.i0.r.s.h(5, TbadkCoreApplication.getInst().getString(R.string.report_text), this.f55076c);
                    hVar7.f51748d.setTag(str);
                    arrayList.add(hVar7);
                }
            }
            if (booleanValue4) {
                SparseArray sparseArray6 = new SparseArray();
                sparseArray6.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                int i12 = R.id.tag_manage_user_identity;
                sparseArray6.put(i12, sparseArray.get(i12));
                int i13 = R.id.tag_forbid_user_name;
                sparseArray6.put(i13, sparseArray.get(i13));
                int i14 = R.id.tag_forbid_user_name_show;
                sparseArray6.put(i14, sparseArray.get(i14));
                int i15 = R.id.tag_forbid_user_portrait;
                sparseArray6.put(i15, sparseArray.get(i15));
                sparseArray6.put(R.id.tag_forbid_user_post_id, str);
                if (!V() && z) {
                    sparseArray6.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    int i16 = R.id.tag_is_mem;
                    sparseArray6.put(i16, sparseArray.get(i16));
                    int i17 = R.id.tag_user_mute_mute_userid;
                    sparseArray6.put(i17, sparseArray.get(i17));
                    int i18 = R.id.tag_user_mute_mute_username;
                    sparseArray6.put(i18, sparseArray.get(i18));
                    int i19 = R.id.tag_user_mute_mute_nameshow;
                    sparseArray6.put(i19, sparseArray.get(i19));
                    int i20 = R.id.tag_user_mute_post_id;
                    sparseArray6.put(i20, sparseArray.get(i20));
                    int i21 = R.id.tag_user_mute_thread_id;
                    sparseArray6.put(i21, sparseArray.get(i21));
                } else {
                    sparseArray6.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                if (z2) {
                    sparseArray6.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray6.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue2));
                    int i22 = R.id.tag_del_post_id;
                    sparseArray6.put(i22, sparseArray.get(i22));
                    int i23 = R.id.tag_del_post_type;
                    sparseArray6.put(i23, sparseArray.get(i23));
                    int i24 = R.id.tag_has_sub_post;
                    sparseArray6.put(i24, sparseArray.get(i24));
                    hVar2 = new d.b.i0.r.s.h(6, TbadkCoreApplication.getInst().getString(R.string.delete), this.f55076c);
                    hVar2.f51748d.setTag(sparseArray6);
                } else {
                    sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    hVar2 = null;
                }
                hVar = new d.b.i0.r.s.h(7, TbadkCoreApplication.getInst().getString(R.string.bar_manager), this.f55076c);
                hVar.f51748d.setTag(sparseArray6);
            } else if (z2) {
                SparseArray sparseArray7 = new SparseArray();
                sparseArray7.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                sparseArray7.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                sparseArray7.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                int i25 = R.id.tag_manage_user_identity;
                sparseArray7.put(i25, sparseArray.get(i25));
                sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue2));
                int i26 = R.id.tag_del_post_id;
                sparseArray7.put(i26, sparseArray.get(i26));
                int i27 = R.id.tag_del_post_type;
                sparseArray7.put(i27, sparseArray.get(i27));
                int i28 = R.id.tag_has_sub_post;
                sparseArray7.put(i28, sparseArray.get(i28));
                if (this.f55074a.L().y0().S() == 1002 && !booleanValue2) {
                    hVar3 = new d.b.i0.r.s.h(6, TbadkCoreApplication.getInst().getString(R.string.report_text), this.f55076c);
                } else {
                    hVar3 = new d.b.i0.r.s.h(6, TbadkCoreApplication.getInst().getString(R.string.delete), this.f55076c);
                }
                hVar3.f51748d.setTag(sparseArray7);
                hVar2 = hVar3;
                hVar = null;
            } else {
                hVar = null;
                hVar2 = null;
            }
            if (hVar2 != null) {
                arrayList.add(hVar2);
            }
            if (hVar != null) {
                arrayList.add(hVar);
            }
            d.b.j0.d2.k.e.d1.a.a(arrayList, this.f55076c, this.E, this.f55074a.L());
        }
        if (d.b.i0.b.d.z()) {
            b2 = d.b.j0.d2.k.e.d1.a.c(arrayList, this.E.r(), sparseArray, this.f55076c);
        } else {
            b2 = d.b.j0.d2.k.e.d1.a.b(arrayList, this.E.r(), sparseArray, this.f55076c);
        }
        d.b.j0.d2.k.e.d1.a.k(b2, this.M);
        d.b.j0.d2.k.e.d1.a.e(b2);
        this.f55076c.o(d.b.j0.d2.k.e.d1.a.f(this.E));
        if (d.b.i0.b.d.z()) {
            this.f55076c.l(b2, false);
        } else {
            this.f55076c.l(b2, true);
        }
        d.b.i0.r.s.j jVar = new d.b.i0.r.s.j(this.f55074a.getPageContext(), this.f55076c);
        this.f55075b = jVar;
        jVar.l();
        TiebaStatic.log(new StatisticItem("c13272").param("tid", this.f55074a.L().O0()).param("fid", this.f55074a.L().getForumId()).param("uid", this.f55074a.L().y0().L().T().getUserId()).param("post_id", this.f55074a.L().s()).param("obj_source", booleanValue ? 2 : 1));
        return true;
    }

    public void E() {
        H();
        this.f55074a.l3();
        d.b.i0.r.s.j jVar = this.f55075b;
        if (jVar != null) {
            jVar.dismiss();
        }
        this.f55074a.m3();
        J();
    }

    public void F() {
        H();
        this.f55074a.l3();
        d.b.i0.r.s.j jVar = this.f55075b;
        if (jVar != null) {
            jVar.dismiss();
        }
        J();
    }

    public void G() {
        d.b.i0.r.s.j jVar = this.f55075b;
        if (jVar != null) {
            jVar.dismiss();
        }
    }

    public void H() {
        if (this.G == null) {
            this.G = new j();
        }
        d.b.c.e.m.e.a().postDelayed(this.G, 100L);
    }

    public void I() {
        AlertDialog alertDialog = this.t;
        if (alertDialog != null) {
            d.b.c.e.m.g.a(alertDialog, this.f55074a.getPageContext().getPageActivity());
        }
    }

    public void J() {
        d.b.i0.r.s.a aVar = this.f55078e;
        if (aVar != null) {
            aVar.dismiss();
        }
        Dialog dialog = this.f55079f;
        if (dialog != null) {
            d.b.c.e.m.g.b(dialog, this.f55074a.getPageContext());
        }
        Dialog dialog2 = this.f55080g;
        if (dialog2 != null) {
            d.b.c.e.m.g.b(dialog2, this.f55074a.getPageContext());
        }
        d.b.i0.r.s.j jVar = this.q;
        if (jVar != null) {
            jVar.dismiss();
        }
    }

    public View K() {
        View view = this.i;
        if (view != null) {
            return view.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String L() {
        return this.n;
    }

    public Object M() {
        return this.C;
    }

    public View.OnLongClickListener N() {
        return this.K;
    }

    public f0 O() {
        return this.u;
    }

    public d.b.i0.r.s.b P() {
        return this.s;
    }

    public int Q(d.b.j0.d2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return 0;
        }
        if (eVar.L().s1() == 0) {
            return 1;
        }
        if (eVar.L().s1() == 54) {
            return 2;
        }
        return eVar.L().s1() == 40 ? 3 : 4;
    }

    public void R(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2 = sparseArray.get(R.id.tag_user_mute_mute_username) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_mute_username) : "";
        String str3 = sparseArray.get(R.id.tag_user_mute_thread_id) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_thread_id) : "";
        String str4 = sparseArray.get(R.id.tag_user_mute_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_post_id) : "";
        String str5 = sparseArray.get(R.id.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_msg) : "";
        String str6 = sparseArray.get(R.id.tag_user_mute_mute_nameshow) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow) : "";
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.B);
        userMuteAddAndDelCustomMessage.setTag(this.B);
        y0(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    public void S(String str) {
        if (this.f55074a.L() != null && this.f55074a.L().y0() != null && this.f55074a.L().y0().a0()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.f55074a.L().O0(), str);
            a2 L = this.f55074a.L().y0().L();
            if (L.O1()) {
                format = format + "&channelid=33833";
            } else if (L.T1()) {
                format = format + "&channelid=33842";
            } else if (L.R1()) {
                format = format + "&channelid=33840";
            }
            Z(format);
            return;
        }
        this.v.i(str);
    }

    public void T() {
        d.b.i0.r.f0.a aVar = this.r;
        if (aVar != null) {
            aVar.h(false);
        }
    }

    public void U() {
        if (this.s != null) {
            return;
        }
        this.s = new d.b.i0.r.s.b(this.f55074a.getPageContext().getPageActivity());
        String[] strArr = {this.f55074a.getPageContext().getString(R.string.call_phone), this.f55074a.getPageContext().getString(R.string.sms_phone), this.f55074a.getPageContext().getString(R.string.search_in_baidu)};
        d.b.i0.r.s.b bVar = this.s;
        bVar.j(strArr, new c());
        bVar.g(b.C1124b.f51722a);
        bVar.h(17);
        bVar.c(this.f55074a.getPageContext());
    }

    public boolean V() {
        return d.b.j0.d2.k.e.d1.a.h(this.f55074a.L());
    }

    public boolean W(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public boolean X(int i2) {
        List<ForumToolPerm> forumToolAuth;
        if (i2 != 1) {
            if ((i2 == 2 || i2 == 3 || i2 == 4) && this.f55074a.L().y0().R() != null && (forumToolAuth = this.f55074a.L().y0().R().getForumToolAuth()) != null) {
                for (int i3 = 0; i3 < forumToolAuth.size(); i3++) {
                    ForumToolPerm forumToolPerm = forumToolAuth.get(i3);
                    if (forumToolPerm != null && forumToolPerm.perm.longValue() == 1) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final boolean Y(boolean z) {
        if (this.f55074a.L() != null && this.f55074a.L().y0() != null) {
            return ((this.f55074a.L().y0().S() != 0) || this.f55074a.L().y0().L() == null || this.f55074a.L().y0().L().T() == null || TextUtils.equals(this.f55074a.L().y0().L().T().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
        }
        return false;
    }

    public final void Z(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.f55074a.getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
    }

    public final void a0(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e2) {
            e2.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        b0(postData);
    }

    public void b0(PostData postData) {
        if (postData == null) {
            return;
        }
        boolean z = false;
        if (postData.E() != null && postData.E().equals(this.f55074a.L().t0())) {
            z = true;
        }
        MarkData s0 = this.f55074a.L().s0(postData);
        if (this.f55074a.L().y0() != null && this.f55074a.L().y0().a0()) {
            VideoPbFragment videoPbFragment = this.f55074a;
            PostData S2 = videoPbFragment.S2(videoPbFragment.L().y0());
            if (S2 != null) {
                s0 = this.f55074a.L().s0(S2);
            }
        }
        if (s0 == null) {
            return;
        }
        this.f55074a.x4();
        if (this.f55074a.Y2() != null) {
            this.f55074a.Y2().i(s0);
            if (!z) {
                this.f55074a.Y2().a();
            } else {
                this.f55074a.Y2().d();
            }
        }
    }

    public void c0(ArrayList<l0> arrayList) {
        if (this.i == null) {
            this.i = LayoutInflater.from(this.f55074a.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.f55074a.getBaseFragmentActivity().getLayoutMode().j(this.i);
        if (this.f55080g == null) {
            Dialog dialog = new Dialog(this.f55074a.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.f55080g = dialog;
            dialog.setCanceledOnTouchOutside(true);
            this.f55080g.setCancelable(true);
            this.o = (ScrollView) this.i.findViewById(R.id.good_scroll);
            this.f55080g.setContentView(this.i);
            WindowManager.LayoutParams attributes = this.f55080g.getWindow().getAttributes();
            attributes.width = d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.f55080g.getWindow().setAttributes(attributes);
            this.p = new l();
            this.j = (LinearLayout) this.i.findViewById(R.id.good_class_group);
            TextView textView = (TextView) this.i.findViewById(R.id.dialog_button_cancel);
            this.l = textView;
            textView.setOnClickListener(new m());
            TextView textView2 = (TextView) this.i.findViewById(R.id.dialog_button_ok);
            this.k = textView2;
            textView2.setOnClickListener(this.f55074a.V2());
        }
        this.j.removeAllViews();
        this.m = new ArrayList();
        CustomBlueCheckRadioButton C = C("0", this.f55074a.getPageContext().getString(R.string.thread_good_class));
        this.m.add(C);
        C.setChecked(true);
        this.j.addView(C);
        if (arrayList != null) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                l0 l0Var = arrayList.get(i2);
                if (l0Var != null && !TextUtils.isEmpty(l0Var.b()) && l0Var.a() > 0) {
                    CustomBlueCheckRadioButton C2 = C(String.valueOf(l0Var.a()), l0Var.b());
                    this.m.add(C2);
                    View view = new View(this.f55074a.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    SkinManager.setBackgroundColor(view, R.color.CAM_X0204);
                    view.setLayoutParams(layoutParams);
                    this.j.addView(view);
                    this.j.addView(C2);
                }
            }
            ViewGroup.LayoutParams layoutParams2 = this.o.getLayoutParams();
            int size = arrayList.size();
            if (size == 0 || size == 1) {
                layoutParams2.height = d.b.c.e.p.l.e(this.f55074a.getPageContext().getPageActivity(), 120.0f);
            } else if (size != 2) {
                layoutParams2.height = d.b.c.e.p.l.e(this.f55074a.getPageContext().getPageActivity(), 220.0f);
            } else {
                layoutParams2.height = d.b.c.e.p.l.e(this.f55074a.getPageContext().getPageActivity(), 186.0f);
            }
            this.o.setLayoutParams(layoutParams2);
            this.o.removeAllViews();
            LinearLayout linearLayout = this.j;
            if (linearLayout != null && linearLayout.getParent() == null) {
                this.o.addView(this.j);
            }
        }
        d.b.c.e.m.g.j(this.f55080g, this.f55074a.getPageContext());
    }

    public void d0(int i2, String str, int i3, boolean z) {
        e0(i2, str, i3, z, null);
    }

    public void e0(int i2, String str, int i3, boolean z, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_del_post_id, str);
        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(O, Integer.valueOf(P));
        int i4 = R.string.del_all_post_confirm;
        if (i3 == 1002 && !z) {
            i4 = R.string.report_post_confirm;
        }
        if (i2 == 0) {
            if (i3 == 1002 && !z) {
                i4 = R.string.report_thread_confirm;
            } else {
                i4 = R.string.del_thread_confirm;
            }
        }
        this.f55078e = new d.b.i0.r.s.a(this.f55074a.getActivity());
        if (StringUtils.isNull(str2)) {
            this.f55078e.setMessageId(i4);
        } else {
            this.f55078e.setOnlyMessageShowCenter(false);
            this.f55078e.setMessage(str2);
        }
        this.f55078e.setYesButtonTag(sparseArray);
        this.f55078e.setPositiveButton(R.string.dialog_ok, new u());
        this.f55078e.setNegativeButton(R.string.dialog_cancel, new C1255a(this));
        this.f55078e.setCancelable(true);
        this.f55078e.create(this.f55074a.getPageContext());
        this.f55078e.show();
    }

    public void f0(SparseArray<Object> sparseArray, boolean z) {
        d.b.i0.r.s.h hVar;
        d.b.i0.r.s.h hVar2;
        d.b.i0.r.s.l lVar = new d.b.i0.r.s.l(this.f55074a.getContext());
        lVar.q(this.f55074a.getString(R.string.bar_manager));
        lVar.n(new b(z));
        ArrayList arrayList = new ArrayList();
        int intValue = sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1;
        if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && intValue != 2) {
            if ((sparseArray.get(R.id.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue() : -1) == 0) {
                hVar2 = new d.b.i0.r.s.h(10, this.f55074a.getString(R.string.delete_post), lVar);
            } else {
                hVar2 = new d.b.i0.r.s.h(10, this.f55074a.getString(R.string.delete), lVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            int i2 = R.id.tag_del_post_id;
            sparseArray2.put(i2, sparseArray.get(i2));
            int i3 = R.id.tag_del_post_type;
            sparseArray2.put(i3, sparseArray.get(i3));
            int i4 = R.id.tag_del_post_is_self;
            sparseArray2.put(i4, sparseArray.get(i4));
            int i5 = R.id.tag_manage_user_identity;
            sparseArray2.put(i5, sparseArray.get(i5));
            hVar2.f51748d.setTag(sparseArray2);
            arrayList.add(hVar2);
        }
        if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
            SparseArray sparseArray3 = new SparseArray();
            int i6 = R.id.tag_forbid_user_name;
            sparseArray3.put(i6, sparseArray.get(i6));
            int i7 = R.id.tag_forbid_user_name_show;
            sparseArray3.put(i7, sparseArray.get(i7));
            int i8 = R.id.tag_forbid_user_portrait;
            sparseArray3.put(i8, sparseArray.get(i8));
            int i9 = R.id.tag_manage_user_identity;
            sparseArray3.put(i9, sparseArray.get(i9));
            int i10 = R.id.tag_forbid_user_post_id;
            sparseArray3.put(i10, sparseArray.get(i10));
            d.b.i0.r.s.h hVar3 = new d.b.i0.r.s.h(11, this.f55074a.getString(R.string.forbidden_person), lVar);
            hVar3.f51748d.setTag(sparseArray3);
            arrayList.add(hVar3);
        }
        if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
            SparseArray sparseArray4 = new SparseArray();
            int i11 = R.id.tag_is_mem;
            sparseArray4.put(i11, sparseArray.get(i11));
            int i12 = R.id.tag_user_mute_mute_userid;
            sparseArray4.put(i12, sparseArray.get(i12));
            int i13 = R.id.tag_user_mute_mute_username;
            sparseArray4.put(i13, sparseArray.get(i13));
            int i14 = R.id.tag_user_mute_mute_nameshow;
            sparseArray4.put(i14, sparseArray.get(i14));
            int i15 = R.id.tag_user_mute_post_id;
            sparseArray4.put(i15, sparseArray.get(i15));
            int i16 = R.id.tag_user_mute_thread_id;
            sparseArray4.put(i16, sparseArray.get(i16));
            int i17 = R.id.tag_user_mute_msg;
            sparseArray4.put(i17, sparseArray.get(i17));
            if (z) {
                hVar = new d.b.i0.r.s.h(12, this.f55074a.getString(R.string.un_mute), lVar);
            } else {
                hVar = new d.b.i0.r.s.h(12, this.f55074a.getString(R.string.mute), lVar);
            }
            hVar.f51748d.setTag(sparseArray4);
            arrayList.add(hVar);
        }
        lVar.k(arrayList);
        d.b.i0.r.s.j jVar = this.q;
        if (jVar == null) {
            this.q = new d.b.i0.r.s.j(this.f55074a.getPageContext(), lVar);
        } else {
            jVar.h(lVar);
        }
        this.q.l();
    }

    public void g0(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            return;
        }
        f0(sparseArray, false);
    }

    public void h0() {
        d.b.j0.d2.h.e y0;
        a2 L;
        VideoPbFragment videoPbFragment = this.f55074a;
        if (videoPbFragment == null || videoPbFragment.L() == null || this.f55074a.L().y0() == null || (L = (y0 = this.f55074a.L().y0()).L()) == null || L.T() == null) {
            return;
        }
        this.f55074a.l3();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), L.T().getUserId());
        g0 g0Var = new g0();
        int S = this.f55074a.L().y0().S();
        boolean z = false;
        if (S != 1 && S != 3) {
            g0Var.f54581g = false;
        } else {
            g0Var.f54581g = true;
            g0Var.p = L.x0() == 1;
        }
        if (X(S)) {
            g0Var.f54582h = true;
            g0Var.o = L.w0() == 1;
        } else {
            g0Var.f54582h = false;
        }
        if (S == 1002 && !equals) {
            g0Var.q = true;
        }
        g0Var.f54579e = l0(equals);
        g0Var.i = o0();
        g0Var.f54580f = n0(equals);
        g0Var.k = equals && y0.R() != null && y0.R().showPbPrivate();
        g0Var.n = this.f55074a.L().M0();
        g0Var.f54576b = true;
        g0Var.f54575a = Y(equals);
        g0Var.m = TbadkCoreApplication.getInst().getSkinType() == 1;
        g0Var.j = true;
        g0Var.l = this.f55074a.L().d0();
        g0Var.f54578d = true;
        if (L.u1() == null) {
            g0Var.f54577c = true;
        } else {
            g0Var.f54577c = false;
        }
        if (y0.a0()) {
            g0Var.f54576b = false;
            g0Var.f54578d = false;
            g0Var.f54577c = false;
            g0Var.f54581g = false;
            g0Var.f54582h = false;
        }
        if (TbSingleton.getInstance().mShowCallFans && equals && !y0.a0()) {
            z = true;
        }
        g0Var.r = z;
        VideoPbFragment videoPbFragment2 = this.f55074a;
        if (videoPbFragment2.S2(videoPbFragment2.L().y0()) != null) {
            VideoPbFragment videoPbFragment3 = this.f55074a;
            g0Var.s = videoPbFragment3.S2(videoPbFragment3.L().y0()).S;
        }
        v0(g0Var);
    }

    public final void i0(View view) {
        if (view == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(this.M ? 2 : 3));
        view.setTag(sparseArray);
    }

    public void j0(boolean z) {
        this.M = z;
    }

    public void k0(String str) {
        this.F = str;
    }

    public final boolean l0(boolean z) {
        d0 d0Var;
        int i2;
        VideoPbFragment videoPbFragment = this.f55074a;
        if (videoPbFragment == null || videoPbFragment.L() == null || this.f55074a.L().y0() == null) {
            return false;
        }
        d.b.j0.d2.h.e y0 = this.f55074a.L().y0();
        a2 L = y0.L();
        if (L != null) {
            if (L.O1() || L.R1()) {
                return false;
            }
            if (L.P1() || L.Q1()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (L == null || L.T() == null || !L.T().isForumBusinessAccount() || d.b.j0.q0.w0.isOn()) {
            if (y0.l() == null || !y0.l().isBlockBawuDelete) {
                if (y0.S() != 0) {
                    return y0.S() != 3;
                }
                List<w1> p2 = y0.p();
                if (ListUtils.getCount(p2) > 0) {
                    for (w1 w1Var : p2) {
                        if (w1Var != null && (d0Var = w1Var.f51665g) != null && d0Var.f51500a && !d0Var.f51502c && ((i2 = d0Var.f51501b) == 1 || i2 == 2)) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public void m0(SparseArray<Object> sparseArray) {
        PostData postData;
        d.b.i0.r.s.h hVar;
        d.b.i0.r.s.h hVar2;
        d.b.i0.r.s.h hVar3;
        VideoPbFragment videoPbFragment;
        int i2;
        VideoPbFragment videoPbFragment2 = this.f55074a;
        if (videoPbFragment2 == null || videoPbFragment2.L() == null || sparseArray == null || (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        if (this.f55076c == null) {
            d.b.i0.r.s.l lVar = new d.b.i0.r.s.l(this.f55074a.getContext());
            this.f55076c = lVar;
            lVar.n(this.L);
        }
        ArrayList arrayList = new ArrayList();
        boolean z = this.f55074a.L().y0() != null && this.f55074a.L().y0().a0();
        if (sparseArray != null) {
            boolean booleanValue = sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
            String str = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
            if (postData.r() != null) {
                boolean z2 = postData.r().hasAgree;
                int s2 = postData.s();
                if (z2 && s2 == 5) {
                    videoPbFragment = this.f55074a;
                    i2 = R.string.action_cancel_dislike;
                } else {
                    videoPbFragment = this.f55074a;
                    i2 = R.string.action_dislike;
                }
                d.b.i0.r.s.h hVar4 = new d.b.i0.r.s.h(8, videoPbFragment.getString(i2), this.f55076c);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_clip_board, postData);
                hVar4.f51748d.setTag(sparseArray2);
                arrayList.add(hVar4);
            }
            if (TbadkCoreApplication.isLogin()) {
                if (!booleanValue3 && booleanValue2) {
                    d.b.i0.r.s.h hVar5 = new d.b.i0.r.s.h(5, this.f55074a.getString(R.string.mute_option), this.f55076c);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    int i3 = R.id.tag_is_mem;
                    sparseArray3.put(i3, sparseArray.get(i3));
                    int i4 = R.id.tag_user_mute_mute_userid;
                    sparseArray3.put(i4, sparseArray.get(i4));
                    int i5 = R.id.tag_user_mute_mute_username;
                    sparseArray3.put(i5, sparseArray.get(i5));
                    int i6 = R.id.tag_user_mute_mute_nameshow;
                    sparseArray3.put(i6, sparseArray.get(i6));
                    int i7 = R.id.tag_user_mute_post_id;
                    sparseArray3.put(i7, sparseArray.get(i7));
                    int i8 = R.id.tag_user_mute_thread_id;
                    sparseArray3.put(i8, sparseArray.get(i8));
                    int i9 = R.id.tag_del_post_is_self;
                    sparseArray3.put(i9, sparseArray.get(i9));
                    int i10 = R.id.tag_del_post_type;
                    sparseArray3.put(i10, sparseArray.get(i10));
                    int i11 = R.id.tag_del_post_id;
                    sparseArray3.put(i11, sparseArray.get(i11));
                    int i12 = R.id.tag_manage_user_identity;
                    sparseArray3.put(i12, sparseArray.get(i12));
                    hVar5.f51748d.setTag(sparseArray3);
                    arrayList.add(hVar5);
                } else {
                    if ((Y(booleanValue) && TbadkCoreApplication.isLogin()) && !z) {
                        d.b.i0.r.s.h hVar6 = new d.b.i0.r.s.h(5, this.f55074a.getString(R.string.report_text), this.f55076c);
                        hVar6.f51748d.setTag(str);
                        arrayList.add(hVar6);
                    }
                }
                if (booleanValue3) {
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    int i13 = R.id.tag_manage_user_identity;
                    sparseArray4.put(i13, sparseArray.get(i13));
                    int i14 = R.id.tag_forbid_user_name;
                    sparseArray4.put(i14, sparseArray.get(i14));
                    int i15 = R.id.tag_forbid_user_name_show;
                    sparseArray4.put(i15, sparseArray.get(i15));
                    int i16 = R.id.tag_forbid_user_portrait;
                    sparseArray4.put(i16, sparseArray.get(i16));
                    sparseArray4.put(R.id.tag_forbid_user_post_id, str);
                    if (booleanValue4) {
                        sparseArray4.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        int i17 = R.id.tag_is_mem;
                        sparseArray4.put(i17, sparseArray.get(i17));
                        int i18 = R.id.tag_user_mute_mute_userid;
                        sparseArray4.put(i18, sparseArray.get(i18));
                        int i19 = R.id.tag_user_mute_mute_username;
                        sparseArray4.put(i19, sparseArray.get(i19));
                        int i20 = R.id.tag_user_mute_mute_nameshow;
                        sparseArray4.put(i20, sparseArray.get(i20));
                        int i21 = R.id.tag_user_mute_post_id;
                        sparseArray4.put(i21, sparseArray.get(i21));
                        int i22 = R.id.tag_user_mute_thread_id;
                        sparseArray4.put(i22, sparseArray.get(i22));
                    } else {
                        sparseArray4.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (booleanValue5) {
                        sparseArray4.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray4.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue));
                        int i23 = R.id.tag_del_post_id;
                        sparseArray4.put(i23, sparseArray.get(i23));
                        int i24 = R.id.tag_del_post_type;
                        sparseArray4.put(i24, sparseArray.get(i24));
                        int i25 = R.id.tag_has_sub_post;
                        sparseArray4.put(i25, sparseArray.get(i25));
                        hVar2 = new d.b.i0.r.s.h(6, this.f55074a.getString(R.string.delete), this.f55076c);
                        hVar2.f51748d.setTag(sparseArray4);
                    } else {
                        sparseArray4.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                        hVar2 = null;
                    }
                    hVar = new d.b.i0.r.s.h(7, this.f55074a.getString(R.string.bar_manager), this.f55076c);
                    hVar.f51748d.setTag(sparseArray4);
                } else if (booleanValue5) {
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    sparseArray5.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    sparseArray5.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    int i26 = R.id.tag_manage_user_identity;
                    sparseArray5.put(i26, sparseArray.get(i26));
                    sparseArray5.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue));
                    int i27 = R.id.tag_del_post_id;
                    sparseArray5.put(i27, sparseArray.get(i27));
                    int i28 = R.id.tag_del_post_type;
                    sparseArray5.put(i28, sparseArray.get(i28));
                    int i29 = R.id.tag_has_sub_post;
                    sparseArray5.put(i29, sparseArray.get(i29));
                    if (this.f55074a.L().y0().S() == 1002 && !booleanValue) {
                        hVar3 = new d.b.i0.r.s.h(6, this.f55074a.getString(R.string.report_text), this.f55076c);
                    } else {
                        hVar3 = new d.b.i0.r.s.h(6, this.f55074a.getString(R.string.delete), this.f55076c);
                    }
                    hVar3.f51748d.setTag(sparseArray5);
                    hVar2 = hVar3;
                    hVar = null;
                } else {
                    hVar = null;
                    hVar2 = null;
                }
                if (hVar2 != null) {
                    arrayList.add(hVar2);
                }
                if (hVar != null) {
                    arrayList.add(hVar);
                }
                if (!booleanValue) {
                    arrayList.add(new d.b.i0.r.s.h(9, TbadkCoreApplication.getInst().getString(R.string.block_user), this.f55076c));
                }
            }
            this.f55076c.k(arrayList);
            d.b.i0.r.s.j jVar = new d.b.i0.r.s.j(this.f55074a.getPageContext(), this.f55076c);
            this.f55075b = jVar;
            jVar.l();
        }
    }

    public final boolean n0(boolean z) {
        VideoPbFragment videoPbFragment;
        if (z || (videoPbFragment = this.f55074a) == null || videoPbFragment.L() == null || this.f55074a.L().y0() == null || (this.f55074a.L().y0().l() != null && this.f55074a.L().y0().l().isBlockBawuDelete)) {
            return false;
        }
        d.b.j0.d2.h.e y0 = this.f55074a.L().y0();
        return ((y0.L() != null && y0.L().T() != null && y0.L().T().isForumBusinessAccount() && !d.b.j0.q0.w0.isOn()) || this.f55074a.L().y0().S() == 0 || this.f55074a.L().y0().S() == 3) ? false : true;
    }

    public final boolean o0() {
        VideoPbFragment videoPbFragment = this.f55074a;
        if (videoPbFragment == null || videoPbFragment.L() == null || !this.f55074a.L().M0()) {
            return false;
        }
        return this.f55074a.L().w0() == null || this.f55074a.L().w0().c() != 0;
    }

    public void p0(MetaData metaData) {
        if (metaData == null) {
            return;
        }
        d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(this.f55074a.getActivity());
        aVar.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_done));
        aVar.setTitleShowCenter(true);
        aVar.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like));
        aVar.setMessageShowCenter(true);
        aVar.setCancelable(false);
        aVar.setNegativeButton(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_cancel), new e(this, metaData));
        aVar.setPositiveButton(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_confirm), new f(metaData));
        aVar.create(this.f55074a.getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public void q0() {
        if (this.r == null) {
            this.r = new d.b.i0.r.f0.a(this.f55074a.getPageContext());
        }
        this.r.h(true);
    }

    public void r0() {
        d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(this.f55074a.getPageContext().getPageActivity());
        aVar.setMessage(this.f55074a.getResources().getString(R.string.mute_is_super_member_function));
        aVar.setPositiveButton(R.string.open_now, new r());
        aVar.setNegativeButton(R.string.cancel, new s(this));
        aVar.create(this.f55074a.getPageContext()).show();
    }

    public void s0(boolean z, SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            d.b.i0.r.s.j jVar = this.f55075b;
            if (jVar != null && jVar.isShowing()) {
                this.f55075b.dismiss();
                this.f55075b = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                d.b.i0.r.s.l lVar = new d.b.i0.r.s.l(this.f55074a.getBaseFragmentActivity());
                lVar.n(new q(sparseArray, z, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1) == 1) {
                    arrayList.add(new d.b.i0.r.s.h(0, TbadkCoreApplication.getInst().getResources().getString(R.string.delete), lVar));
                }
                if (z) {
                    arrayList.add(new d.b.i0.r.s.h(1, TbadkCoreApplication.getInst().getResources().getString(R.string.un_mute), lVar));
                } else {
                    arrayList.add(new d.b.i0.r.s.h(1, TbadkCoreApplication.getInst().getResources().getString(R.string.mute), lVar));
                }
                lVar.k(arrayList);
                d.b.i0.r.s.j jVar2 = new d.b.i0.r.s.j(this.f55074a.getPageContext(), lVar);
                this.f55075b = jVar2;
                jVar2.l();
            }
        }
    }

    public void t0(b.c cVar, boolean z) {
        d.b.i0.r.s.j jVar = this.f55077d;
        if (jVar != null) {
            jVar.dismiss();
            this.f55077d = null;
        }
        d.b.i0.r.s.l lVar = new d.b.i0.r.s.l(this.f55074a.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.f55074a.L().y0() != null && this.f55074a.L().y0().L() != null && !this.f55074a.L().y0().L().S1()) {
            arrayList.add(new d.b.i0.r.s.h(0, this.f55074a.getPageContext().getString(R.string.save_to_emotion), lVar));
        }
        if (!z) {
            arrayList.add(new d.b.i0.r.s.h(1, this.f55074a.getPageContext().getString(R.string.save_to_local), lVar));
        }
        lVar.k(arrayList);
        lVar.n(new k(cVar));
        d.b.i0.r.s.j jVar2 = new d.b.i0.r.s.j(this.f55074a.getPageContext(), lVar);
        this.f55077d = jVar2;
        jVar2.l();
    }

    public void u0(AdapterView.OnItemClickListener onItemClickListener) {
        d.b.i0.r.s.e eVar = this.f55081h;
        if (eVar != null) {
            eVar.d();
            this.f55081h = null;
        }
        if (this.f55074a.L() == null) {
            return;
        }
        ArrayList<d.b.i0.r.s.n> arrayList = new ArrayList<>();
        arrayList.add(new d.b.i0.r.s.n(this.f55074a.getContext().getString(R.string.all_person), "", this.f55074a.L().H0() == 1, Integer.toString(1)));
        arrayList.add(new d.b.i0.r.s.n(this.f55074a.getContext().getString(R.string.my_fans), "", this.f55074a.L().H0() == 2, Integer.toString(5)));
        arrayList.add(new d.b.i0.r.s.n(this.f55074a.getContext().getString(R.string.my_attentions), "", this.f55074a.L().H0() == 3, Integer.toString(6)));
        arrayList.add(new d.b.i0.r.s.n(this.f55074a.getContext().getString(R.string.myself_only), "", this.f55074a.L().H0() == 4, Integer.toString(7)));
        d.b.i0.r.s.e eVar2 = new d.b.i0.r.s.e(this.f55074a.getPageContext());
        eVar2.l(R.string.pb_privacy_setting_thread_reply_decs);
        this.f55081h = eVar2;
        eVar2.k(arrayList, onItemClickListener);
        eVar2.c();
        this.f55081h.n();
    }

    public void v0(g0 g0Var) {
        if (this.f55074a.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        VideoPbFragment videoPbFragment = this.f55074a;
        this.u = new f0(videoPbFragment, videoPbFragment.G1);
        AlertDialog create = new AlertDialog.Builder(this.f55074a.getContext(), R.style.DialogTheme).create();
        this.t = create;
        create.setCanceledOnTouchOutside(true);
        d.b.c.e.m.g.i(this.t, this.f55074a.getFragmentActivity());
        Window window = this.t.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.u.u());
        this.u.L(g0Var == null ? false : g0Var.f54575a);
        this.u.z(g0Var == null ? false : g0Var.f54579e);
        this.u.F(g0Var == null ? false : g0Var.i);
        this.u.A(g0Var == null ? false : g0Var.f54580f);
        this.u.O(g0Var != null ? g0Var.f54577c : true);
        this.u.K(g0Var == null ? false : g0Var.k);
        if (g0Var == null) {
            this.u.I(false, false);
            this.u.G(false, false);
        } else {
            this.u.I(g0Var.f54581g, g0Var.p);
            this.u.G(g0Var.f54582h, g0Var.o);
        }
        boolean z = g0Var == null ? false : g0Var.n;
        boolean z2 = g0Var == null ? false : g0Var.l;
        boolean z3 = g0Var == null ? false : g0Var.f54578d;
        boolean z4 = g0Var == null ? false : g0Var.f54576b;
        boolean z5 = g0Var == null ? false : g0Var.m;
        boolean z6 = g0Var == null ? false : g0Var.j;
        this.u.B(z3, z2);
        this.u.M(z4, z);
        this.u.J(z6, z5);
        if (g0Var != null) {
            f0 f0Var = this.u;
            boolean z7 = g0Var.q;
            f0Var.u = z7;
            if (z7) {
                f0Var.f().setText(R.string.report_text);
                this.u.A(false);
            }
        }
        this.u.y(g0Var != null ? g0Var.r : false);
        if (!TbSingleton.getInstance().mCanCallFans && this.f55074a.L() != null && this.f55074a.L().y0() != null && this.f55074a.L().y0().N() != null && this.f55074a.L().y0().N().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.u.d().setText(R.string.have_called_fans_short);
        }
        A0();
    }

    public void w0(View view) {
        String[] strArr;
        VideoPbFragment videoPbFragment = this.f55074a;
        if (videoPbFragment == null || videoPbFragment.L() == null) {
            return;
        }
        d.b.i0.r.s.j jVar = new d.b.i0.r.s.j(this.f55074a.getPageContext());
        if (this.f55074a.L().y0().f54241f == null || this.f55074a.L().y0().f54241f.size() <= 0) {
            strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
        } else {
            strArr = new String[this.f55074a.L().y0().f54241f.size()];
            for (int i2 = 0; i2 < this.f55074a.L().y0().f54241f.size(); i2++) {
                strArr[i2] = this.f55074a.L().y0().f54241f.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
            }
        }
        jVar.i(null, strArr, new d(jVar, view));
        jVar.l();
    }

    public void x0(String str) {
        if (str == null) {
            str = "";
        }
        VideoPbFragment videoPbFragment = this.f55074a;
        if (videoPbFragment == null || videoPbFragment.getPageContext() == null) {
            return;
        }
        d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(this.f55074a.getPageContext().getPageActivity());
        aVar.setMessage(str);
        aVar.setNegativeButton(R.string.know, new g(this));
        aVar.create(this.f55074a.getPageContext()).show();
    }

    public final void y0(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            q0();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(this.f55074a.getBaseFragmentActivity());
        if (d.b.c.e.p.k.isEmpty(str)) {
            aVar.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.setMessage(str);
        }
        aVar.setPositiveButton(R.string.confirm, new h(userMuteAddAndDelCustomMessage));
        aVar.setNegativeButton(R.string.cancel, new i(this));
        aVar.create(this.f55074a.getPageContext()).show();
    }

    public final void z0(int i2) {
        TiebaStatic.log(new StatisticItem("c14000").param("tid", this.f55074a.L().O0()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(d.b.j0.d2.k.e.d1.a.m(i2))));
    }
}
