package d.a.n0.e2.k.e.a1;

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
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
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
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.m0.r.q.a2;
import d.a.m0.z0.l0;
import d.a.n0.e2.k.e.h;
import d.a.n0.e2.k.e.q0;
import d.a.n0.e2.k.e.r0;
import d.a.n0.z.m;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f56799a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.e2.i.c f56800b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f56801c;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.d0.e f56803e;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f56805g;

    /* renamed from: h  reason: collision with root package name */
    public h f56806h;
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
    public View.OnLongClickListener f56802d = null;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f56804f = null;

    /* renamed from: i  reason: collision with root package name */
    public ColumnLayout f56807i = null;
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

    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f56808e;

        public a(int i2) {
            this.f56808e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int measuredWidth = e.this.t.getMeasuredWidth();
            int measuredWidth2 = e.this.y.getMeasuredWidth();
            int measuredWidth3 = e.this.B.getMeasuredWidth();
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
            int i2 = (measuredWidth - measuredWidth2) - measuredWidth3;
            int i3 = this.f56808e;
            if (i2 < i3) {
                e.this.A.setVisibility(8);
                e.this.z.setVisibility(8);
            } else if (i2 - i3 < dimenPixelSize) {
                e.this.z.setVisibility(8);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.o.playAnimation();
        }
    }

    public e(PbFragment pbFragment, d.a.n0.e2.i.c cVar, View.OnClickListener onClickListener) {
        this.f56801c = null;
        this.f56799a = pbFragment;
        this.f56800b = cVar;
        this.f56801c = onClickListener;
        o();
    }

    public void A(PostData postData, boolean z) {
        if (this.f56799a.isSimpleForum()) {
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

    public void B(d.a.n0.e2.h.e eVar, PostData postData, boolean z) {
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
        if (eVar.f56616i || 3 == eVar.g()) {
            this.v.setVisibility(8);
        }
    }

    public void g(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.f56804f);
        }
    }

    public void h(BdTypeListView bdTypeListView, int i2) {
        if (bdTypeListView != null) {
            bdTypeListView.x(this.f56804f, i2);
        }
    }

    public void i(d.a.n0.e2.h.e eVar, boolean z, boolean z2) {
        if (eVar != null && eVar.j) {
            this.f56805g.setImageResource(R.drawable.pic_frs_headlines_n);
            this.f56805g.setVisibility(0);
        } else if (z && z2) {
            this.f56805g.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.f56805g.setVisibility(0);
        } else if (z) {
            this.f56805g.setImageResource(R.drawable.pic_pb_refined_n);
            this.f56805g.setVisibility(0);
        } else if (z2) {
            this.f56805g.setImageResource(R.drawable.pic_pb_stick_n);
            this.f56805g.setVisibility(0);
        } else {
            this.f56805g.setVisibility(8);
        }
    }

    public void j() {
        d.a.n0.d0.e eVar = this.f56803e;
        if (eVar != null) {
            eVar.I();
        }
    }

    public TextView k() {
        return this.f56806h.e();
    }

    public View l() {
        return this.f56804f;
    }

    public final SpannableStringBuilder m(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 == null || str == null) {
            return spannableStringBuilder;
        }
        arrayList.add(new m.a(str));
        return m.h(this.f56799a.getActivity(), str2, arrayList, true);
    }

    public SparseArray<Object> n() {
        SparseArray<Object> sparseArray = (SparseArray) this.f56807i.getTag();
        if (sparseArray == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            this.f56807i.setTag(sparseArray2);
            return sparseArray2;
        }
        return sparseArray;
    }

    public final void o() {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f56799a.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.f56804f = relativeLayout;
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.f56805g = imageView;
        imageView.getLayoutParams().height = r0.f();
        h hVar = new h(this.f56799a.getBaseFragmentActivity(), this.f56804f);
        this.f56806h = hVar;
        hVar.a();
        h hVar2 = this.f56806h;
        hVar2.d(hVar2.e(), this.f56801c);
        this.f56807i = (ColumnLayout) this.f56804f.findViewById(R.id.pb_head_owner_root);
        this.j = (ThreadSkinView) this.f56804f.findViewById(R.id.pb_thread_skin);
        this.k = (TextView) this.f56807i.findViewById(R.id.pb_head_owner_info_user_name);
        this.l = (TextView) this.f56807i.findViewById(R.id.floor_owner);
        this.m = (ImageView) this.f56807i.findViewById(R.id.icon_forum_level);
        this.r = (FrameLayout) this.f56807i.findViewById(R.id.pb_head_headImage_container);
        HeadPendantView headPendantView = (HeadPendantView) this.f56807i.findViewById(R.id.pb_pendant_head_owner_photo);
        this.n = headPendantView;
        headPendantView.setHasPendantStyle();
        this.o = (TBLottieAnimationView) this.f56807i.findViewById(R.id.pb_head_living_lottie);
        this.f56807i.setOnLongClickListener(this.f56802d);
        this.f56807i.setOnTouchListener(this.f56800b);
        this.f56807i.setVisibility(8);
        if (this.n.getHeadView() != null) {
            this.n.getHeadView().setIsRound(true);
            this.n.getHeadView().setDrawBorder(true);
            this.n.getHeadView().setPlaceHolder(1);
        }
        this.p = (UserIconBox) this.f56807i.findViewById(R.id.show_icon_vip);
        this.q = (UserIconBox) this.f56807i.findViewById(R.id.show_icon_yinji);
        this.s = (LinearLayout) this.f56804f.findViewById(R.id.pb_head_owner_info_root);
        this.t = (LinearLayout) this.f56807i.findViewById(R.id.pb_first_floor_location_container);
        this.v = (PbFirstFloorUserLikeButton) this.f56807i.findViewById(R.id.pb_like_button);
        this.x = (TextView) this.f56807i.findViewById(R.id.pb_views);
        this.y = (TextView) this.f56807i.findViewById(R.id.pb_item_first_floor_reply_time);
        this.z = (TextView) this.f56807i.findViewById(R.id.pb_item_first_floor_location_address);
        this.A = (TextView) this.f56807i.findViewById(R.id.pb_item_first_floor_distance);
        this.B = (TextView) this.f56807i.findViewById(R.id.pb_item_first_floor_general_desc);
    }

    public void p(int i2) {
        SkinManager.setBackgroundColor(this.f56804f, R.color.CAM_X0205);
        ImageView imageView = this.m;
        if (imageView != null) {
            SkinManager.setImageResource(imageView, BitmapHelper.getGradeResourceIdInEnterForum(this.C));
        }
        PbFirstFloorUserLikeButton pbFirstFloorUserLikeButton = this.v;
        if (pbFirstFloorUserLikeButton != null) {
            pbFirstFloorUserLikeButton.r(i2);
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
        d.a.n0.d0.e eVar = this.f56803e;
        if (eVar != null) {
            eVar.I();
        }
        ColumnLayout columnLayout = this.f56807i;
        if (columnLayout != null && this.u != null) {
            columnLayout.removeView(this.r);
            this.u = null;
        }
        TBLottieAnimationView tBLottieAnimationView = this.o;
        if (tBLottieAnimationView != null) {
            tBLottieAnimationView.cancelAnimation();
        }
    }

    public void r(d.a.n0.e2.h.e eVar, PostData postData, boolean z, boolean z2) {
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
            int i2 = 1;
            if (L != null) {
                if (L.R1()) {
                    i2 = 4;
                } else if (L.U1()) {
                    i2 = 6;
                } else if (L.T1()) {
                    i2 = 7;
                } else if (L.S1()) {
                    i2 = 5;
                } else if (L.E2()) {
                    i2 = 8;
                }
            }
            q0 q0Var = new q0(this.f56799a.getPageContext(), this.v, i2);
            this.w = q0Var;
            q0Var.l(this.f56799a.getUniqueId());
            this.w.u(L);
        }
        if (postData != null && postData.t() != null) {
            postData.t().setIsLike(postData.t().hadConcerned());
            this.w.n(postData.t());
            this.w.w(N);
        }
        q0 q0Var2 = this.w;
        q0Var2.s = z2;
        q0Var2.v(h2);
    }

    public void s(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.f56804f);
        }
    }

    public void t(View.OnLongClickListener onLongClickListener) {
        this.f56802d = onLongClickListener;
        this.f56807i.setOnLongClickListener(onLongClickListener);
    }

    public void u(PostData postData, d.a.n0.e2.h.e eVar) {
        if (postData == null || eVar == null) {
            return;
        }
        if (postData.L() != null) {
            this.j.setData(this.f56799a.getPageContext(), eVar.D().get(0).L(), d.a.n0.e3.j0.a.a("PB", "c0132", eVar.l().getId(), eVar.l().getName(), eVar.L().o0(), this.f56799a.d5() ? "FRS" : null));
            ColumnLayout columnLayout = this.f56807i;
            columnLayout.setPadding(columnLayout.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.f56807i.getPaddingRight(), this.f56807i.getPaddingBottom());
            return;
        }
        this.j.setData(null, null, null);
    }

    public void v(boolean z) {
        this.f56806h.g(z);
    }

    public void w(d.a.n0.e2.h.e eVar) {
        if (eVar != null && eVar.f0()) {
            int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.ds45);
            int paddingBottom = this.f56807i.getPaddingBottom();
            if (eVar.a0()) {
                g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                paddingBottom = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8);
            }
            ColumnLayout columnLayout = this.f56807i;
            columnLayout.setPadding(columnLayout.getPaddingLeft(), g2, this.f56807i.getPaddingRight(), paddingBottom);
            return;
        }
        int g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds60);
        int paddingBottom2 = this.f56807i.getPaddingBottom();
        if (eVar != null && !eVar.L().D2() && eVar.a0() && (!StringUtils.isNull(eVar.L().A1()) || eVar.L().n1() != null)) {
            g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);
        }
        ColumnLayout columnLayout2 = this.f56807i;
        columnLayout2.setPadding(columnLayout2.getPaddingLeft(), g3, this.f56807i.getPaddingRight(), paddingBottom2);
    }

    public void x(int i2) {
        this.f56807i.setVisibility(i2);
    }

    public void y(int i2, d.a.n0.e2.h.e eVar, PostData postData, View.OnClickListener onClickListener) {
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
                if (this.f56799a.B() != null) {
                    this.q.setOnClickListener(this.f56799a.B().mEvent.f56885c);
                }
                int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                this.q.g(iconInfo, 4, g2, g2, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            }
            if (this.p != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    this.p.setTag(tShowInfoNew.get(0).getUrl());
                }
                if (this.f56799a.B() != null) {
                    this.p.setOnClickListener(this.f56799a.B().mEvent.f56886d);
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
                d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(this.l);
                d2.s(R.color.CAM_X0101);
                d2.m(R.string.J_X04);
                d2.f(R.color.CAM_X0302);
                this.l.setVisibility(0);
                this.l.setText(R.string.brand_official);
            } else if (t.getIs_bawu() == 1 && "manager".equals(t.getBawu_type())) {
                this.l.setText(R.string.bawu_member_bazhu_tip);
                this.l.setVisibility(0);
                d.a.m0.r.u.c d3 = d.a.m0.r.u.c.d(this.l);
                d3.s(R.color.CAM_X0101);
                d3.m(R.string.J_X04);
                d3.f(R.color.CAM_X0302);
            } else if (t.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(t.getBawu_type())) {
                this.l.setText(R.string.bawu_member_xbazhu_tip);
                this.l.setVisibility(0);
                d.a.m0.r.u.c d4 = d.a.m0.r.u.c.d(this.l);
                d4.s(R.color.CAM_X0101);
                d4.m(R.string.J_X04);
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
                this.f56807i.setSpacingRight(0);
                String str = t.getBaijiahaoInfo() != null ? t.getBaijiahaoInfo().auth_desc : null;
                if (t.isNewGod()) {
                    this.B.setVisibility(0);
                    this.B.setText(t.getNewGodData().getFieldName() + l0.d(t.isVideoGod()));
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
                this.f56807i.setSpacingRight(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                d.a.m0.t.g I = postData.I();
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
                z(eVar);
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
                this.k.setText(d.a.n0.e2.c.b(this.f56799a.getPageContext().getPageActivity(), this.k.getText().toString()));
                this.k.setGravity(16);
                this.k.setTag(R.id.tag_nick_name_activity, d.a.n0.e2.c.a());
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0312, 1);
            }
        }
        if (eVar != null) {
            this.f56806h.f(eVar.L());
        }
    }

    public final void z(d.a.n0.e2.h.e eVar) {
        TBLottieAnimationView tBLottieAnimationView = this.o;
        if (tBLottieAnimationView != null) {
            if (tBLottieAnimationView.getVisibility() != 0 && eVar != null && eVar.L() != null && eVar.L().T() != null) {
                StatisticItem statisticItem = new StatisticItem("c13714");
                statisticItem.param("fid", eVar.m());
                statisticItem.param("fname", eVar.n());
                statisticItem.param("obj_param1", eVar.L().T().getUserId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("tid", eVar.N());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                if (eVar.L().T().getAlaInfo() != null) {
                    AlaInfoData alaInfo = eVar.L().T().getAlaInfo();
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                    if (alaInfo.mYyExtData != null) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                        TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                    }
                }
                TiebaStatic.log(statisticItem);
            }
            this.o.setVisibility(0);
            this.o.setSpeed(0.8f);
            this.o.loop(true);
            this.o.post(new b());
        }
    }
}
