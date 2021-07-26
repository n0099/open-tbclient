package d.a.q0.h2.k;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.d.e.p.l;
import d.a.p0.b.d;
import d.a.p0.b1.j0;
import d.a.p0.s.q.b2;
import d.a.p0.s.u.c;
import d.a.p0.u.f;
import d.a.q0.a0.m;
import d.a.q0.h2.h.e;
import d.a.q0.h2.k.e.r0;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static SparseIntArray f57531a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f57532b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2069497783, "Ld/a/q0/h2/k/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2069497783, "Ld/a/q0/h2/k/b;");
                return;
            }
        }
        new SparseArray();
        f57531a = new SparseIntArray();
        f57532b = i(R.dimen.tbds16);
    }

    public static void a(TbRichTextView tbRichTextView, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65537, null, tbRichTextView, view, z) == null) || tbRichTextView == null || view == null) {
            return;
        }
        int k = (((l.k(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
            k = (k - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
        }
        int i2 = k - (z ? i(R.dimen.tbds90) : 0);
        tbRichTextView.getLayoutStrategy().q(i2);
        tbRichTextView.getLayoutStrategy().D = i2 - i(R.dimen.tbds122);
        tbRichTextView.getLayoutStrategy().p((int) (k * 1.618f));
    }

    public static void b(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65538, null, pbCommenFloorItemViewHolder, postData, z) == null) {
            if (!TextUtils.isEmpty(postData.u()) && z) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.m.getLayoutParams();
                layoutParams.topMargin = i(R.dimen.ds20);
                layoutParams.bottomMargin = i(R.dimen.ds20);
                pbCommenFloorItemViewHolder.m.setLayoutParams(layoutParams);
                pbCommenFloorItemViewHolder.m.h0(postData.u());
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.m.getLayoutParams();
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = 0;
                pbCommenFloorItemViewHolder.m.setLayoutParams(layoutParams2);
                pbCommenFloorItemViewHolder.m.setPadding(0, 0, 0, 0);
                pbCommenFloorItemViewHolder.m.h0(null);
            }
            pbCommenFloorItemViewHolder.m.setTextViewCheckSelection(false);
        }
    }

    public static void c(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, boolean z, boolean z2) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{pbCommenFloorItemViewHolder, postData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (imageView = pbCommenFloorItemViewHolder.t) == null || postData == null) {
            return;
        }
        if (z2) {
            imageView.setVisibility(8);
            if (z) {
                pbCommenFloorItemViewHolder.B.setText(TbadkCoreApplication.getInst().getString(R.string.reply));
                return;
            }
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public static void d(a aVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, b2 b2Var) {
        boolean z;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar, pbCommenFloorItemViewHolder, postData, b2Var) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        boolean z2 = true;
        if (postData.A() > 0 && b2Var != null && !b2Var.J1()) {
            String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.A()));
            pbCommenFloorItemViewHolder.D.setVisibility(0);
            pbCommenFloorItemViewHolder.D.setText(format);
            z = true;
        } else {
            pbCommenFloorItemViewHolder.D.setVisibility(8);
            z = false;
        }
        f I = postData.I();
        z2 = (I == null || StringUtils.isNull(I.b()) || b2Var == null || b2Var.J1()) ? false : false;
        if (z) {
            pbCommenFloorItemViewHolder.f19293h.setVisibility(0);
            i2 = f57532b;
        } else {
            pbCommenFloorItemViewHolder.f19293h.setVisibility(8);
            i2 = 0;
        }
        if (z2) {
            pbCommenFloorItemViewHolder.f19294i.setVisibility(0);
            i3 = f57532b;
        } else {
            pbCommenFloorItemViewHolder.f19294i.setVisibility(8);
            i3 = 0;
        }
        pbCommenFloorItemViewHolder.f19292g.setPadding(i2, 0, i3, 0);
        if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.R()), "yyyy"))) {
            pbCommenFloorItemViewHolder.f19292g.setText(StringHelper.getFormatTimeShort(postData.R()));
        } else {
            pbCommenFloorItemViewHolder.f19292g.setText(StringHelper.getFormatTime(postData.R()));
        }
        if (z2) {
            pbCommenFloorItemViewHolder.j.setVisibility(0);
            pbCommenFloorItemViewHolder.j.setPadding(f57532b, 0, 0, 0);
            pbCommenFloorItemViewHolder.j.setText(I.b());
            return;
        }
        pbCommenFloorItemViewHolder.j.setVisibility(8);
    }

    public static void e(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, b2 b2Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{pbCommenFloorItemViewHolder, postData, b2Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || pbCommenFloorItemViewHolder == null || postData == null || postData.q() == null) {
            return;
        }
        if (b2Var != null) {
            postData.q().threadId = b2Var.o1();
            postData.q().forumId = String.valueOf(b2Var.R());
        }
        if (i2 == 0) {
            postData.q().objType = 1;
        } else {
            postData.q().objType = 2;
        }
        postData.q().isInPost = true;
        if (z) {
            pbCommenFloorItemViewHolder.C.setAgreeAlone(true);
            pbCommenFloorItemViewHolder.C.setData(postData.q());
        }
        if (b2Var != null && b2Var.r2()) {
            pbCommenFloorItemViewHolder.k.setAgreeAlone(true);
        }
        pbCommenFloorItemViewHolder.k.setData(postData.q());
    }

    public static void f(a aVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.t tVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{aVar, pbCommenFloorItemViewHolder, postData, view, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), tVar}) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        Activity pageActivity = aVar.getPageContext().getPageActivity();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.m.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.rightMargin = l.g(pageActivity, R.dimen.M_W_X007);
        layoutParams.leftMargin = l.g(pageActivity, R.dimen.tbds148);
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        if (z) {
            pbCommenFloorItemViewHolder.m.h0(null);
            pbCommenFloorItemViewHolder.m.setBackgroundDrawable(null);
            pbCommenFloorItemViewHolder.m.getLayoutStrategy().g(R.drawable.transparent_bg);
        } else {
            pbCommenFloorItemViewHolder.m.getLayoutStrategy().g(R.drawable.icon_click);
        }
        pbCommenFloorItemViewHolder.m.getLayoutStrategy().x(R.drawable.pic_video);
        a(pbCommenFloorItemViewHolder.m, view, !StringUtils.isNull(postData.u()));
        pbCommenFloorItemViewHolder.m.setLayoutParams(layoutParams);
        pbCommenFloorItemViewHolder.m.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        pbCommenFloorItemViewHolder.m.setIsFromCDN(z2);
        pbCommenFloorItemViewHolder.m.setText(postData.K(), true, tVar);
        SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.m.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.tag_clip_board, postData);
        sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z3));
        pbCommenFloorItemViewHolder.m.setTag(sparseArray);
        pbCommenFloorItemViewHolder.f19287b.setTag(R.id.tag_from, sparseArray);
    }

    public static void g(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData != null && postData.O() != null) {
                TbRichText K = postData.K();
                d.a.q0.h2.p.f.c(postData.O(), pbCommenFloorItemViewHolder.K, false, false, K != null && StringUtils.isNull(K.toString()) && StringUtils.isNull(postData.u()));
                return;
            }
            pbCommenFloorItemViewHolder.K.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:161:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0489  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0492  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0497  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x04ec  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0549 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x059b  */
    /* JADX WARN: Removed duplicated region for block: B:204:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void h(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i2, a aVar, b2 b2Var, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{pbCommenFloorItemViewHolder, postData, view, Integer.valueOf(i2), aVar, b2Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (postData.t() != null) {
            postData.t().isBaijiahaoUser();
        }
        boolean z7 = false;
        if (postData.R) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.f19289d, R.color.CAM_X0204);
            pbCommenFloorItemViewHolder.f19289d.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.f19289d.setVisibility(8);
        }
        String userId = (b2Var == null || b2Var.H() == null) ? null : b2Var.H().getUserId();
        pbCommenFloorItemViewHolder.l.setTag(null);
        pbCommenFloorItemViewHolder.l.setUserId(null);
        pbCommenFloorItemViewHolder.f19290e.setText((CharSequence) null);
        pbCommenFloorItemViewHolder.F.getHeadView().setUserId(null);
        pbCommenFloorItemViewHolder.m.setIsHost(false);
        int i3 = 16;
        if (postData.t() != null) {
            if (userId != null && !userId.equals("0") && userId.equals(postData.t().getUserId())) {
                pbCommenFloorItemViewHolder.m.setIsHost(true);
            }
            ArrayList<IconData> iconInfo = postData.t().getIconInfo();
            ArrayList<IconData> tShowInfoNew = postData.t().getTShowInfoNew();
            UserIconBox userIconBox = pbCommenFloorItemViewHolder.H;
            if (userIconBox != null) {
                userIconBox.setTag(R.id.tag_user_id, postData.t().getUserId());
                pbCommenFloorItemViewHolder.H.setOnClickListener(aVar.getEventController().f57758c);
                int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                pbCommenFloorItemViewHolder.H.g(iconInfo, 2, g2, g2, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            }
            if (pbCommenFloorItemViewHolder.G != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbCommenFloorItemViewHolder.G.setTag(tShowInfoNew.get(0).getUrl());
                }
                pbCommenFloorItemViewHolder.G.setOnClickListener(aVar.getEventController().f57759d);
                int g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbCommenFloorItemViewHolder.G.h(tShowInfoNew, 3, g3, g3, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !postData.t().isBigV()) {
                if (d.J()) {
                    if (DeviceInfoUtil.isMate30()) {
                        r0.j(pbCommenFloorItemViewHolder.f19290e);
                    } else {
                        c.d(pbCommenFloorItemViewHolder.f19290e).y(R.string.F_X02);
                    }
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19290e, R.color.CAM_X0108, 1);
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19290e, R.color.CAM_X0106, 1);
                }
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19290e, R.color.CAM_X0301, 1);
            }
            String avater = postData.t().getAvater();
            pbCommenFloorItemViewHolder.f19290e.setTag(R.id.tag_user_id, postData.t().getUserId());
            pbCommenFloorItemViewHolder.f19290e.setTag(R.id.tag_user_name, postData.t().getUserName());
            pbCommenFloorItemViewHolder.f19290e.setTag(R.id.tag_virtual_user_url, postData.t().getVirtualUserUrl());
            String name_show = postData.t().getName_show();
            String userName = postData.t().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbCommenFloorItemViewHolder.f19290e.setText(d.a.q0.h2.c.b(aVar.getPageContext().getPageActivity(), pbCommenFloorItemViewHolder.f19290e.getText().toString()));
                pbCommenFloorItemViewHolder.f19290e.setGravity(16);
                pbCommenFloorItemViewHolder.f19290e.setTag(R.id.tag_nick_name_activity, d.a.q0.h2.c.a());
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19290e, R.color.CAM_X0312, 1);
            }
            if (postData.t().getPendantData() != null && !StringUtils.isNull(postData.t().getPendantData().getImgUrl())) {
                pbCommenFloorItemViewHolder.F.setBigVDimenSize(R.dimen.tbds32);
                pbCommenFloorItemViewHolder.F.i(postData.t(), 4);
                pbCommenFloorItemViewHolder.l.setVisibility(8);
                pbCommenFloorItemViewHolder.F.setVisibility(0);
                pbCommenFloorItemViewHolder.F.getHeadView().M(avater, 28, false);
                pbCommenFloorItemViewHolder.F.getHeadView().setUserId(postData.t().getUserId());
                pbCommenFloorItemViewHolder.F.getHeadView().setUserName(postData.t().getUserName());
                pbCommenFloorItemViewHolder.F.l(postData.t().getPendantData().getImgUrl());
            } else {
                pbCommenFloorItemViewHolder.l.setGodIconWidth(R.dimen.tbds32);
                UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.l, postData.t(), 4);
                pbCommenFloorItemViewHolder.l.setUserId(postData.t().getUserId());
                pbCommenFloorItemViewHolder.l.setUserName(postData.t().getUserName(), postData.T());
                pbCommenFloorItemViewHolder.l.setTag(R.id.tag_virtual_user_url, postData.t().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.l.setImageDrawable(null);
                pbCommenFloorItemViewHolder.l.M(avater, 28, false);
                pbCommenFloorItemViewHolder.l.setVisibility(0);
                pbCommenFloorItemViewHolder.F.setVisibility(8);
            }
            l(pbCommenFloorItemViewHolder.f19291f, postData, userId, b2Var);
        }
        int level_id = (!aVar.isSimpleForum() || postData.t() == null) ? 0 : postData.t().getLevel_id();
        if (b2Var != null && b2Var.r2()) {
            level_id = 0;
        }
        if (level_id > 0) {
            pbCommenFloorItemViewHolder.E.setVisibility(0);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.E, BitmapHelper.getGradeResourceIdInEnterForum(level_id));
        } else {
            pbCommenFloorItemViewHolder.E.setVisibility(8);
        }
        if (pbCommenFloorItemViewHolder.H.getChildCount() == 1) {
            i3 = 18;
        } else if (pbCommenFloorItemViewHolder.H.getChildCount() <= 1) {
            i3 = 20;
        }
        if (pbCommenFloorItemViewHolder.f19291f.getVisibility() == 0) {
            i3 -= 2;
        }
        if (pbCommenFloorItemViewHolder.G.getChildCount() > 0) {
            i3 -= 2;
        }
        String name_show2 = postData.t() != null ? postData.t().getName_show() : "";
        int d2 = j0.d(name_show2);
        if (postData.t() != null && !StringUtils.isNull(postData.t().getSealPrefix())) {
            int i4 = i3 - 2;
            if (d2 > i4) {
                name_show2 = j0.m(name_show2, i4) + StringHelper.STRING_MORE;
            }
        } else if (d2 > i3) {
            name_show2 = j0.m(name_show2, i3) + StringHelper.STRING_MORE;
        }
        if (postData.t() != null && !StringUtils.isNull(postData.t().getSealPrefix())) {
            pbCommenFloorItemViewHolder.f19290e.setText(j(aVar, postData.t().getSealPrefix(), name_show2));
        } else {
            pbCommenFloorItemViewHolder.f19290e.setText(name_show2);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_clip_board, postData);
        sparseArray.put(R.id.tag_load_sub_data, postData);
        sparseArray.put(R.id.tag_load_sub_view, view);
        sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.A()));
        sparseArray.put(R.id.tag_forbid_user_post_id, postData.E());
        boolean z8 = (postData.t() == null || StringUtils.isNull(postData.t().getVirtualUserUrl())) ? false : true;
        if (b2Var == null || aVar.getUserIdentify() == 0) {
            z3 = false;
            z4 = false;
        } else {
            z3 = (aVar.getUserIdentify() == 1002 || aVar.getUserIdentify() == 3) ? false : true;
            z4 = (aVar.getUserIdentify() == 3 || b2Var.J1()) ? false : true;
            if (postData != null && postData.t() != null) {
                String userId2 = postData.t().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z3 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z3 = false;
                }
            }
        }
        if (b2Var != null && b2Var.H() != null && postData.t() != null) {
            String userId3 = b2Var.H().getUserId();
            String userId4 = postData.t().getUserId();
            if (UtilHelper.isCurrentAccount(userId3)) {
                if (UtilHelper.isCurrentAccount(userId4)) {
                    z4 = true;
                    z5 = false;
                    z6 = true;
                    if (postData != null && postData.t() != null && UtilHelper.isCurrentAccount(postData.t().getUserId())) {
                        z4 = true;
                        z6 = true;
                    }
                    if (z8) {
                        z3 = false;
                        z4 = false;
                        z5 = false;
                    }
                    int i5 = postData.A() == 1 ? 0 : 1;
                    if (b2Var != null && b2Var.r2()) {
                        z3 = false;
                        z5 = false;
                    }
                    if (z3) {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.getUserIdentify()));
                        if (postData.t() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.t().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.t().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.t().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    }
                    if (z5) {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.t() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.t().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.t().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.t().getName_show());
                        }
                        sparseArray.put(R.id.tag_user_mute_thread_id, b2Var.d0());
                        sparseArray.put(R.id.tag_user_mute_post_id, postData.E());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (!z4 && b2Var != null) {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.getUserIdentify()));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                        sparseArray.put(R.id.tag_del_post_id, postData.E());
                        sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf((z2 || postData.W()) ? true : true));
                    } else {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    }
                    pbCommenFloorItemViewHolder.m.setTag(sparseArray);
                    if (z) {
                        pbCommenFloorItemViewHolder.I.setTag(sparseArray);
                        return;
                    }
                    return;
                }
                z4 = true;
                z5 = true;
                z6 = false;
                if (postData != null) {
                    z4 = true;
                    z6 = true;
                }
                if (z8) {
                }
                if (postData.A() == 1) {
                }
                if (b2Var != null) {
                    z3 = false;
                    z5 = false;
                }
                if (z3) {
                }
                if (z5) {
                }
                if (!z4) {
                }
                sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                pbCommenFloorItemViewHolder.m.setTag(sparseArray);
                if (z) {
                }
            }
        }
        z5 = false;
        z6 = false;
        if (postData != null) {
        }
        if (z8) {
        }
        if (postData.A() == 1) {
        }
        if (b2Var != null) {
        }
        if (z3) {
        }
        if (z5) {
        }
        if (!z4) {
        }
        sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
        pbCommenFloorItemViewHolder.m.setTag(sparseArray);
        if (z) {
        }
    }

    public static int i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) {
            int i3 = f57531a.get(i2, -1);
            if (i3 != -1) {
                return i3;
            }
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i2);
            f57531a.put(i2, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return invokeI.intValue;
    }

    public static SpannableStringBuilder j(a aVar, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, aVar, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return m.h(aVar.getPageContext().getPageActivity(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLLL.objValue;
    }

    public static void k(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65547, null, pbCommenFloorItemViewHolder, eVar, z) == null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        if (pbCommenFloorItemViewHolder.f19286a != TbadkCoreApplication.getInst().getSkinType()) {
            if (d.J()) {
                if (DeviceInfoUtil.isMate30()) {
                    r0.j(pbCommenFloorItemViewHolder.f19290e);
                } else {
                    c.d(pbCommenFloorItemViewHolder.f19290e).y(R.string.F_X02);
                }
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19290e, R.color.CAM_X0108, 1);
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19290e, R.color.CAM_X0106, 1);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19292g, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19293h, R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19294i, R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.D, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.j, R.color.CAM_X0109, 1);
            pbCommenFloorItemViewHolder.m.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            pbCommenFloorItemViewHolder.n.b();
            if (z) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(pbCommenFloorItemViewHolder.I, R.drawable.ic_icon_pure_close24, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.A, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.y, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.z, R.color.CAM_X0109);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.B, R.color.CAM_X0109);
            }
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.s, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.t, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            if (eVar != null) {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.q, R.color.CAM_X0108);
                pbCommenFloorItemViewHolder.q.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0108), null), (Drawable) null);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.r, R.color.CAM_X0108);
                SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.p;
                int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21);
                int i2 = R.color.CAM_X0206;
                SkinManager.setBackgroundShapeDrawable(subPbLayout, g2, i2, i2);
                pbCommenFloorItemViewHolder.p.d();
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.O, R.color.CAM_X0304, 1);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.M, R.color.CAM_X0106, 1);
                SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.L, R.color.CAM_X0205);
                SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.N, R.color.CAM_X0109);
                SkinManager.setImageResource(pbCommenFloorItemViewHolder.P, R.drawable.icon_arrow_more_gray);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.S, R.color.CAM_X0107);
                if (pbCommenFloorItemViewHolder.Q.getVisibility() == 8) {
                    pbCommenFloorItemViewHolder.q.setVisibility(8);
                    pbCommenFloorItemViewHolder.r.setVisibility(8);
                    pbCommenFloorItemViewHolder.S.setText(R.string.close_content);
                } else if (StringUtils.isNull(eVar.l())) {
                    pbCommenFloorItemViewHolder.S.setText(eVar.l());
                } else {
                    pbCommenFloorItemViewHolder.S.setText(R.string.expand_content);
                }
            } else {
                pbCommenFloorItemViewHolder.p.setVisibility(8);
                pbCommenFloorItemViewHolder.q.setVisibility(8);
                pbCommenFloorItemViewHolder.r.setVisibility(8);
                pbCommenFloorItemViewHolder.L.setVisibility(8);
                pbCommenFloorItemViewHolder.S.setVisibility(8);
            }
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.J, R.color.CAM_X0203);
        }
        pbCommenFloorItemViewHolder.f19286a = TbadkCoreApplication.getInst().getSkinType();
    }

    public static void l(TextView textView, PostData postData, String str, b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65548, null, textView, postData, str, b2Var) == null) {
            if (textView == null && postData == null) {
                return;
            }
            textView.setTag(postData);
            if (b2Var != null && b2Var.r2()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.t() != null) {
                MetaData t = postData.t();
                if (str != null && !str.equals("0") && str.equals(t.getUserId())) {
                    textView.setVisibility(0);
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    c d2 = c.d(textView);
                    d2.n(R.string.J_X04);
                    d2.l(R.dimen.L_X01);
                    d2.t(R.color.CAM_X0302);
                    d2.k(R.color.CAM_X0302);
                } else if (t.getIs_bawu() == 1 && postData.X()) {
                    c d3 = c.d(textView);
                    d3.t(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_official);
                } else if (t.getIs_bawu() == 1 && "manager".equals(t.getBawu_type())) {
                    c d4 = c.d(textView);
                    d4.t(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (t.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(t.getBawu_type())) {
                    c d5 = c.d(textView);
                    d5.t(R.color.CAM_X0101);
                    d5.n(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (t.getIs_bawu() == 1 && "pri_content_assist".equals(t.getBawu_type())) {
                    c d6 = c.d(textView);
                    d6.t(R.color.CAM_X0101);
                    d6.n(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (t.getIs_bawu() == 1 && "pri_manage_assist".equals(t.getBawu_type())) {
                    c d7 = c.d(textView);
                    d7.t(R.color.CAM_X0101);
                    d7.n(R.string.J_X04);
                    d7.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_manage_assist_tip);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
    }
}
