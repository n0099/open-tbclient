package com.repackage;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.data.UserData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.nh4;
/* loaded from: classes6.dex */
public class hi4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hi4 b;
    public transient /* synthetic */ FieldHolder $fh;
    public ph4 a;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserData a;
        public final /* synthetic */ TbPageContext b;
        public final /* synthetic */ hi4 c;

        public a(hi4 hi4Var, UserData userData, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hi4Var, userData, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = hi4Var;
            this.a = userData;
            this.b = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.c.a != null) {
                    this.c.a.a();
                }
                if (TextUtils.isEmpty(this.a.getName_show()) || TextUtils.isEmpty(this.a.getUserId())) {
                    return;
                }
                String name_show = this.a.getName_show();
                String userId = this.a.getUserId();
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TIEBA_UID_SHARE_DIALOG_CLICK);
                statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.addParam("obj_param1", userId);
                TiebaStatic.log(statisticItem);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.b.getPageActivity(), userId, name_show)));
            }
        }
    }

    public hi4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
    }

    public static TbPageContext c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            if (activity instanceof BaseActivity) {
                return ((BaseActivity) activity).getPageContext();
            }
            if (activity instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) activity).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }

    public static hi4 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (b == null) {
                synchronized (hi4.class) {
                    if (b == null) {
                        b = new hi4();
                    }
                }
            }
            return b;
        }
        return (hi4) invokeV.objValue;
    }

    public void b() {
        ph4 ph4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (ph4Var = this.a) != null && ph4Var.isShowing()) {
            this.a.a();
        }
    }

    public void e(UserData userData, nh4.m mVar) {
        TbPageContext c;
        boolean z;
        String format;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, userData, mVar) == null) || (c = c(TbadkCoreApplication.getInst().getCurrentActivity())) == null || c.getPageActivity() == null || userData == null || mVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TIEBA_UID_SHARE_DIALOG_SHOW);
        statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.addParam("obj_param1", userData.getUserId());
        TiebaStatic.log(statisticItem);
        Activity pageActivity = c.getPageActivity();
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(c.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01f7, (ViewGroup) null, false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09243a);
        boolean z2 = true;
        textView.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f13f8), mVar.a()));
        textView.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0108));
        View findViewById = viewGroup.findViewById(R.id.obfuscated_res_0x7f0911e1);
        View findViewById2 = viewGroup.findViewById(R.id.obfuscated_res_0x7f091a9d);
        findViewById.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0108));
        findViewById2.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0108));
        HeadImageView headImageView = (HeadImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09227a);
        headImageView.setDefaultResource(R.drawable.obfuscated_res_0x7f081233);
        headImageView.setGodIconWidth(R.dimen.tbds68);
        headImageView.setAutoChangeStyle(false);
        UtilHelper.showHeadImageViewBigV(headImageView, userData);
        headImageView.setIsRound(true);
        headImageView.K(userData.getAvater(), 25, false);
        TextView textView2 = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f092298);
        textView2.setText(userData.getName_show());
        textView2.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0105));
        TextView textView3 = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0922b8);
        textView3.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f13f7), mVar.b()));
        textView3.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0109));
        LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f0906b1);
        if (ListUtils.isEmpty(userData.getManagerForum()) && !userData.isNewGod()) {
            linearLayout.setVisibility(8);
        } else {
            linearLayout.setVisibility(0);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X001);
            boolean z3 = userData.isNewGod() && !ListUtils.isEmpty(userData.getManagerForum());
            if (userData.isNewGod()) {
                TextView textView4 = new TextView(pageActivity);
                textView4.setPadding(dimenPixelSize, dimenPixelSize2, dimenPixelSize, dimenPixelSize2);
                textView4.setText(userData.getNewGodData().getFieldName() + wc5.a(userData.getNewGodData()));
                textView4.setTextSize(0, (float) UtilHelper.getDimenPixelSize(R.dimen.T_X09));
                linearLayout.addView(textView4);
                textView4.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0107));
                SkinManager.setBackgroundShapeDrawable(textView4, R.dimen.tbds26, R.color.CAM_X0623, R.color.CAM_X0623, 0);
                z = true;
            } else {
                z = false;
            }
            if (!ListUtils.isEmpty(userData.getManagerForum())) {
                TextView textView5 = new TextView(pageActivity);
                textView5.setPadding(dimenPixelSize, dimenPixelSize2, dimenPixelSize, dimenPixelSize2);
                String desc = userData.getManagerForum().get(0).getDesc();
                if (userData.getManagerForum().size() > 1) {
                    if (z3) {
                        desc = StringHelper.cutChineseAndEnglishWithSuffix(desc, 6, StringHelper.STRING_MORE);
                    }
                    format = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b1e), desc, Integer.valueOf(userData.getManagerForum().size()));
                } else {
                    if (z3) {
                        desc = StringHelper.cutChineseAndEnglishWithSuffix(desc, 8, StringHelper.STRING_MORE);
                    }
                    format = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f11af), desc);
                }
                textView5.setText(format);
                textView5.setTextSize(0, UtilHelper.getDimenPixelSize(R.dimen.T_X09));
                if (z) {
                    View view2 = new View(pageActivity);
                    view2.setLayoutParams(new LinearLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.M_W_X006), 1));
                    linearLayout.addView(view2);
                }
                linearLayout.addView(textView5);
                textView5.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0107));
                SkinManager.setBackgroundShapeDrawable(textView5, R.dimen.tbds26, R.color.CAM_X0623, R.color.CAM_X0623, 0);
            }
            z2 = false;
        }
        TextView textView6 = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0922b2);
        String intro = userData.getIntro();
        if (TextUtils.isEmpty(userData.getIntro()) && z2) {
            intro = StringHelper.getBaAgeAutoYearAndMonth(userData.getTb_age());
        }
        textView6.setText(intro);
        if (linearLayout.getVisibility() == 0) {
            textView6.setMaxLines(1);
        } else {
            textView6.setMaxLines(2);
        }
        textView6.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0107));
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) viewGroup.findViewById(R.id.obfuscated_res_0x7f090fca);
        ot4 ot4Var = new ot4();
        ot4Var.p(R.color.CAM_X0302, R.color.CAM_X0101);
        tBSpecificationBtn.setTextSize(R.dimen.T_X05);
        tBSpecificationBtn.setConfig(ot4Var);
        tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f033d));
        tBSpecificationBtn.setOnClickListener(new a(this, userData, c));
        this.a = new ph4(c);
        this.a.b(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080d6f, false));
        this.a.c(viewGroup);
        this.a.d();
        TbSingleton.getInstance().setExceptInsertAdDiaShow(true);
    }
}
