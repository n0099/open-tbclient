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
import com.repackage.ex5;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes6.dex */
public class pt7 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseIntArray a;
    public static final int b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
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
                ew7.a(measuredWidth, str, pbCommenFloorItemViewHolder.f, pbCommenFloorItemViewHolder.g, pbCommenFloorItemViewHolder.F, pbCommenFloorItemViewHolder.I, pbCommenFloorItemViewHolder.H);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755398306, "Lcom/repackage/pt7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755398306, "Lcom/repackage/pt7;");
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
        int k = (((oi.k(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
            k = (k - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
        }
        int i = k - (z ? i(R.dimen.tbds90) : 0);
        tbRichTextView.getLayoutStrategy().q(i);
        tbRichTextView.getLayoutStrategy().G = i - i(R.dimen.tbds122);
        tbRichTextView.getLayoutStrategy().p((int) (k * 1.618f));
    }

    public static void b(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65538, null, pbCommenFloorItemViewHolder, postData, z) == null) {
            if (!TextUtils.isEmpty(postData.u()) && z) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.n.getLayoutParams();
                layoutParams.topMargin = i(R.dimen.obfuscated_res_0x7f0701d5);
                layoutParams.bottomMargin = i(R.dimen.obfuscated_res_0x7f0701d5);
                pbCommenFloorItemViewHolder.n.setLayoutParams(layoutParams);
                pbCommenFloorItemViewHolder.n.k0(postData.u());
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
                pbCommenFloorItemViewHolder.C.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f8e));
                return;
            }
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public static void d(ot7 ot7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, ThreadData threadData) {
        boolean z;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ot7Var, pbCommenFloorItemViewHolder, postData, threadData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        boolean z2 = true;
        if (postData.A() > 0 && threadData != null && !threadData.isBjh()) {
            String format = String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0961), Integer.valueOf(postData.A()));
            pbCommenFloorItemViewHolder.E.setVisibility(0);
            pbCommenFloorItemViewHolder.E.setText(format);
            z = true;
        } else {
            pbCommenFloorItemViewHolder.E.setVisibility(8);
            z = false;
        }
        nz4 M = postData.M();
        z2 = (M == null || StringUtils.isNull(M.b()) || threadData == null || threadData.isBjh()) ? false : false;
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
        if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.X()), "yyyy"))) {
            pbCommenFloorItemViewHolder.h.setText(StringHelper.getFormatTimeShort(postData.X()));
        } else {
            pbCommenFloorItemViewHolder.h.setText(StringHelper.getFormatTime(postData.X()));
        }
        if (z2) {
            pbCommenFloorItemViewHolder.k.setVisibility(0);
            pbCommenFloorItemViewHolder.k.setPadding(b, 0, 0, 0);
            pbCommenFloorItemViewHolder.k.setText(M.b());
            return;
        }
        pbCommenFloorItemViewHolder.k.setVisibility(8);
    }

    public static void e(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, ThreadData threadData, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{pbCommenFloorItemViewHolder, postData, threadData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || pbCommenFloorItemViewHolder == null || postData == null || postData.q() == null) {
            return;
        }
        if (threadData != null) {
            postData.q().threadId = threadData.getTid();
            postData.q().forumId = String.valueOf(threadData.getFid());
        }
        if (i == 0) {
            postData.q().objType = 1;
        } else {
            postData.q().objType = 2;
        }
        postData.q().isInPost = true;
        if (z) {
            pbCommenFloorItemViewHolder.D.setAgreeAlone(true);
            pbCommenFloorItemViewHolder.D.setData(postData.q());
        }
        if (threadData != null && threadData.isUgcThreadType()) {
            pbCommenFloorItemViewHolder.l.setAgreeAlone(true);
        }
        pbCommenFloorItemViewHolder.l.setData(postData.q());
    }

    public static void f(ot7 ot7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, boolean z, boolean z2, boolean z3, TbRichTextView.s sVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{ot7Var, pbCommenFloorItemViewHolder, postData, view2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), sVar}) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        Activity pageActivity = ot7Var.getPageContext().getPageActivity();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.n.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.rightMargin = oi.f(pageActivity, R.dimen.M_W_X007);
        layoutParams.leftMargin = oi.f(pageActivity, R.dimen.tbds148);
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        if (z) {
            pbCommenFloorItemViewHolder.n.k0(null);
            pbCommenFloorItemViewHolder.n.setBackgroundDrawable(null);
            pbCommenFloorItemViewHolder.n.getLayoutStrategy().g(R.drawable.obfuscated_res_0x7f08120b);
        } else {
            pbCommenFloorItemViewHolder.n.getLayoutStrategy().g(R.drawable.icon_click);
        }
        pbCommenFloorItemViewHolder.n.getLayoutStrategy().x(R.drawable.pic_video);
        a(pbCommenFloorItemViewHolder.n, view2, !StringUtils.isNull(postData.u()));
        pbCommenFloorItemViewHolder.n.setLayoutParams(layoutParams);
        pbCommenFloorItemViewHolder.n.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        pbCommenFloorItemViewHolder.n.setIsFromCDN(z2);
        pbCommenFloorItemViewHolder.n.setText(postData.P(), true, sVar);
        SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.n.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.obfuscated_res_0x7f091e56, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f091e6f, Boolean.valueOf(z3));
        pbCommenFloorItemViewHolder.n.setTag(sparseArray);
        pbCommenFloorItemViewHolder.b.setTag(R.id.obfuscated_res_0x7f091e69, sparseArray);
    }

    public static void g(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData != null && postData.U() != null) {
                TbRichText P = postData.P();
                l08.c(postData.U(), pbCommenFloorItemViewHolder.L, false, false, P != null && StringUtils.isNull(P.toString()) && StringUtils.isNull(postData.u()));
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
    public static void h(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i, ot7 ot7Var, ThreadData threadData, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{pbCommenFloorItemViewHolder, postData, view2, Integer.valueOf(i), ot7Var, threadData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
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
                userIconBox.setTag(R.id.obfuscated_res_0x7f091ea4, postData.s().getUserId());
                pbCommenFloorItemViewHolder.I.setOnClickListener(ot7Var.getEventController().c);
                int f = oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                int f2 = oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                UserIconBox userIconBox2 = pbCommenFloorItemViewHolder.I;
                i2 = R.id.obfuscated_res_0x7f091ea4;
                userIconBox2.g(iconInfo, 2, f, f, f2);
            } else {
                i2 = R.id.obfuscated_res_0x7f091ea4;
            }
            if (pbCommenFloorItemViewHolder.H != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbCommenFloorItemViewHolder.H.setTag(tShowInfoNew.get(0).getUrl());
                }
                pbCommenFloorItemViewHolder.H.setOnClickListener(ot7Var.getEventController().d);
                int f3 = oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbCommenFloorItemViewHolder.H.h(tShowInfoNew, 3, f3, f3, oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !postData.s().isBigV()) {
                if (UbsABTestHelper.isPBPlanA()) {
                    if (DeviceInfoUtil.isMate30()) {
                        ew7.k(pbCommenFloorItemViewHolder.f);
                    } else {
                        vr4.d(pbCommenFloorItemViewHolder.f).A(R.string.F_X02);
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
            pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f091eac, postData.s().getUserName());
            pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f091eae, postData.s().getVirtualUserUrl());
            String name_show = postData.s().getName_show();
            String userName = postData.s().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbCommenFloorItemViewHolder.f.setText(dr7.b(ot7Var.getPageContext().getPageActivity(), pbCommenFloorItemViewHolder.f.getText().toString()));
                pbCommenFloorItemViewHolder.f.setGravity(16);
                pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f091e7d, dr7.a());
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0312, 1);
            }
            if (postData.s().getPendantData() != null && !StringUtils.isNull(postData.s().getPendantData().getImgUrl())) {
                pbCommenFloorItemViewHolder.G.setBigVDimenSize(R.dimen.tbds36);
                pbCommenFloorItemViewHolder.G.j(postData.s(), 4);
                pbCommenFloorItemViewHolder.m.setVisibility(8);
                pbCommenFloorItemViewHolder.G.setVisibility(0);
                pbCommenFloorItemViewHolder.G.getHeadView().K(avater, 28, false);
                pbCommenFloorItemViewHolder.G.getHeadView().setUserId(postData.s().getUserId());
                pbCommenFloorItemViewHolder.G.getHeadView().setUserName(postData.s().getUserName());
                pbCommenFloorItemViewHolder.G.m(postData.s().getPendantData().getImgUrl());
            } else {
                pbCommenFloorItemViewHolder.m.setGodIconWidth(R.dimen.tbds36);
                UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.m, postData.s(), 4);
                pbCommenFloorItemViewHolder.m.setUserId(postData.s().getUserId());
                pbCommenFloorItemViewHolder.m.setUserName(postData.s().getUserName(), postData.Z());
                pbCommenFloorItemViewHolder.m.setTag(R.id.obfuscated_res_0x7f091eae, postData.s().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.m.setImageDrawable(null);
                pbCommenFloorItemViewHolder.m.K(avater, 28, false);
                pbCommenFloorItemViewHolder.m.setVisibility(0);
                pbCommenFloorItemViewHolder.G.setVisibility(8);
            }
            m(pbCommenFloorItemViewHolder.g, postData, userId, threadData);
        }
        int level_id = (!ot7Var.isSimpleForum() || postData.s() == null) ? 0 : postData.s().getLevel_id();
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
        int e = ew7.e();
        String name_show2 = postData.s() != null ? postData.s().getName_show() : "";
        int d = fd5.d(name_show2);
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            int i3 = e - 2;
            if (d > i3) {
                name_show2 = fd5.n(name_show2, i3) + StringHelper.STRING_MORE;
            }
        } else if (d > e) {
            name_show2 = fd5.n(name_show2, e) + StringHelper.STRING_MORE;
        }
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            pbCommenFloorItemViewHolder.f.setText(j(ot7Var, postData.s().getSealPrefix(), name_show2));
        } else {
            pbCommenFloorItemViewHolder.f.setText(name_show2);
            pbCommenFloorItemViewHolder.e.post(new a(pbCommenFloorItemViewHolder, name_show2));
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.obfuscated_res_0x7f091e56, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f091e72, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f091e74, view2);
        sparseArray.put(R.id.obfuscated_res_0x7f091e80, Integer.valueOf(i));
        sparseArray.put(R.id.obfuscated_res_0x7f091e7f, Integer.valueOf(postData.A()));
        sparseArray.put(R.id.obfuscated_res_0x7f091e66, postData.I());
        boolean z9 = (postData.s() == null || StringUtils.isNull(postData.s().getVirtualUserUrl())) ? false : true;
        if (threadData == null || ot7Var.getUserIdentify() == 0 || k(threadData)) {
            z3 = false;
            z4 = false;
        } else {
            z3 = (ot7Var.getUserIdentify() == 1002 || ot7Var.getUserIdentify() == 3) ? false : true;
            z4 = (ot7Var.getUserIdentify() == 3 || threadData.isBjh()) ? false : true;
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
                int i4 = postData.A() != 1 ? 0 : 1;
                if (threadData != null && threadData.isUgcThreadType()) {
                    z3 = false;
                    z5 = false;
                }
                if (!z3) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091e98, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091e75, Integer.valueOf(ot7Var.getUserIdentify()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091e63, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f091e64, postData.s().getName_show());
                        sparseArray.put(R.id.obfuscated_res_0x7f091e65, postData.s().getPortrait());
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091e98, Boolean.FALSE);
                }
                if (!z5) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091eab, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091e6d, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091ea7, postData.s().getUserId());
                        sparseArray.put(R.id.obfuscated_res_0x7f091ea8, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f091ea6, postData.s().getName_show());
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f091eaa, threadData.getId());
                    sparseArray.put(R.id.obfuscated_res_0x7f091ea9, postData.I());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091eab, Boolean.FALSE);
                }
                if (!z4 && threadData != null) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091e96, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091e75, Integer.valueOf(ot7Var.getUserIdentify()));
                    sparseArray.put(R.id.obfuscated_res_0x7f091e59, Boolean.valueOf(z6));
                    sparseArray.put(R.id.obfuscated_res_0x7f091e5a, Integer.valueOf(i4));
                    sparseArray.put(R.id.obfuscated_res_0x7f091e58, postData.I());
                    sparseArray.put(R.id.obfuscated_res_0x7f091e6a, Boolean.valueOf((z2 || postData.d0()) ? true : true));
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091e96, Boolean.FALSE);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f091e6e, Boolean.valueOf(z7));
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
        if (postData.A() != 1) {
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
        sparseArray.put(R.id.obfuscated_res_0x7f091e96, Boolean.FALSE);
        sparseArray.put(R.id.obfuscated_res_0x7f091e6e, Boolean.valueOf(z7));
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

    public static SpannableStringBuilder j(ot7 ot7Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, ot7Var, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new ex5.a(str, R.drawable.pic_smalldot_title));
            return ex5.h(ot7Var.getPageContext().getPageActivity(), str2, arrayList, true);
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

    public static void l(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bs7 bs7Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65548, null, pbCommenFloorItemViewHolder, bs7Var, z) == null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        if (pbCommenFloorItemViewHolder.a != TbadkCoreApplication.getInst().getSkinType()) {
            if (UbsABTestHelper.isPBPlanA()) {
                if (DeviceInfoUtil.isMate30()) {
                    ew7.k(pbCommenFloorItemViewHolder.f);
                } else {
                    vr4.d(pbCommenFloorItemViewHolder.f).A(R.string.F_X02);
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
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(pbCommenFloorItemViewHolder.J, R.drawable.obfuscated_res_0x7f0805fc, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.B, R.drawable.obfuscated_res_0x7f080956, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.z, R.drawable.obfuscated_res_0x7f080957, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.A, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.C, (int) R.color.CAM_X0109);
            }
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.t, R.drawable.obfuscated_res_0x7f080956, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.u, R.drawable.obfuscated_res_0x7f080957, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            if (bs7Var != null) {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.r, (int) R.color.CAM_X0108);
                pbCommenFloorItemViewHolder.r.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0108), null), (Drawable) null);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.s, (int) R.color.CAM_X0108);
                SkinManager.setBackgroundShapeDrawable(pbCommenFloorItemViewHolder.q, oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
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
                } else if (StringUtils.isNull(bs7Var.k())) {
                    pbCommenFloorItemViewHolder.T.setText(bs7Var.k());
                } else {
                    pbCommenFloorItemViewHolder.T.setText(R.string.obfuscated_res_0x7f0f05c3);
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
                    textView.setText(R.string.obfuscated_res_0x7f0f0856);
                    textView.setBackgroundColor(0);
                    vr4 d = vr4.d(textView);
                    d.n(R.string.J_X04);
                    d.l(R.dimen.L_X01);
                    d.v(R.color.CAM_X0302);
                    d.k(R.color.CAM_X0302);
                } else if (s.getIs_bawu() == 1 && postData.e0()) {
                    vr4 d2 = vr4.d(textView);
                    d2.v(R.color.CAM_X0101);
                    d2.n(R.string.J_X04);
                    d2.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f0332);
                } else if (s.getIs_bawu() == 1 && "manager".equals(s.getBawu_type())) {
                    vr4 d3 = vr4.d(textView);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02eb);
                } else if (s.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(s.getBawu_type())) {
                    vr4 d4 = vr4.d(textView);
                    d4.v(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02ec);
                } else if (s.getIs_bawu() == 1 && "pri_content_assist".equals(s.getBawu_type())) {
                    vr4 d5 = vr4.d(textView);
                    d5.v(R.color.CAM_X0101);
                    d5.n(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02e8);
                } else if (s.getIs_bawu() == 1 && "pri_manage_assist".equals(s.getBawu_type())) {
                    vr4 d6 = vr4.d(textView);
                    d6.v(R.color.CAM_X0101);
                    d6.n(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02e9);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
    }
}
