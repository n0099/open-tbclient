package d.b.i0.d2.k.e.z0;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.h0.r.q.a2;
import d.b.h0.z0.l0;
import d.b.i0.d2.k.e.h;
import d.b.i0.d2.k.e.q0;
import d.b.i0.d2.k.e.r0;
import d.b.i0.x.m;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f54409a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.d2.i.c f54410b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f54411c;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.b0.e f54413e;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f54415g;

    /* renamed from: h  reason: collision with root package name */
    public h f54416h;
    public ThreadSkinView j;
    public ImageView m;
    public HeadPendantView n;
    public TBLottieAnimationView o;
    public UserIconBox p;
    public UserIconBox q;
    public LinearLayout s;
    public LinearLayout t;
    public q0 w;

    /* renamed from: d  reason: collision with root package name */
    public View.OnLongClickListener f54412d = null;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f54414f = null;
    public ColumnLayout i = null;
    public TextView k = null;
    public TextView l = null;
    public FrameLayout r = null;
    public ClickableHeaderImageView u = null;
    public PbFirstFloorUserLikeButton v = null;
    public TextView x = null;
    public TextView y = null;
    public TextView z = null;
    public TextView A = null;
    public TextView B = null;
    public int C = 0;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f54417e;

        public a(int i) {
            this.f54417e = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int measuredWidth = e.this.t.getMeasuredWidth();
            int measuredWidth2 = e.this.y.getMeasuredWidth();
            int measuredWidth3 = e.this.B.getMeasuredWidth();
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
            int i = (measuredWidth - measuredWidth2) - measuredWidth3;
            int i2 = this.f54417e;
            if (i < i2) {
                e.this.A.setVisibility(8);
                e.this.z.setVisibility(8);
            } else if (i - i2 < dimenPixelSize) {
                e.this.z.setVisibility(8);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.o.playAnimation();
        }
    }

    public e(PbFragment pbFragment, d.b.i0.d2.i.c cVar, View.OnClickListener onClickListener) {
        this.f54411c = null;
        this.f54409a = pbFragment;
        this.f54410b = cVar;
        this.f54411c = onClickListener;
        o();
    }

    public void A(PostData postData, boolean z) {
        if (this.f54409a.isSimpleForum()) {
            this.C = 0;
            if (postData != null && postData.t() != null) {
                this.C = postData.t().getLevel_id();
            }
            if (this.C > 0 && !z) {
                this.m.setVisibility(0);
                SkinManager.setImageResource(this.m, BitmapHelper.getGradeResourceIdInEnterForum(this.C));
                return;
            }
            this.m.setVisibility(8);
            return;
        }
        this.m.setVisibility(8);
    }

    public void B(d.b.i0.d2.h.e eVar, PostData postData, boolean z) {
        if (eVar == null || postData == null) {
            return;
        }
        if (3 != eVar.g()) {
            this.v.setVisibility(0);
        }
        if (z) {
            this.v.setVisibility(8);
            if (eVar != null && eVar.L() != null && eVar.L().V() != null && eVar.L().V().oriUgcType == 3) {
                this.x.setVisibility(8);
            } else {
                this.x.setVisibility(0);
            }
            this.x.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), StringHelper.numberUniformFormatExtra(eVar.M())));
        } else if (PbNormalLikeButtonSwitch.getIsOn() && !postData.t().hadConcerned()) {
            this.x.setVisibility(8);
        } else {
            this.v.setVisibility(8);
            this.x.setVisibility(8);
        }
        if (eVar.i || 3 == eVar.g()) {
            this.v.setVisibility(8);
        }
    }

    public void g(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.f54414f);
        }
    }

    public void h(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.x(this.f54414f, i);
        }
    }

    public void i(d.b.i0.d2.h.e eVar, boolean z, boolean z2) {
        if (eVar != null && eVar.j) {
            this.f54415g.setImageResource(R.drawable.pic_frs_headlines_n);
            this.f54415g.setVisibility(0);
        } else if (z && z2) {
            this.f54415g.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.f54415g.setVisibility(0);
        } else if (z) {
            this.f54415g.setImageResource(R.drawable.pic_pb_refined_n);
            this.f54415g.setVisibility(0);
        } else if (z2) {
            this.f54415g.setImageResource(R.drawable.pic_pb_stick_n);
            this.f54415g.setVisibility(0);
        } else {
            this.f54415g.setVisibility(8);
        }
    }

    public void j() {
        d.b.i0.b0.e eVar = this.f54413e;
        if (eVar != null) {
            eVar.H();
        }
    }

    public TextView k() {
        return this.f54416h.e();
    }

    public View l() {
        return this.f54414f;
    }

    public final SpannableStringBuilder m(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 == null || str == null) {
            return spannableStringBuilder;
        }
        arrayList.add(new m.a(str));
        return m.h(this.f54409a.getActivity(), str2, arrayList, true);
    }

    public SparseArray<Object> n() {
        SparseArray<Object> sparseArray = (SparseArray) this.i.getTag();
        if (sparseArray == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            this.i.setTag(sparseArray2);
            return sparseArray2;
        }
        return sparseArray;
    }

    public final void o() {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f54409a.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.f54414f = relativeLayout;
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.f54415g = imageView;
        imageView.getLayoutParams().height = r0.f();
        h hVar = new h(this.f54409a.getBaseFragmentActivity(), this.f54414f);
        this.f54416h = hVar;
        hVar.a();
        h hVar2 = this.f54416h;
        hVar2.d(hVar2.e(), this.f54411c);
        this.i = (ColumnLayout) this.f54414f.findViewById(R.id.pb_head_owner_root);
        this.j = (ThreadSkinView) this.f54414f.findViewById(R.id.pb_thread_skin);
        this.k = (TextView) this.i.findViewById(R.id.pb_head_owner_info_user_name);
        this.l = (TextView) this.i.findViewById(R.id.floor_owner);
        this.m = (ImageView) this.i.findViewById(R.id.icon_forum_level);
        this.r = (FrameLayout) this.i.findViewById(R.id.pb_head_headImage_container);
        HeadPendantView headPendantView = (HeadPendantView) this.i.findViewById(R.id.pb_pendant_head_owner_photo);
        this.n = headPendantView;
        headPendantView.setHasPendantStyle();
        this.o = (TBLottieAnimationView) this.i.findViewById(R.id.pb_head_living_lottie);
        this.i.setOnLongClickListener(this.f54412d);
        this.i.setOnTouchListener(this.f54410b);
        this.i.setVisibility(8);
        if (this.n.getHeadView() != null) {
            this.n.getHeadView().setIsRound(true);
            this.n.getHeadView().setDrawBorder(true);
            this.n.getHeadView().setPlaceHolder(1);
        }
        this.p = (UserIconBox) this.i.findViewById(R.id.show_icon_vip);
        this.q = (UserIconBox) this.i.findViewById(R.id.show_icon_yinji);
        this.s = (LinearLayout) this.f54414f.findViewById(R.id.pb_head_owner_info_root);
        this.t = (LinearLayout) this.i.findViewById(R.id.pb_first_floor_location_container);
        this.v = (PbFirstFloorUserLikeButton) this.i.findViewById(R.id.pb_like_button);
        this.x = (TextView) this.i.findViewById(R.id.pb_views);
        this.y = (TextView) this.i.findViewById(R.id.pb_item_first_floor_reply_time);
        this.z = (TextView) this.i.findViewById(R.id.pb_item_first_floor_location_address);
        this.A = (TextView) this.i.findViewById(R.id.pb_item_first_floor_distance);
        this.B = (TextView) this.i.findViewById(R.id.pb_item_first_floor_general_desc);
    }

    public void p(int i) {
        ImageView imageView = this.m;
        if (imageView != null) {
            SkinManager.setImageResource(imageView, BitmapHelper.getGradeResourceIdInEnterForum(this.C));
        }
        PbFirstFloorUserLikeButton pbFirstFloorUserLikeButton = this.v;
        if (pbFirstFloorUserLikeButton != null) {
            pbFirstFloorUserLikeButton.r(i);
        }
        TextView textView = this.z;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
        }
        TextView textView2 = this.y;
        if (textView2 != null) {
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0109);
        }
        TextView textView3 = this.x;
        if (textView3 != null) {
            SkinManager.setViewTextColor(textView3, R.color.CAM_X0109);
        }
        TextView textView4 = this.B;
        if (textView4 != null) {
            SkinManager.setViewTextColor(textView4, R.color.CAM_X0109);
        }
        TextView textView5 = this.A;
        if (textView5 != null) {
            SkinManager.setViewTextColor(textView5, R.color.CAM_X0109);
        }
        TBLottieAnimationView tBLottieAnimationView = this.o;
        if (tBLottieAnimationView != null) {
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
        }
    }

    public void q() {
        d.b.i0.b0.e eVar = this.f54413e;
        if (eVar != null) {
            eVar.H();
        }
        ColumnLayout columnLayout = this.i;
        if (columnLayout != null && this.u != null) {
            columnLayout.removeView(this.r);
            this.u = null;
        }
        TBLottieAnimationView tBLottieAnimationView = this.o;
        if (tBLottieAnimationView != null) {
            tBLottieAnimationView.cancelAnimation();
        }
    }

    public void r(d.b.i0.d2.h.e eVar, PostData postData, boolean z, boolean z2) {
        if (eVar == null || postData == null) {
            return;
        }
        String N = eVar != null ? eVar.N() : "";
        int h2 = r0.h(eVar);
        if (z && postData != null && postData.t() != null) {
            postData.t().setIsLike(postData.t().hadConcerned());
        }
        if (this.w == null) {
            a2 L = eVar.L();
            int i = 1;
            if (L != null) {
                if (L.O1()) {
                    i = 4;
                } else if (L.R1()) {
                    i = 6;
                } else if (L.Q1()) {
                    i = 7;
                } else if (L.P1()) {
                    i = 5;
                } else if (L.A2()) {
                    i = 8;
                }
            }
            q0 q0Var = new q0(this.f54409a.getPageContext(), this.v, i);
            this.w = q0Var;
            q0Var.l(this.f54409a.getUniqueId());
            this.w.v(L);
        }
        if (postData != null && postData.t() != null) {
            postData.t().setIsLike(postData.t().hadConcerned());
            this.w.n(postData.t());
            this.w.x(N);
        }
        q0 q0Var2 = this.w;
        q0Var2.r = z2;
        q0Var2.w(h2);
    }

    public void s(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.f54414f);
        }
    }

    public void t(View.OnLongClickListener onLongClickListener) {
        this.f54412d = onLongClickListener;
        this.i.setOnLongClickListener(onLongClickListener);
    }

    public void u(PostData postData, d.b.i0.d2.h.e eVar) {
        if (postData == null || eVar == null) {
            return;
        }
        if (postData.L() != null) {
            this.j.setData(this.f54409a.getPageContext(), eVar.D().get(0).L(), d.b.i0.d3.j0.a.a("PB", "c0132", eVar.l().getId(), eVar.l().getName(), eVar.L().o0(), this.f54409a.Z4() ? "FRS" : null));
            ColumnLayout columnLayout = this.i;
            columnLayout.setPadding(columnLayout.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.i.getPaddingRight(), this.i.getPaddingBottom());
            return;
        }
        this.j.setData(null, null, null);
    }

    public void v(boolean z) {
        this.f54416h.g(z);
    }

    public void w(d.b.i0.d2.h.e eVar) {
        if (eVar != null && eVar.f0()) {
            int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.ds45);
            int paddingBottom = this.i.getPaddingBottom();
            if (eVar.a0()) {
                g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                paddingBottom = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8);
            }
            ColumnLayout columnLayout = this.i;
            columnLayout.setPadding(columnLayout.getPaddingLeft(), g2, this.i.getPaddingRight(), paddingBottom);
            return;
        }
        int g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds60);
        int paddingBottom2 = this.i.getPaddingBottom();
        if (eVar != null && !eVar.L().z2() && eVar.a0() && (!StringUtils.isNull(eVar.L().x1()) || eVar.L().l1() != null)) {
            g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);
        }
        ColumnLayout columnLayout2 = this.i;
        columnLayout2.setPadding(columnLayout2.getPaddingLeft(), g3, this.i.getPaddingRight(), paddingBottom2);
    }

    public void x(int i) {
        this.i.setVisibility(i);
    }

    public void y(int i, d.b.i0.d2.h.e eVar, PostData postData, View.OnClickListener onClickListener) {
        boolean z;
        if (postData != null && postData.t() != null) {
            MetaData t = postData.t();
            String string = t.getName_show() == null ? StringUtils.string(t.getUserName()) : StringUtils.string(t.getName_show());
            if ((!StringUtils.isNull(postData.t().getSealPrefix()) ? k.byteLength(t.getSealPrefix()) + 2 : 0) > 0) {
                if (k.byteLength(string) > 12) {
                    string = StringHelper.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                }
            } else if (k.byteLength(string) > 14) {
                string = StringHelper.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
            }
            ArrayList<IconData> iconInfo = t.getIconInfo();
            ArrayList<IconData> tShowInfoNew = t.getTShowInfoNew();
            UserIconBox userIconBox = this.q;
            if (userIconBox != null) {
                userIconBox.setTag(R.id.tag_user_id, t.getUserId());
                if (this.f54409a.P() != null) {
                    this.q.setOnClickListener(this.f54409a.P().mEvent.f54024c);
                }
                int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                this.q.g(iconInfo, 4, g2, g2, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            }
            if (this.p != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    this.p.setTag(tShowInfoNew.get(0).getUrl());
                }
                if (this.f54409a.P() != null) {
                    this.p.setOnClickListener(this.f54409a.P().mEvent.f54025d);
                }
                int g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                this.p.h(tShowInfoNew, 3, g3, g3, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            this.k.setText(m(t.getSealPrefix(), string));
            this.k.setTag(R.id.tag_user_id, t.getUserId());
            this.k.setTag(R.id.tag_user_name, t.getName_show());
            if (ListUtils.isEmpty(tShowInfoNew) && !t.isBigV()) {
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1);
            } else {
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0301, 1);
            }
            if (eVar.a0()) {
                this.l.setVisibility(8);
            } else if (t.getIs_bawu() == 1 && postData.X()) {
                d.b.h0.r.u.c d2 = d.b.h0.r.u.c.d(this.l);
                d2.q(R.color.CAM_X0101);
                d2.k(R.string.J_X04);
                d2.f(R.color.CAM_X0302);
                this.l.setVisibility(0);
                this.l.setText(R.string.brand_official);
            } else if (t.getIs_bawu() == 1 && "manager".equals(t.getBawu_type())) {
                this.l.setText(R.string.bawu_member_bazhu_tip);
                this.l.setVisibility(0);
                d.b.h0.r.u.c d3 = d.b.h0.r.u.c.d(this.l);
                d3.q(R.color.CAM_X0101);
                d3.k(R.string.J_X04);
                d3.f(R.color.CAM_X0302);
            } else if (t.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(t.getBawu_type())) {
                this.l.setText(R.string.bawu_member_xbazhu_tip);
                this.l.setVisibility(0);
                d.b.h0.r.u.c d4 = d.b.h0.r.u.c.d(this.l);
                d4.q(R.color.CAM_X0101);
                d4.k(R.string.J_X04);
                d4.f(R.color.CAM_X0302);
            } else {
                this.l.setVisibility(8);
            }
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.R()), "yyyy"))) {
                this.y.setText(StringHelper.getFormatTimeShort(postData.R()));
            } else {
                this.y.setText(StringHelper.getFormatTime(postData.R()));
            }
            if (eVar.a0()) {
                this.z.setVisibility(8);
                if (this.t.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                    ((FrameLayout.LayoutParams) ((ColumnLayout.LayoutParams) this.t.getLayoutParams())).rightMargin = 0;
                }
                this.i.setSpacingRight(0);
                String str = t.getBaijiahaoInfo() != null ? t.getBaijiahaoInfo().auth_desc : null;
                if (t.isNewGod()) {
                    this.B.setVisibility(0);
                    this.B.setText(t.getNewGodData().getFieldName() + l0.c(t.isVideoGod()));
                } else if (t.showBazhuGrade()) {
                    this.B.setVisibility(0);
                    this.B.setText(StringHelper.cutChineseAndEnglishWithSuffix(t.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                } else if (!StringUtils.isNull(str)) {
                    this.B.setVisibility(0);
                    this.B.setText(str);
                } else {
                    this.B.setVisibility(8);
                }
            } else {
                if (t.isNewGod()) {
                    this.B.setVisibility(0);
                    this.B.setText(t.getNewGodData().getFieldName() + l0.a(t.getNewGodData().getType()));
                } else if (t.showBazhuGrade()) {
                    this.B.setVisibility(0);
                    this.B.setText(StringHelper.cutChineseAndEnglishWithSuffix(t.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                } else {
                    this.B.setVisibility(8);
                }
                if (this.t.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                    ((FrameLayout.LayoutParams) ((ColumnLayout.LayoutParams) this.t.getLayoutParams())).rightMargin = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                }
                this.i.setSpacingRight(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                d.b.h0.t.g I = postData.I();
                if (I != null && !TextUtils.isEmpty(I.b()) && !TextUtils.isEmpty(I.b().trim())) {
                    this.z.setVisibility(0);
                    this.z.setText(I.b());
                } else {
                    this.z.setVisibility(8);
                }
                if (I != null && !TextUtils.isEmpty(I.a())) {
                    this.A.setText(I.a());
                    this.A.setVisibility(0);
                    this.t.post(new a((int) this.A.getPaint().measureText(I.a(), 0, I.a().length())));
                } else {
                    this.A.setVisibility(8);
                }
            }
            if (eVar.L().T() == null || eVar.L().T().getAlaInfo() == null || eVar.L().T().getAlaInfo().live_status != 1) {
                z = false;
            } else {
                z();
                z = true;
            }
            this.n.setBigVDimenSize(R.dimen.tbds32);
            if (!z) {
                this.n.i(t, 4);
                this.n.setIsclearmode(false);
            } else {
                this.n.setIsclearmode(true);
            }
            this.n.setVisibility(0);
            ClickableHeaderImageView clickableHeaderImageView = this.u;
            if (clickableHeaderImageView != null) {
                clickableHeaderImageView.setVisibility(8);
            }
            this.k.setOnClickListener(onClickListener);
            this.n.getHeadView().setUserId(t.getUserId());
            this.n.getHeadView().setUserName(t.getUserName());
            this.n.getHeadView().setTid(postData.E());
            this.n.getHeadView().setFid(eVar != null ? eVar.m() : "");
            this.n.getHeadView().setFName(eVar.n());
            this.n.getHeadView().setOnClickListener(onClickListener);
            if (z) {
                this.n.k(t.getAvater());
            } else {
                this.n.m(t);
            }
            String name_show = t.getName_show();
            String userName = t.getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                this.k.setText(d.b.i0.d2.c.b(this.f54409a.getPageContext().getPageActivity(), this.k.getText().toString()));
                this.k.setGravity(16);
                this.k.setTag(R.id.tag_nick_name_activity, d.b.i0.d2.c.a());
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0312, 1);
            }
        }
        if (eVar != null) {
            this.f54416h.f(eVar.L());
        }
    }

    public final void z() {
        TBLottieAnimationView tBLottieAnimationView = this.o;
        if (tBLottieAnimationView != null) {
            tBLottieAnimationView.setVisibility(0);
            this.o.setSpeed(0.8f);
            this.o.loop(true);
            this.o.post(new b());
        }
    }
}
