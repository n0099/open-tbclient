package com.repackage;

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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
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
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ux5;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes7.dex */
public class xs7 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseIntArray a;
    public static final int b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ String b;

        public a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbCommenFloorItemViewHolder, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbCommenFloorItemViewHolder;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredWidth = this.a.e.getMeasuredWidth();
                String str = this.b;
                PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = this.a;
                lv7.a(measuredWidth, str, pbCommenFloorItemViewHolder.f, pbCommenFloorItemViewHolder.g, pbCommenFloorItemViewHolder.F, pbCommenFloorItemViewHolder.I, pbCommenFloorItemViewHolder.H);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755160939, "Lcom/repackage/xs7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755160939, "Lcom/repackage/xs7;");
                return;
            }
        }
        new SparseArray();
        a = new SparseIntArray();
        b = i(R.dimen.tbds16);
    }

    public static void a(TbRichTextView tbRichTextView, View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65537, null, tbRichTextView, view2, z) == null) || tbRichTextView == null || view2 == null) {
            return;
        }
        int k = (((pi.k(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
            k = (k - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
        }
        int i = k - (z ? i(R.dimen.tbds90) : 0);
        tbRichTextView.getLayoutStrategy().q(i);
        tbRichTextView.getLayoutStrategy().H = i - i(R.dimen.tbds122);
        tbRichTextView.getLayoutStrategy().p((int) (k * 1.618f));
    }

    public static void b(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65538, null, pbCommenFloorItemViewHolder, postData, z) == null) {
            if (!TextUtils.isEmpty(postData.t()) && z) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.n.getLayoutParams();
                layoutParams.topMargin = i(R.dimen.obfuscated_res_0x7f0701d5);
                layoutParams.bottomMargin = i(R.dimen.obfuscated_res_0x7f0701d5);
                pbCommenFloorItemViewHolder.n.setLayoutParams(layoutParams);
                pbCommenFloorItemViewHolder.n.k0(postData.t());
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.n.getLayoutParams();
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = 0;
                pbCommenFloorItemViewHolder.n.setLayoutParams(layoutParams2);
                pbCommenFloorItemViewHolder.n.setPadding(0, 0, 0, 0);
                pbCommenFloorItemViewHolder.n.k0(null);
            }
            pbCommenFloorItemViewHolder.n.setTextViewCheckSelection(false);
        }
    }

    public static void c(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, boolean z, boolean z2) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{pbCommenFloorItemViewHolder, postData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (imageView = pbCommenFloorItemViewHolder.u) == null || postData == null) {
            return;
        }
        if (z2) {
            imageView.setVisibility(8);
            if (z) {
                pbCommenFloorItemViewHolder.C.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fbd));
                return;
            }
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public static void d(ws7 ws7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, ThreadData threadData) {
        boolean z;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ws7Var, pbCommenFloorItemViewHolder, postData, threadData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        boolean z2 = true;
        if (postData.B() > 0 && threadData != null && !threadData.isBjh()) {
            String format = String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f097b), Integer.valueOf(postData.B()));
            pbCommenFloorItemViewHolder.E.setVisibility(0);
            pbCommenFloorItemViewHolder.E.setText(format);
            z = true;
        } else {
            pbCommenFloorItemViewHolder.E.setVisibility(8);
            z = false;
        }
        n05 N = postData.N();
        z2 = (N == null || StringUtils.isNull(N.b()) || threadData == null || threadData.isBjh()) ? false : false;
        if (z) {
            pbCommenFloorItemViewHolder.i.setVisibility(0);
            i = b;
        } else {
            pbCommenFloorItemViewHolder.i.setVisibility(8);
            i = 0;
        }
        if (z2) {
            pbCommenFloorItemViewHolder.j.setVisibility(0);
            i2 = b;
        } else {
            pbCommenFloorItemViewHolder.j.setVisibility(8);
            i2 = 0;
        }
        pbCommenFloorItemViewHolder.h.setPadding(i, 0, i2, 0);
        if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.Y()), "yyyy"))) {
            pbCommenFloorItemViewHolder.h.setText(StringHelper.getFormatTimeShort(postData.Y()));
        } else {
            pbCommenFloorItemViewHolder.h.setText(StringHelper.getFormatTime(postData.Y()));
        }
        if (z2) {
            pbCommenFloorItemViewHolder.k.setVisibility(0);
            pbCommenFloorItemViewHolder.k.setPadding(b, 0, 0, 0);
            pbCommenFloorItemViewHolder.k.setText(N.b());
            return;
        }
        pbCommenFloorItemViewHolder.k.setVisibility(8);
    }

    public static void e(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, ThreadData threadData, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{pbCommenFloorItemViewHolder, postData, threadData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || pbCommenFloorItemViewHolder == null || postData == null || postData.p() == null) {
            return;
        }
        if (threadData != null) {
            postData.p().threadId = threadData.getTid();
            postData.p().forumId = String.valueOf(threadData.getFid());
        }
        if (i == 0) {
            postData.p().objType = 1;
        } else {
            postData.p().objType = 2;
        }
        postData.p().isInPost = true;
        if (z) {
            pbCommenFloorItemViewHolder.D.setAgreeAlone(true);
            pbCommenFloorItemViewHolder.D.setData(postData.p());
        }
        if (threadData != null && threadData.isUgcThreadType()) {
            pbCommenFloorItemViewHolder.l.setAgreeAlone(true);
        }
        pbCommenFloorItemViewHolder.l.setData(postData.p());
    }

    public static void f(ws7 ws7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, boolean z, boolean z2, boolean z3, TbRichTextView.s sVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{ws7Var, pbCommenFloorItemViewHolder, postData, view2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), sVar}) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        Activity pageActivity = ws7Var.getPageContext().getPageActivity();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.n.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.rightMargin = pi.f(pageActivity, R.dimen.M_W_X007);
        layoutParams.leftMargin = pi.f(pageActivity, R.dimen.tbds148);
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        if (z) {
            pbCommenFloorItemViewHolder.n.k0(null);
            pbCommenFloorItemViewHolder.n.setBackgroundDrawable(null);
            pbCommenFloorItemViewHolder.n.getLayoutStrategy().g(R.drawable.obfuscated_res_0x7f0811a4);
        } else {
            pbCommenFloorItemViewHolder.n.getLayoutStrategy().g(R.drawable.icon_click);
        }
        pbCommenFloorItemViewHolder.n.getLayoutStrategy().x(R.drawable.pic_video);
        a(pbCommenFloorItemViewHolder.n, view2, !StringUtils.isNull(postData.t()));
        pbCommenFloorItemViewHolder.n.setLayoutParams(layoutParams);
        pbCommenFloorItemViewHolder.n.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        pbCommenFloorItemViewHolder.n.setIsFromCDN(z2);
        pbCommenFloorItemViewHolder.n.setText(postData.Q(), true, sVar);
        SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.n.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.obfuscated_res_0x7f091eed, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f091f06, Boolean.valueOf(z3));
        pbCommenFloorItemViewHolder.n.setTag(sparseArray);
        pbCommenFloorItemViewHolder.b.setTag(R.id.obfuscated_res_0x7f091f00, sparseArray);
    }

    public static void g(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData != null && postData.V() != null) {
                TbRichText Q = postData.Q();
                sz7.c(postData.V(), pbCommenFloorItemViewHolder.L, false, false, Q != null && StringUtils.isNull(Q.toString()) && StringUtils.isNull(postData.t()));
                return;
            }
            pbCommenFloorItemViewHolder.L.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:161:0x04a7  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x04b0  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x04b2  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x04c5  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0506  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0510  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0568  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x05cc  */
    /* JADX WARN: Removed duplicated region for block: B:201:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void h(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i, ws7 ws7Var, ThreadData threadData, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{pbCommenFloorItemViewHolder, postData, view2, Integer.valueOf(i), ws7Var, threadData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (postData.s() != null) {
            postData.s().isBaijiahaoUser();
        }
        boolean z8 = false;
        if (postData.P) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.d, R.color.CAM_X0204);
            pbCommenFloorItemViewHolder.d.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.d.setVisibility(8);
        }
        String userId = (threadData == null || threadData.getAuthor() == null) ? null : threadData.getAuthor().getUserId();
        pbCommenFloorItemViewHolder.m.setTag(null);
        pbCommenFloorItemViewHolder.m.setUserId(null);
        pbCommenFloorItemViewHolder.f.setText((CharSequence) null);
        pbCommenFloorItemViewHolder.G.getHeadView().setUserId(null);
        pbCommenFloorItemViewHolder.n.setIsHost(false);
        if (postData.s() != null) {
            if (userId != null && !userId.equals("0") && userId.equals(postData.s().getUserId())) {
                pbCommenFloorItemViewHolder.n.setIsHost(true);
            }
            ArrayList<IconData> iconInfo = postData.s().getIconInfo();
            ArrayList<IconData> tShowInfoNew = postData.s().getTShowInfoNew();
            UserIconBox userIconBox = pbCommenFloorItemViewHolder.I;
            if (userIconBox != null) {
                userIconBox.setTag(R.id.obfuscated_res_0x7f091f3d, postData.s().getUserId());
                pbCommenFloorItemViewHolder.I.setOnClickListener(ws7Var.A0().c);
                int f = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                int f2 = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                UserIconBox userIconBox2 = pbCommenFloorItemViewHolder.I;
                i2 = R.id.obfuscated_res_0x7f091f3d;
                userIconBox2.g(iconInfo, 2, f, f, f2);
            } else {
                i2 = R.id.obfuscated_res_0x7f091f3d;
            }
            if (pbCommenFloorItemViewHolder.H != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbCommenFloorItemViewHolder.H.setTag(tShowInfoNew.get(0).getUrl());
                }
                pbCommenFloorItemViewHolder.H.setOnClickListener(ws7Var.A0().e);
                int f3 = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbCommenFloorItemViewHolder.H.h(tShowInfoNew, 3, f3, f3, pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !postData.s().isBigV()) {
                if (UbsABTestHelper.isPBPlanA()) {
                    if (DeviceInfoUtil.isMate30()) {
                        lv7.l(pbCommenFloorItemViewHolder.f);
                    } else {
                        ur4.d(pbCommenFloorItemViewHolder.f).A(R.string.F_X02);
                    }
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0108, 1);
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0106, 1);
                }
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0301, 1);
            }
            String avater = postData.s().getAvater();
            pbCommenFloorItemViewHolder.f.setTag(i2, postData.s().getUserId());
            pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f091f45, postData.s().getUserName());
            pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f091f47, postData.s().getVirtualUserUrl());
            String name_show = postData.s().getName_show();
            String userName = postData.s().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbCommenFloorItemViewHolder.f.setText(lq7.b(ws7Var.getPageContext().getPageActivity(), pbCommenFloorItemViewHolder.f.getText().toString()));
                pbCommenFloorItemViewHolder.f.setGravity(16);
                pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f091f14, lq7.a());
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0312, 1);
            }
            if (postData.s().getPendantData() != null && !StringUtils.isNull(postData.s().getPendantData().getImgUrl())) {
                pbCommenFloorItemViewHolder.G.setBigVDimenSize(R.dimen.tbds36);
                pbCommenFloorItemViewHolder.G.j(postData.s(), 4);
                pbCommenFloorItemViewHolder.m.setVisibility(8);
                pbCommenFloorItemViewHolder.G.setVisibility(0);
                pbCommenFloorItemViewHolder.G.getHeadView().J(avater, 28, false);
                pbCommenFloorItemViewHolder.G.getHeadView().setUserId(postData.s().getUserId());
                pbCommenFloorItemViewHolder.G.getHeadView().setUserName(postData.s().getUserName());
                pbCommenFloorItemViewHolder.G.m(postData.s().getPendantData().getImgUrl());
            } else {
                pbCommenFloorItemViewHolder.m.setGodIconWidth(R.dimen.tbds36);
                UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.m, postData.s(), 4);
                pbCommenFloorItemViewHolder.m.setUserId(postData.s().getUserId());
                pbCommenFloorItemViewHolder.m.setUserName(postData.s().getUserName(), postData.a0());
                pbCommenFloorItemViewHolder.m.setTag(R.id.obfuscated_res_0x7f091f47, postData.s().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.m.setImageDrawable(null);
                pbCommenFloorItemViewHolder.m.J(avater, 28, false);
                pbCommenFloorItemViewHolder.m.setVisibility(0);
                pbCommenFloorItemViewHolder.G.setVisibility(8);
            }
            m(pbCommenFloorItemViewHolder.g, postData, userId, threadData);
        }
        int level_id = (!ws7Var.v0() || postData.s() == null) ? 0 : postData.s().getLevel_id();
        if (threadData != null && threadData.isUgcThreadType()) {
            level_id = 0;
        }
        if (level_id > 0) {
            pbCommenFloorItemViewHolder.F.setVisibility(0);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.F, BitmapHelper.getGradeResourceIdInEnterForum(level_id));
        } else {
            pbCommenFloorItemViewHolder.F.setVisibility(8);
        }
        if (pbCommenFloorItemViewHolder.I.getChildCount() != 1) {
            pbCommenFloorItemViewHolder.I.getChildCount();
        }
        pbCommenFloorItemViewHolder.g.getVisibility();
        pbCommenFloorItemViewHolder.H.getChildCount();
        int e = lv7.e();
        String name_show2 = postData.s() != null ? postData.s().getName_show() : "";
        int d = je5.d(name_show2);
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            int i3 = e - 2;
            if (d > i3) {
                name_show2 = je5.n(name_show2, i3) + StringHelper.STRING_MORE;
            }
        } else if (d > e) {
            name_show2 = je5.n(name_show2, e) + StringHelper.STRING_MORE;
        }
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            pbCommenFloorItemViewHolder.f.setText(j(ws7Var, postData.s().getSealPrefix(), name_show2));
        } else {
            pbCommenFloorItemViewHolder.f.setText(name_show2);
            pbCommenFloorItemViewHolder.e.post(new a(pbCommenFloorItemViewHolder, name_show2));
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.obfuscated_res_0x7f091eed, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f091f09, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f091f0b, view2);
        sparseArray.put(R.id.obfuscated_res_0x7f091f17, Integer.valueOf(i));
        sparseArray.put(R.id.obfuscated_res_0x7f091f16, Integer.valueOf(postData.B()));
        sparseArray.put(R.id.obfuscated_res_0x7f091efd, postData.J());
        boolean z9 = (postData.s() == null || StringUtils.isNull(postData.s().getVirtualUserUrl())) ? false : true;
        if (threadData == null || ws7Var.T() == 0 || k(threadData)) {
            z3 = false;
            z4 = false;
        } else {
            z3 = (ws7Var.T() == 1002 || ws7Var.T() == 3) ? false : true;
            z4 = (ws7Var.T() == 3 || threadData.isBjh()) ? false : true;
            if (postData != null && postData.s() != null) {
                String userId2 = postData.s().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z3 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z3 = false;
                }
            }
        }
        if (threadData != null && threadData.getAuthor() != null && postData.s() != null) {
            String userId3 = threadData.getAuthor().getUserId();
            String userId4 = postData.s().getUserId();
            if (UtilHelper.isCurrentAccount(userId3)) {
                if (UtilHelper.isCurrentAccount(userId4)) {
                    z5 = false;
                    z4 = true;
                    z6 = true;
                } else {
                    z5 = true;
                    z4 = true;
                    z6 = false;
                }
                z7 = true;
                if (postData != null && postData.s() != null && UtilHelper.isCurrentAccount(postData.s().getUserId())) {
                    z4 = true;
                    z6 = true;
                }
                if (z9) {
                    z3 = false;
                    z5 = false;
                    z4 = false;
                }
                int i4 = postData.B() != 1 ? 0 : 1;
                if (threadData != null && threadData.isUgcThreadType()) {
                    z3 = false;
                    z5 = false;
                }
                if (!z3) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091f30, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091f0c, Integer.valueOf(ws7Var.T()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091efa, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f091efb, postData.s().getName_show());
                        sparseArray.put(R.id.obfuscated_res_0x7f091efc, postData.s().getPortrait());
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091f30, Boolean.FALSE);
                }
                if (!z5) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091f44, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091f04, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091f40, postData.s().getUserId());
                        sparseArray.put(R.id.obfuscated_res_0x7f091f41, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f091f3f, postData.s().getName_show());
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f091f43, threadData.getId());
                    sparseArray.put(R.id.obfuscated_res_0x7f091f42, postData.J());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091f44, Boolean.FALSE);
                }
                if (!z4 && threadData != null) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091f2e, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091f0c, Integer.valueOf(ws7Var.T()));
                    sparseArray.put(R.id.obfuscated_res_0x7f091ef0, Boolean.valueOf(z6));
                    sparseArray.put(R.id.obfuscated_res_0x7f091ef1, Integer.valueOf(i4));
                    sparseArray.put(R.id.obfuscated_res_0x7f091eef, postData.J());
                    sparseArray.put(R.id.obfuscated_res_0x7f091f01, Boolean.valueOf((z2 || postData.g0()) ? true : true));
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091f2e, Boolean.FALSE);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f091f05, Boolean.valueOf(z7));
                pbCommenFloorItemViewHolder.n.setTag(sparseArray);
                if (z) {
                    return;
                }
                pbCommenFloorItemViewHolder.J.setTag(sparseArray);
                return;
            }
        }
        z5 = false;
        z6 = false;
        z7 = false;
        if (postData != null) {
            z4 = true;
            z6 = true;
        }
        if (z9) {
        }
        if (postData.B() != 1) {
        }
        if (threadData != null) {
            z3 = false;
            z5 = false;
        }
        if (!z3) {
        }
        if (!z5) {
        }
        if (!z4) {
        }
        sparseArray.put(R.id.obfuscated_res_0x7f091f2e, Boolean.FALSE);
        sparseArray.put(R.id.obfuscated_res_0x7f091f05, Boolean.valueOf(z7));
        pbCommenFloorItemViewHolder.n.setTag(sparseArray);
        if (z) {
        }
    }

    public static int i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i)) == null) {
            int i2 = a.get(i, -1);
            if (i2 != -1) {
                return i2;
            }
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            a.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return invokeI.intValue;
    }

    public static SpannableStringBuilder j(ws7 ws7Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, ws7Var, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new ux5.a(str, R.drawable.pic_smalldot_title));
            return ux5.h(ws7Var.getPageContext().getPageActivity(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLLL.objValue;
    }

    public static boolean k(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, threadData)) == null) {
            if (threadData == null) {
                return false;
            }
            return threadData.isBlocked();
        }
        return invokeL.booleanValue;
    }

    public static void l(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, jr7 jr7Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65548, null, pbCommenFloorItemViewHolder, jr7Var, z) == null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        if (pbCommenFloorItemViewHolder.a != TbadkCoreApplication.getInst().getSkinType()) {
            if (UbsABTestHelper.isPBPlanA()) {
                if (DeviceInfoUtil.isMate30()) {
                    lv7.l(pbCommenFloorItemViewHolder.f);
                } else {
                    ur4.d(pbCommenFloorItemViewHolder.f).A(R.string.F_X02);
                }
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0108, 1);
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0106, 1);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.h, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.i, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.j, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.E, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.k, R.color.CAM_X0109, 1);
            pbCommenFloorItemViewHolder.n.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            pbCommenFloorItemViewHolder.o.b();
            if (z) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(pbCommenFloorItemViewHolder.J, R.drawable.obfuscated_res_0x7f0805e8, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.B, R.drawable.obfuscated_res_0x7f08096a, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.z, R.drawable.obfuscated_res_0x7f08096b, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.A, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.C, (int) R.color.CAM_X0109);
            }
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.t, R.drawable.obfuscated_res_0x7f08096a, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.u, R.drawable.obfuscated_res_0x7f08096b, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            if (jr7Var != null) {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.r, (int) R.color.CAM_X0108);
                pbCommenFloorItemViewHolder.r.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0108), null), (Drawable) null);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.s, (int) R.color.CAM_X0108);
                SkinManager.setBackgroundShapeDrawable(pbCommenFloorItemViewHolder.q, pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
                pbCommenFloorItemViewHolder.q.d();
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.P, R.color.CAM_X0304, 1);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.N, R.color.CAM_X0106, 1);
                SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.M, R.color.CAM_X0205);
                SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.O, R.color.CAM_X0109);
                SkinManager.setImageResource(pbCommenFloorItemViewHolder.Q, R.drawable.icon_arrow_more_gray);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.T, (int) R.color.CAM_X0107);
                if (pbCommenFloorItemViewHolder.R.getVisibility() == 8) {
                    pbCommenFloorItemViewHolder.r.setVisibility(8);
                    pbCommenFloorItemViewHolder.s.setVisibility(8);
                    pbCommenFloorItemViewHolder.T.setText(R.string.obfuscated_res_0x7f0f03eb);
                } else if (StringUtils.isNull(jr7Var.k())) {
                    pbCommenFloorItemViewHolder.T.setText(jr7Var.k());
                } else {
                    pbCommenFloorItemViewHolder.T.setText(R.string.obfuscated_res_0x7f0f05ce);
                }
            } else {
                pbCommenFloorItemViewHolder.q.setVisibility(8);
                pbCommenFloorItemViewHolder.r.setVisibility(8);
                pbCommenFloorItemViewHolder.s.setVisibility(8);
                pbCommenFloorItemViewHolder.M.setVisibility(8);
                pbCommenFloorItemViewHolder.T.setVisibility(8);
            }
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.K, R.color.CAM_X0203);
        }
        pbCommenFloorItemViewHolder.a = TbadkCoreApplication.getInst().getSkinType();
    }

    public static void m(TextView textView, PostData postData, String str, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65549, null, textView, postData, str, threadData) == null) {
            if (textView == null && postData == null) {
                return;
            }
            textView.setTag(postData);
            if (threadData != null && threadData.isUgcThreadType()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.s() != null) {
                MetaData s = postData.s();
                if (str != null && !str.equals("0") && str.equals(s.getUserId())) {
                    textView.setVisibility(0);
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.obfuscated_res_0x7f0f086c);
                    textView.setBackgroundColor(0);
                    ur4 d = ur4.d(textView);
                    d.n(R.string.J_X04);
                    d.l(R.dimen.L_X01);
                    d.v(R.color.CAM_X0302);
                    d.k(R.color.CAM_X0302);
                } else if (s.getIs_bawu() == 1 && postData.h0()) {
                    ur4 d2 = ur4.d(textView);
                    d2.v(R.color.CAM_X0101);
                    d2.n(R.string.J_X04);
                    d2.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f033b);
                } else if (s.getIs_bawu() == 1 && "manager".equals(s.getBawu_type())) {
                    ur4 d3 = ur4.d(textView);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02f6);
                } else if (s.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(s.getBawu_type())) {
                    ur4 d4 = ur4.d(textView);
                    d4.v(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02f7);
                } else if (s.getIs_bawu() == 1 && "pri_content_assist".equals(s.getBawu_type())) {
                    ur4 d5 = ur4.d(textView);
                    d5.v(R.color.CAM_X0101);
                    d5.n(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02f3);
                } else if (s.getIs_bawu() == 1 && "pri_manage_assist".equals(s.getBawu_type())) {
                    ur4 d6 = ur4.d(textView);
                    d6.v(R.color.CAM_X0101);
                    d6.n(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02f4);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
    }
}
