package com.repackage;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.api.share.Share;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.QqShareH5Switch;
import com.baidu.tbadk.switchs.UrlNeedCuidSwitch;
import com.baidu.tbadk.switchs.WeChatShareSmallAppToH5Switch;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ny4;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
/* loaded from: classes7.dex */
public class sy4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public oy4 b;
    public py4 c;
    public String d;
    public String e;
    public ny4 f;
    public ny4.b g;
    public ny4.b h;
    public ny4.b i;

    /* loaded from: classes7.dex */
    public class a implements ny4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy4 a;

        public a(sy4 sy4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sy4Var;
        }

        @Override // com.repackage.ny4.b
        public void a(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                ShareItem x = this.a.x(shareItem, ThirdPartyUtil.TYPE_WEIXIN);
                this.a.g(x);
                this.a.c.a(x, 3, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ny4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy4 a;

        public b(sy4 sy4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sy4Var;
        }

        @Override // com.repackage.ny4.b
        public void a(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                this.a.c.a(this.a.x(shareItem, Share.QQFRIEND), 8, true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ny4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy4 a;

        public c(sy4 sy4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sy4Var;
        }

        @Override // com.repackage.ny4.b
        public void a(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                this.a.c.a(this.a.x(shareItem, "qzone"), 4, true);
            }
        }
    }

    public sy4(Context context, oy4 oy4Var) {
        qy4 qy4Var;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, oy4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        this.d = TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f1142);
        this.e = TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f1556) + this.d;
        this.g = new a(this);
        this.h = new b(this);
        this.i = new c(this);
        this.a = context;
        this.b = oy4Var;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001445, qy4.class);
        if (runTask == null || runTask.getData() == null || (qy4Var = (qy4) runTask.getData()) == null) {
            return;
        }
        this.c = qy4Var.a(this.a, this.b);
    }

    public static String e(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            if (str.contains("?")) {
                str3 = "&";
            } else {
                str = str + "?";
                str3 = "";
            }
            return str + str3 + str2;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) ? n() : invokeL.booleanValue;
    }

    public static String i(ThreadData threadData, int i, String str, long j, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{threadData, Integer.valueOf(i), str, Long.valueOf(j), str2, str3})) == null) {
            if (threadData == null) {
                return "";
            }
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            StringBuilder sb = new StringBuilder();
            if (i != 2 && i != 6 && i != 8) {
                if (threadData.getIsNoTitle() == 0) {
                    String str4 = threadData.getAbstract();
                    if (!StringUtils.isNull(str4)) {
                        str3 = str4;
                    }
                    if (!StringUtils.isNull(str3) && !StringUtil.NULL_STRING.equals(str3)) {
                        if (str3.length() > 20) {
                            sb.append(str3.substring(0, 20));
                            sb.append(StringHelper.STRING_MORE);
                        } else {
                            sb.append(str3);
                        }
                        sb.append(StringUtils.lineSeparator);
                    } else {
                        String l = l(threadData, str2);
                        if (!StringUtils.isNull(l)) {
                            sb.append(inst.getString(R.string.obfuscated_res_0x7f0f0e94));
                            sb.append(l);
                            sb.append(StringUtils.lineSeparator);
                        }
                    }
                    if (j > 0) {
                        sb.append(inst.getString(R.string.obfuscated_res_0x7f0f0665));
                        sb.append(StringHelper.numFormatOver10000(j));
                    }
                } else {
                    String l2 = l(threadData, str2);
                    if (!StringUtils.isNull(l2)) {
                        sb.append(inst.getString(R.string.obfuscated_res_0x7f0f0e94));
                        sb.append(l2);
                        sb.append(StringUtils.lineSeparator);
                    }
                    if (j > 0) {
                        sb.append(inst.getString(R.string.obfuscated_res_0x7f0f0665));
                        sb.append(StringHelper.numFormatOver10000(j));
                    }
                }
            } else {
                if (j > 0) {
                    sb.append(inst.getString(R.string.obfuscated_res_0x7f0f0665));
                    sb.append(StringHelper.numFormatOver10000(j));
                    sb.append(StringUtils.lineSeparator);
                }
                String l3 = l(threadData, str2);
                if (!StringUtils.isNull(l3)) {
                    sb.append(inst.getString(R.string.obfuscated_res_0x7f0f0e94));
                    sb.append(l3);
                    sb.append(StringUtils.lineSeparator);
                }
                if (!StringUtils.isNull(str)) {
                    if (str.length() > 10) {
                        str = str.substring(0, 10) + StringHelper.STRING_MORE;
                    }
                    sb.append(str);
                    sb.append(inst.getString(R.string.obfuscated_res_0x7f0f0643));
                }
            }
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static String j(ThreadData threadData, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, threadData, i)) == null) {
            if (threadData == null) {
                return "";
            }
            String title = threadData.getTitle();
            if (i == 2 || i == 6 || i == 8) {
                return title;
            }
            return threadData.getIsNoTitle() == 0 ? title : threadData.getAbstract();
        }
        return (String) invokeLI.objValue;
    }

    public static int k(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, threadData)) == null) {
            if (threadData != null) {
                if (threadData.isRealGod()) {
                    return 4;
                }
                if (threadData.getIsLive() == 1) {
                    return 3;
                }
                if (threadData.isBJHArticleThreadType()) {
                    return 5;
                }
                if (threadData.isBJHVideoThreadType()) {
                    return 6;
                }
                if (threadData.isBJHNormalThreadType()) {
                    return 7;
                }
                if (threadData.isBJHVideoDynamicThreadType()) {
                    return 8;
                }
                if (!threadData.isShareThread || threadData.originalThreadData == null) {
                    return threadData.isRealVideoThread() ? 2 : 1;
                }
                return 9;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static String l(ThreadData threadData, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, threadData, str)) == null) {
            if (threadData.getAuthor() != null) {
                str2 = threadData.getAuthor().getName_show();
                if (!StringUtils.isNull(str2) && str2.length() > 10) {
                    str2 = str2.substring(0, 10) + StringHelper.STRING_MORE;
                }
            } else {
                str2 = "";
            }
            return StringUtils.isNull(str2) ? str : str2;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? TbadkCoreApplication.getInst().appResponseToCmd(2001445) : invokeV.booleanValue;
    }

    public static String v(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65547, null, str, str2, z)) == null) ? w(str, "copy", str2, z) : (String) invokeLLZ.objValue;
    }

    public static String w(String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{str, str2, str3, Boolean.valueOf(z)})) == null) {
            if (ni.isEmpty(str)) {
                str = TbDomainConfig.DOMAIN_HTTPS_TIEBA;
            }
            String e = e(e(str, "sfc=" + str2), "client_type=2");
            String e2 = e(e, "client_version=" + TbConfig.getVersion());
            String e3 = e(e2, "st=" + (System.currentTimeMillis() / 1000));
            String e4 = e(e3, "is_video=" + z);
            if (str3 != null) {
                if (SwitchManager.getInstance().findType(UrlNeedCuidSwitch.URL_NEED_CUID_SWITCH) == 1) {
                    c2 = ui.c(str3 + TbadkCoreApplication.getInst().getCuid() + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
                } else {
                    c2 = ui.c(str3 + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
                }
                return e(e4, "unique=" + c2);
            }
            return e4;
        }
        return (String) invokeCommon.objValue;
    }

    public final String d(String str, int i, int i2, String str2) {
        InterceptResult invokeCommon;
        int min;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2})) == null) {
            if (str == null) {
                return str2;
            }
            if (Math.min((i - str2.length()) - i2, str.length()) < str.length()) {
                return str.substring(0, min - 1) + (StringHelper.STRING_MORE + str2);
            }
            return str + str2;
        }
        return (String) invokeCommon.objValue;
    }

    public final ShareItem g(ShareItem shareItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareItem)) == null) {
            if (WeChatShareSmallAppToH5Switch.isOn() && UbsABTestHelper.isShareH5CardOptimizeABTestA() && (!StringUtils.isNull(shareItem.y0) || !StringUtils.isNull(shareItem.z0) || shareItem.A0 != null)) {
                if (!StringUtils.isNull(shareItem.y0)) {
                    shareItem.r = ni.cutString(shareItem.y0, 100);
                }
                if (!StringUtils.isNull(shareItem.z0)) {
                    shareItem.s = ni.cutString(shareItem.z0, 100);
                }
                Uri uri = shareItem.A0;
                if (uri != null) {
                    shareItem.v = uri;
                }
            }
            if (WeChatShareSmallAppToH5Switch.isOn() && !StringUtils.isNull(shareItem.t)) {
                if (UbsABTestHelper.isShareH5CardOptimizeABTestA()) {
                    shareItem.t = e(shareItem.t, "&source=12_16_sharecard_a");
                } else if (UbsABTestHelper.isShareH5CardOptimizeABTestContrast()) {
                    shareItem.t = e(shareItem.t, "&source=12_16_sharecard");
                }
            }
            return shareItem;
        }
        return (ShareItem) invokeL.objValue;
    }

    public final ShareItem h(ShareItem shareItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, shareItem)) == null) {
            if (UbsABTestHelper.isShareH5CardOptimizeABTestA() && (shareItem.A0 != null || !StringUtils.isNull(shareItem.z0))) {
                if (!StringUtils.isNull(shareItem.z0)) {
                    shareItem.s = ni.cutString(shareItem.z0, 100);
                }
                Uri uri = shareItem.A0;
                if (uri != null) {
                    shareItem.v = uri;
                }
            }
            if (UbsABTestHelper.isShareH5CardOptimizeABTestA()) {
                if (!StringUtils.isNull(shareItem.t)) {
                    shareItem.t = e(shareItem.t, "&source=12_16_sharecard_a");
                }
            } else if (UbsABTestHelper.isShareH5CardOptimizeABTestContrast() && !StringUtils.isNull(shareItem.t)) {
                shareItem.t = e(shareItem.t, "&source=12_16_sharecard");
            }
            return shareItem;
        }
        return (ShareItem) invokeL.objValue;
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.startsWith("file://")) {
                try {
                    file = new File(new URI(str));
                } catch (URISyntaxException unused) {
                }
                return file.isFile() && file.exists();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void o(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, shareItem) == null) || this.c == null || shareItem == null) {
            return;
        }
        shareItem.s = d(shareItem.s, 80, 32, shareItem.h0 ? this.d : "");
        if (!QqShareH5Switch.isOn() && !ni.isEmpty(shareItem.k0)) {
            shareItem.v = Uri.parse(shareItem.k0);
            this.c.a(x(shareItem, Share.QQFRIEND), 8, true);
        } else if (!QqShareH5Switch.isOn() && ni.isEmpty(shareItem.k0) && !ni.isEmpty(shareItem.K) && !"0".equals(shareItem.K)) {
            if (this.f == null) {
                ny4 ny4Var = new ny4();
                this.f = ny4Var;
                ny4Var.c(this.h);
            }
            this.f.b(shareItem);
        } else {
            if (!QqShareH5Switch.isOn()) {
                if (this.f == null) {
                    this.f = new ny4();
                }
                this.f.b(shareItem);
            }
            ShareItem x = x(shareItem, Share.QQFRIEND);
            h(x);
            this.c.a(x, 8, true);
        }
    }

    public void p(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, shareItem) == null) || this.c == null) {
            return;
        }
        shareItem.s = d(shareItem.s, 80, 32, shareItem.h0 ? this.d : "");
        if (!QqShareH5Switch.isOn() && !ni.isEmpty(shareItem.k0)) {
            shareItem.v = Uri.parse(shareItem.k0);
            this.c.a(x(shareItem, "qzone"), 4, true);
        } else if (!QqShareH5Switch.isOn() && ni.isEmpty(shareItem.k0) && !ni.isEmpty(shareItem.K) && !"0".equals(shareItem.K)) {
            if (this.f == null) {
                ny4 ny4Var = new ny4();
                this.f = ny4Var;
                ny4Var.c(this.i);
            }
            this.f.b(shareItem);
        } else {
            if (!QqShareH5Switch.isOn()) {
                if (this.f == null) {
                    this.f = new ny4();
                }
                this.f.b(shareItem);
            }
            this.c.a(x(shareItem, "qzone"), 4, true);
        }
    }

    public void q(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, shareItem) == null) || this.c == null) {
            return;
        }
        shareItem.s = d(shareItem.s, 140, 20, shareItem.h0 ? this.d : "");
        this.c.a(x(shareItem, "renren"), 7, true);
    }

    public void r(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, shareItem) == null) || this.c == null) {
            return;
        }
        if (!my4.b(TbadkApplication.getInst().getApplicationContext(), 6)) {
            BdToast.c(TbadkApplication.getInst().getApplicationContext(), TbadkApplication.getInst().getApplicationContext().getText(R.string.obfuscated_res_0x7f0f113f)).q();
            return;
        }
        shareItem.s = d(shareItem.s, 140, 20, shareItem.h0 ? this.e : "");
        this.c.a(x(shareItem, "sina_weibo"), 6, true);
    }

    public void s(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, shareItem) == null) || this.c == null) {
            return;
        }
        shareItem.s = d(shareItem.s, 140, 20, shareItem.h0 ? this.d : "");
        this.c.a(x(shareItem, "tencent_weibo"), 5, true);
    }

    public void t(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, shareItem) == null) || this.c == null || shareItem == null) {
            return;
        }
        if (StringUtils.isNull(shareItem.K)) {
            shareItem.s = d(shareItem.s, 80, 20, shareItem.h0 ? this.d : "");
        }
        if (shareItem.m0 && !ni.isEmpty(shareItem.k0)) {
            shareItem.v = Uri.parse(shareItem.k0);
            ShareItem x = x(shareItem, ThirdPartyUtil.TYPE_WEIXIN);
            g(x);
            this.c.a(x, 3, false);
        } else if (shareItem.m0 && ni.isEmpty(shareItem.k0) && !ni.isEmpty(shareItem.K) && !"0".equals(shareItem.K)) {
            if (this.f == null) {
                ny4 ny4Var = new ny4();
                this.f = ny4Var;
                ny4Var.c(this.g);
            }
            this.f.b(shareItem);
        } else {
            if (shareItem.y == 4) {
                if (this.f == null) {
                    this.f = new ny4();
                }
                this.f.b(shareItem);
            }
            ShareItem x2 = x(shareItem, ThirdPartyUtil.TYPE_WEIXIN);
            g(x2);
            this.c.a(x2, 3, false);
        }
    }

    public void u(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, shareItem) == null) || this.c == null || shareItem == null) {
            return;
        }
        shareItem.s = d(shareItem.s, 80, 20, shareItem.h0 ? this.d : "");
        this.c.a(x(shareItem, Share.WEIXIN_TIMELINE), 2, false);
    }

    public final ShareItem x(ShareItem shareItem, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, shareItem, str)) == null) {
            if (shareItem == null) {
                return null;
            }
            Uri uri = shareItem.v;
            if ((uri == null || uri.equals("")) && shareItem.c() == null) {
                str.startsWith(ThirdPartyUtil.TYPE_WEIXIN);
                shareItem.v = Uri.parse("https://tb5.bdstatic.com/yunying/tieba_logo.jpg");
            }
            Uri uri2 = shareItem.v;
            if (uri2 != null && !uri2.equals("")) {
                String uri3 = shareItem.v.toString();
                if (!m(uri3) && !y(uri3)) {
                    shareItem.v = Uri.parse("https://tb5.bdstatic.com/yunying/tieba_logo.jpg");
                } else {
                    shareItem.v = Uri.parse(uri3);
                    e(uri3, "sfc=" + str);
                }
            }
            if (shareItem.i0) {
                shareItem.t = w(shareItem.t, str, shareItem.K, UtilHelper.isVideoThread(shareItem.M));
            }
            return shareItem;
        }
        return (ShareItem) invokeLL.objValue;
    }

    public final boolean y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            String[] split = "jpg,jpeg,png,gif,bmp".split(",");
            if (UrlManager.getInstance().UrlValidated(str)) {
                if (split == null || split.length <= 0) {
                    return true;
                }
                for (String str2 : split) {
                    if (str2 != null && !str2.equals("") && (str.contains(str2) || str.contains(str2.toUpperCase()))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
