package com.repackage;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigImgPbActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.pb.PbPageRequestMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class mt7 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean A;
    public static boolean B;
    public static PbActivityConfig C;
    public static wa D;
    public static String a;
    public static String b;
    public static String c;
    public static int d;
    public static String e;
    public static String f;
    public static String g;
    public static boolean h;
    public static final BdUniDispatchSchemeController.b i;
    public static int j;
    public static int k;
    public static String l;
    public static String m;
    public static boolean n;
    public static boolean o;
    public static boolean p;
    public static int q;
    public static String r;
    public static String s;
    public static boolean t;
    public static boolean u;
    public static long v;
    public static String w;
    public static String x;
    public static String y;
    public static String z;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements BdUniDispatchSchemeController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.BdToken.BdUniDispatchSchemeController.b
        public void a(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) || hashMap == null) {
                return;
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_TID) instanceof String) {
                String unused = mt7.a = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_TID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_NID) instanceof String) {
                String unused2 = mt7.b = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_NID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TID) instanceof String) {
                String unused3 = mt7.c = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TYPE) instanceof String) {
                int unused4 = mt7.d = mg.e((String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TYPE), 0);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_VID) instanceof String) {
                String unused5 = mt7.e = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_VID);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage.getOrginalMessage().getSelf() instanceof PbPageRequestMessage) {
                    PbPageRequestMessage pbPageRequestMessage = (PbPageRequestMessage) responsedMessage.getOrginalMessage().getSelf();
                    z = pbPageRequestMessage.isFromPbOptimize();
                    j = pbPageRequestMessage.get_kz();
                } else {
                    z = false;
                    j = 0;
                }
                if (lt7.a().e() && z && j == mg.g(mt7.a, 0L)) {
                    TbSingleton.getInstance().pushPbResMsg = responsedMessage;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755487679, "Lcom/repackage/mt7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755487679, "Lcom/repackage/mt7;");
                return;
            }
        }
        i = new a();
        D = new b(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            String str = a;
            String h2 = (str == null || str.equals("0")) ? h() : a;
            if (o) {
                h2 = h2 + "_host";
            }
            int i2 = q;
            if (i2 == 1) {
                h2 = h2 + "_rev";
            } else if (i2 == 2) {
                h2 = h2 + "_hot";
            }
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                return h2 + TbadkCoreApplication.getCurrentAccount();
            }
            return h2;
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            String str = "";
            if (b != null) {
                str = "" + b;
            }
            if (c != null) {
                str = str + c;
            }
            String str2 = str + d;
            if (e != null) {
                return str2 + e;
            }
            return str2;
        }
        return (String) invokeV.objValue;
    }

    public static HashMap<String, Object> i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            if (str.startsWith("//")) {
                str = str.substring(2);
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            String[] split = str.split("[&]");
            if (split.length == 0) {
                return null;
            }
            for (String str2 : split) {
                String[] split2 = str2.split("[=]");
                if (split2.length > 1) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static void j(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, intent) == null) {
            a = intent.getStringExtra("thread_id");
            b = intent.getStringExtra("key_ori_ugc_nid");
            c = intent.getStringExtra("key_ori_ugc_tid");
            d = intent.getIntExtra("key_ori_ugc_type", 0);
            e = intent.getStringExtra("key_ori_ugc_vid");
            intent.getBooleanExtra("key_jump_to_comment_area", false);
            intent.getBooleanExtra("is_jump_from_video_middle", false);
            f = intent.getStringExtra("key_official_bar_message_id");
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            g = uri != null ? uri.toString() : null;
            h = false;
            if (BdUniDispatchSchemeController.isUniScheme(uri)) {
                h = true;
                BdUniDispatchSchemeController.getInstance().parsePbScheme(uri, i);
            } else if (StringUtils.isNull(a)) {
                h = true;
                String uri2 = uri != null ? uri.toString() : "";
                if (!StringUtils.isNull(uri2) && uri2.startsWith("tbpb://")) {
                    if (uri == null) {
                        return;
                    }
                    String decode = Uri.decode(uri.getEncodedPath());
                    if (StringUtils.isNull(decode) || i(decode) == null) {
                        return;
                    }
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SCHEMA_UPLOAD);
                    httpMessage.addParam("call_url", uri2);
                    MessageManager.getInstance().sendMessage(httpMessage);
                }
                if (uri != null) {
                    if (StringUtils.isNull(a)) {
                        a = uri.getQueryParameter("thread_id");
                    }
                    if (StringUtils.isNull(b)) {
                        b = uri.getQueryParameter("key_ori_ugc_nid");
                    }
                    if (StringUtils.isNull(c)) {
                        c = uri.getQueryParameter("key_ori_ugc_tid");
                    }
                    if (d == 0) {
                        d = mg.e(uri.getQueryParameter("key_ori_ugc_type"), 0);
                    }
                    if (StringUtils.isNull(e)) {
                        e = uri.getQueryParameter("key_ori_ugc_vid");
                    }
                }
            }
            if (ni.isEmpty(a)) {
                a = "0";
            }
            int intExtra = intent.getIntExtra("key_start_from", 0);
            j = intExtra;
            if (intExtra == 0) {
                j = k;
            }
            l = intent.getStringExtra("post_id");
            m = intent.getStringExtra("forum_id");
            n = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            o = intent.getBooleanExtra("host_only", false);
            p = intent.getBooleanExtra("squence", true);
            int intExtra2 = intent.getIntExtra("sort_type", -1);
            q = intExtra2;
            if (intExtra2 < 0) {
                intExtra2 = vt4.k().l("key_pb_current_sort_type", 2);
            }
            q = intExtra2;
            l = intExtra2 != 2 ? l : "0";
            r = intent.getStringExtra("st_type");
            s = intent.getStringExtra("locate");
            t = intent.getBooleanExtra("from_mark", false);
            u = intent.getBooleanExtra("is_pv", false);
            v = intent.getLongExtra("msg_id", 0L);
            w = intent.getStringExtra("from_forum_name");
            x = intent.getStringExtra("op_type");
            y = intent.getStringExtra("op_url");
            z = intent.getStringExtra("op_stat");
            A = intent.getBooleanExtra("from_smart_frs", false);
            B = intent.getIntExtra("request_code", -1) == 18003;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x015a, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L113;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int k(String[] strArr) {
        InterceptResult invokeL;
        String c2;
        boolean z2;
        String str;
        boolean z3;
        boolean z4;
        boolean z5;
        String substring;
        PbActivityConfig createNormalCfg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, strArr)) == null) {
            if (strArr == null || strArr.length == 0 || strArr[0] == null) {
                return 3;
            }
            Pattern compile = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");
            String lowerCase = strArr[0].toLowerCase();
            Matcher matcher = compile.matcher(lowerCase);
            String str2 = "push";
            if (Pattern.compile("http[s]?://tieba\\.baidu\\.com/p/([\\d]+)\\?pid=([\\d]+)&tid=([\\d]+)&threadtype=([\\d]+)&jump_type=(.*)&jump_tieba_native=1").matcher(lowerCase).find() || lowerCase.contains(UrlSchemaHelper.SCHEMA_TYPE_BAIJIAHAO_PB)) {
                return 3;
            }
            String str3 = "allthread";
            String str4 = "";
            if (matcher.find()) {
                c2 = matcher.group(1);
                Uri parse = Uri.parse(lowerCase);
                str4 = parse.getQueryParameter("pid");
                z3 = mg.b(parse.getQueryParameter("is_video"), false);
                z5 = mg.b(parse.getQueryParameter("is_official_video"), false);
                str = parse.getQueryParameter("broadcast_id");
                if (lowerCase != null) {
                    String[] split = lowerCase.split("&");
                    for (int i2 = 0; i2 < split.length; i2++) {
                        if (split[i2] != null) {
                            if (split[i2].startsWith("thread_type=")) {
                                split[i2].substring(12);
                            } else if (split[i2].startsWith("playstatkey=")) {
                                str2 = split[i2].substring(12);
                            }
                        }
                    }
                    z2 = mg.b(nd5.c(lowerCase, "is_from_push="), false);
                } else {
                    z2 = false;
                }
                if (lowerCase != null && lowerCase.contains("?")) {
                    String[] split2 = lowerCase.substring(lowerCase.indexOf("?") + 1, lowerCase.length()).split("&");
                    int length = split2.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        }
                        String str5 = split2[i3];
                        if (str5.startsWith("playstatkey=")) {
                            str2 = str5.substring(12);
                            break;
                        }
                        i3++;
                    }
                }
                if (lowerCase != null) {
                    String c3 = nd5.c(lowerCase, "sttype=");
                    if (!StringUtils.isNull(c3)) {
                        str3 = c3;
                    }
                }
                z4 = true;
            } else {
                if (lowerCase != null && (lowerCase.startsWith("http://tieba.baidu.com/f?") || lowerCase.startsWith("http://tieba.baidu.com/f?"))) {
                    if (lowerCase.startsWith("http://tieba.baidu.com/f?")) {
                        substring = lowerCase.substring(25);
                    } else {
                        substring = lowerCase.startsWith("http://tieba.baidu.com/f?") ? lowerCase.substring(25) : null;
                    }
                    if (substring != null) {
                        String[] split3 = substring.split("&");
                        int i4 = 0;
                        while (true) {
                            if (i4 >= split3.length) {
                                c2 = null;
                                break;
                            } else if (split3[i4] != null && split3[i4].startsWith("kz=")) {
                                c2 = split3[i4].substring(3);
                                break;
                            } else {
                                i4++;
                            }
                        }
                        if (!TextUtils.isEmpty(c2) && c2.contains("&")) {
                            c2 = c2.split("&")[0];
                        }
                    }
                    c2 = null;
                } else {
                    if (!TextUtils.isEmpty(lowerCase) && lowerCase.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                        String substring2 = lowerCase.substring(3);
                        if (strArr.length > 1) {
                            str3 = strArr[1];
                            c2 = substring2;
                        } else {
                            c2 = substring2;
                        }
                    } else if (!TextUtils.isEmpty(lowerCase) && lowerCase.startsWith("com.baidu.tieba://?kz=")) {
                        c2 = lowerCase.substring(22);
                    } else if (TextUtils.isEmpty(lowerCase) || !lowerCase.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) || !lowerCase.contains("kz=")) {
                        return 3;
                    } else {
                        c2 = nd5.c(lowerCase, "kz=");
                    }
                    z2 = false;
                    str = null;
                    z3 = false;
                    str3 = null;
                    z4 = true;
                    z5 = false;
                }
                z2 = false;
                str = null;
                z3 = false;
                z4 = true;
                z5 = false;
            }
            if (StringUtils.isNull(c2, z4) || z3 || z5) {
                return 3;
            }
            if (StringUtils.isNull(str4)) {
                createNormalCfg = new PbActivityConfig(TbadkCoreApplication.getInst()).createNormalCfg(c2, null, str3);
            } else {
                createNormalCfg = new PbActivityConfig(TbadkCoreApplication.getInst()).createNormalCfg(c2, str4, str3);
            }
            if (!TextUtils.isEmpty(lowerCase) && lowerCase.contains(BigImgPbActivityConfig.OPEN_COMMON) && "1".equals(nd5.c(lowerCase, BigImgPbActivityConfig.OPEN_COMMON))) {
                createNormalCfg.setUserName(nd5.c(lowerCase, BigImgPbActivityConfig.BIG_PB_USER_NAME));
            }
            createNormalCfg.setVideo_source(str2);
            createNormalCfg.setStartFrom(25);
            if (z2) {
                createNormalCfg.setFromPushNotify();
                createNormalCfg.setStartFrom(7);
            }
            if (lowerCase != null && lowerCase.contains(UrlSchemaHelper.FROM_YUN_PUSH)) {
                createNormalCfg.setStartFrom(7);
            }
            if (!StringUtils.isNull(str)) {
                createNormalCfg.setOfficialBarMessageId(str);
            }
            if (lowerCase != null && lowerCase.contains("fr=collect")) {
                createNormalCfg.setJumpToCommentArea(true);
            }
            C = createNormalCfg;
            return 0;
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x012e A[Catch: Exception -> 0x0232, TryCatch #0 {Exception -> 0x0232, blocks: (B:9:0x0029, B:11:0x002d, B:14:0x0037, B:18:0x009f, B:20:0x00af, B:21:0x00b2, B:23:0x00bf, B:24:0x00c2, B:26:0x00c6, B:27:0x00cb, B:29:0x00cf, B:30:0x00d4, B:32:0x00d8, B:33:0x00e7, B:35:0x00eb, B:36:0x00ee, B:38:0x00f2, B:39:0x010a, B:41:0x0111, B:44:0x0116, B:46:0x011d, B:48:0x0124, B:54:0x012e, B:56:0x0138, B:58:0x013c, B:59:0x0141, B:63:0x0167, B:65:0x0172, B:67:0x017f, B:69:0x0189, B:71:0x0190, B:73:0x0194, B:75:0x0199, B:78:0x019e, B:80:0x01a5, B:82:0x01c1, B:83:0x01ca, B:85:0x01d1, B:87:0x01db, B:94:0x01f2, B:90:0x01e6, B:79:0x01a2, B:70:0x018d, B:66:0x017a, B:55:0x0132, B:45:0x011a), top: B:103:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0132 A[Catch: Exception -> 0x0232, TryCatch #0 {Exception -> 0x0232, blocks: (B:9:0x0029, B:11:0x002d, B:14:0x0037, B:18:0x009f, B:20:0x00af, B:21:0x00b2, B:23:0x00bf, B:24:0x00c2, B:26:0x00c6, B:27:0x00cb, B:29:0x00cf, B:30:0x00d4, B:32:0x00d8, B:33:0x00e7, B:35:0x00eb, B:36:0x00ee, B:38:0x00f2, B:39:0x010a, B:41:0x0111, B:44:0x0116, B:46:0x011d, B:48:0x0124, B:54:0x012e, B:56:0x0138, B:58:0x013c, B:59:0x0141, B:63:0x0167, B:65:0x0172, B:67:0x017f, B:69:0x0189, B:71:0x0190, B:73:0x0194, B:75:0x0199, B:78:0x019e, B:80:0x01a5, B:82:0x01c1, B:83:0x01ca, B:85:0x01d1, B:87:0x01db, B:94:0x01f2, B:90:0x01e6, B:79:0x01a2, B:70:0x018d, B:66:0x017a, B:55:0x0132, B:45:0x011a), top: B:103:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013c A[Catch: Exception -> 0x0232, TryCatch #0 {Exception -> 0x0232, blocks: (B:9:0x0029, B:11:0x002d, B:14:0x0037, B:18:0x009f, B:20:0x00af, B:21:0x00b2, B:23:0x00bf, B:24:0x00c2, B:26:0x00c6, B:27:0x00cb, B:29:0x00cf, B:30:0x00d4, B:32:0x00d8, B:33:0x00e7, B:35:0x00eb, B:36:0x00ee, B:38:0x00f2, B:39:0x010a, B:41:0x0111, B:44:0x0116, B:46:0x011d, B:48:0x0124, B:54:0x012e, B:56:0x0138, B:58:0x013c, B:59:0x0141, B:63:0x0167, B:65:0x0172, B:67:0x017f, B:69:0x0189, B:71:0x0190, B:73:0x0194, B:75:0x0199, B:78:0x019e, B:80:0x01a5, B:82:0x01c1, B:83:0x01ca, B:85:0x01d1, B:87:0x01db, B:94:0x01f2, B:90:0x01e6, B:79:0x01a2, B:70:0x018d, B:66:0x017a, B:55:0x0132, B:45:0x011a), top: B:103:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0172 A[Catch: Exception -> 0x0232, TryCatch #0 {Exception -> 0x0232, blocks: (B:9:0x0029, B:11:0x002d, B:14:0x0037, B:18:0x009f, B:20:0x00af, B:21:0x00b2, B:23:0x00bf, B:24:0x00c2, B:26:0x00c6, B:27:0x00cb, B:29:0x00cf, B:30:0x00d4, B:32:0x00d8, B:33:0x00e7, B:35:0x00eb, B:36:0x00ee, B:38:0x00f2, B:39:0x010a, B:41:0x0111, B:44:0x0116, B:46:0x011d, B:48:0x0124, B:54:0x012e, B:56:0x0138, B:58:0x013c, B:59:0x0141, B:63:0x0167, B:65:0x0172, B:67:0x017f, B:69:0x0189, B:71:0x0190, B:73:0x0194, B:75:0x0199, B:78:0x019e, B:80:0x01a5, B:82:0x01c1, B:83:0x01ca, B:85:0x01d1, B:87:0x01db, B:94:0x01f2, B:90:0x01e6, B:79:0x01a2, B:70:0x018d, B:66:0x017a, B:55:0x0132, B:45:0x011a), top: B:103:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x017a A[Catch: Exception -> 0x0232, TryCatch #0 {Exception -> 0x0232, blocks: (B:9:0x0029, B:11:0x002d, B:14:0x0037, B:18:0x009f, B:20:0x00af, B:21:0x00b2, B:23:0x00bf, B:24:0x00c2, B:26:0x00c6, B:27:0x00cb, B:29:0x00cf, B:30:0x00d4, B:32:0x00d8, B:33:0x00e7, B:35:0x00eb, B:36:0x00ee, B:38:0x00f2, B:39:0x010a, B:41:0x0111, B:44:0x0116, B:46:0x011d, B:48:0x0124, B:54:0x012e, B:56:0x0138, B:58:0x013c, B:59:0x0141, B:63:0x0167, B:65:0x0172, B:67:0x017f, B:69:0x0189, B:71:0x0190, B:73:0x0194, B:75:0x0199, B:78:0x019e, B:80:0x01a5, B:82:0x01c1, B:83:0x01ca, B:85:0x01d1, B:87:0x01db, B:94:0x01f2, B:90:0x01e6, B:79:0x01a2, B:70:0x018d, B:66:0x017a, B:55:0x0132, B:45:0x011a), top: B:103:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0189 A[Catch: Exception -> 0x0232, TryCatch #0 {Exception -> 0x0232, blocks: (B:9:0x0029, B:11:0x002d, B:14:0x0037, B:18:0x009f, B:20:0x00af, B:21:0x00b2, B:23:0x00bf, B:24:0x00c2, B:26:0x00c6, B:27:0x00cb, B:29:0x00cf, B:30:0x00d4, B:32:0x00d8, B:33:0x00e7, B:35:0x00eb, B:36:0x00ee, B:38:0x00f2, B:39:0x010a, B:41:0x0111, B:44:0x0116, B:46:0x011d, B:48:0x0124, B:54:0x012e, B:56:0x0138, B:58:0x013c, B:59:0x0141, B:63:0x0167, B:65:0x0172, B:67:0x017f, B:69:0x0189, B:71:0x0190, B:73:0x0194, B:75:0x0199, B:78:0x019e, B:80:0x01a5, B:82:0x01c1, B:83:0x01ca, B:85:0x01d1, B:87:0x01db, B:94:0x01f2, B:90:0x01e6, B:79:0x01a2, B:70:0x018d, B:66:0x017a, B:55:0x0132, B:45:0x011a), top: B:103:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x018d A[Catch: Exception -> 0x0232, TryCatch #0 {Exception -> 0x0232, blocks: (B:9:0x0029, B:11:0x002d, B:14:0x0037, B:18:0x009f, B:20:0x00af, B:21:0x00b2, B:23:0x00bf, B:24:0x00c2, B:26:0x00c6, B:27:0x00cb, B:29:0x00cf, B:30:0x00d4, B:32:0x00d8, B:33:0x00e7, B:35:0x00eb, B:36:0x00ee, B:38:0x00f2, B:39:0x010a, B:41:0x0111, B:44:0x0116, B:46:0x011d, B:48:0x0124, B:54:0x012e, B:56:0x0138, B:58:0x013c, B:59:0x0141, B:63:0x0167, B:65:0x0172, B:67:0x017f, B:69:0x0189, B:71:0x0190, B:73:0x0194, B:75:0x0199, B:78:0x019e, B:80:0x01a5, B:82:0x01c1, B:83:0x01ca, B:85:0x01d1, B:87:0x01db, B:94:0x01f2, B:90:0x01e6, B:79:0x01a2, B:70:0x018d, B:66:0x017a, B:55:0x0132, B:45:0x011a), top: B:103:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0194 A[Catch: Exception -> 0x0232, TryCatch #0 {Exception -> 0x0232, blocks: (B:9:0x0029, B:11:0x002d, B:14:0x0037, B:18:0x009f, B:20:0x00af, B:21:0x00b2, B:23:0x00bf, B:24:0x00c2, B:26:0x00c6, B:27:0x00cb, B:29:0x00cf, B:30:0x00d4, B:32:0x00d8, B:33:0x00e7, B:35:0x00eb, B:36:0x00ee, B:38:0x00f2, B:39:0x010a, B:41:0x0111, B:44:0x0116, B:46:0x011d, B:48:0x0124, B:54:0x012e, B:56:0x0138, B:58:0x013c, B:59:0x0141, B:63:0x0167, B:65:0x0172, B:67:0x017f, B:69:0x0189, B:71:0x0190, B:73:0x0194, B:75:0x0199, B:78:0x019e, B:80:0x01a5, B:82:0x01c1, B:83:0x01ca, B:85:0x01d1, B:87:0x01db, B:94:0x01f2, B:90:0x01e6, B:79:0x01a2, B:70:0x018d, B:66:0x017a, B:55:0x0132, B:45:0x011a), top: B:103:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01c1 A[Catch: Exception -> 0x0232, TryCatch #0 {Exception -> 0x0232, blocks: (B:9:0x0029, B:11:0x002d, B:14:0x0037, B:18:0x009f, B:20:0x00af, B:21:0x00b2, B:23:0x00bf, B:24:0x00c2, B:26:0x00c6, B:27:0x00cb, B:29:0x00cf, B:30:0x00d4, B:32:0x00d8, B:33:0x00e7, B:35:0x00eb, B:36:0x00ee, B:38:0x00f2, B:39:0x010a, B:41:0x0111, B:44:0x0116, B:46:0x011d, B:48:0x0124, B:54:0x012e, B:56:0x0138, B:58:0x013c, B:59:0x0141, B:63:0x0167, B:65:0x0172, B:67:0x017f, B:69:0x0189, B:71:0x0190, B:73:0x0194, B:75:0x0199, B:78:0x019e, B:80:0x01a5, B:82:0x01c1, B:83:0x01ca, B:85:0x01d1, B:87:0x01db, B:94:0x01f2, B:90:0x01e6, B:79:0x01a2, B:70:0x018d, B:66:0x017a, B:55:0x0132, B:45:0x011a), top: B:103:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01d1 A[Catch: Exception -> 0x0232, TryCatch #0 {Exception -> 0x0232, blocks: (B:9:0x0029, B:11:0x002d, B:14:0x0037, B:18:0x009f, B:20:0x00af, B:21:0x00b2, B:23:0x00bf, B:24:0x00c2, B:26:0x00c6, B:27:0x00cb, B:29:0x00cf, B:30:0x00d4, B:32:0x00d8, B:33:0x00e7, B:35:0x00eb, B:36:0x00ee, B:38:0x00f2, B:39:0x010a, B:41:0x0111, B:44:0x0116, B:46:0x011d, B:48:0x0124, B:54:0x012e, B:56:0x0138, B:58:0x013c, B:59:0x0141, B:63:0x0167, B:65:0x0172, B:67:0x017f, B:69:0x0189, B:71:0x0190, B:73:0x0194, B:75:0x0199, B:78:0x019e, B:80:0x01a5, B:82:0x01c1, B:83:0x01ca, B:85:0x01d1, B:87:0x01db, B:94:0x01f2, B:90:0x01e6, B:79:0x01a2, B:70:0x018d, B:66:0x017a, B:55:0x0132, B:45:0x011a), top: B:103:0x0029 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void l() {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
            pbPageRequestMessage.setUpdateType(3);
            pbPageRequestMessage.setIsReqAd(1);
            pbPageRequestMessage.setLastids(yz4.o);
            if (o || t) {
                B = false;
            }
            try {
                if (a != null && a.length() != 0) {
                    pbPageRequestMessage.set_kz(mg.g(a, 0L));
                    pbPageRequestMessage.setFloorSortType(1);
                    pbPageRequestMessage.setFloor_rn(4);
                    pbPageRequestMessage.set_rn(15);
                    pbPageRequestMessage.set_with_floor(1);
                    pbPageRequestMessage.set_scr_w(Integer.valueOf(oi.k(TbadkCoreApplication.getInst().getApp())));
                    pbPageRequestMessage.set_scr_h(Integer.valueOf(oi.i(TbadkCoreApplication.getInst().getApp())));
                    pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
                    pbPageRequestMessage.set_q_type(Integer.valueOf(TbImageHelper.getInstance().isShowBigImage() ? 2 : 1));
                    pbPageRequestMessage.setSchemeUrl(g);
                    if (!p) {
                        pbPageRequestMessage.set_r(1);
                    }
                    pbPageRequestMessage.set_r(Integer.valueOf(q));
                    if (o) {
                        pbPageRequestMessage.set_lz(1);
                    }
                    if (r != null) {
                        pbPageRequestMessage.set_st_type(r);
                    }
                    if (s != null) {
                        pbPageRequestMessage.setLocate(s);
                    }
                    if (u) {
                        pbPageRequestMessage.set_message_id(Integer.valueOf((int) v));
                        pbPageRequestMessage.set_message_click("1");
                    }
                    if (B) {
                        pbPageRequestMessage.set_banner(1);
                    }
                    if (x != null) {
                        pbPageRequestMessage.setOpType(x);
                        pbPageRequestMessage.setOpUrl(y);
                        pbPageRequestMessage.setOpStat(mg.e(z, 0));
                        pbPageRequestMessage.setOpMessageID(v);
                    }
                    pbPageRequestMessage.set_thread_type(0);
                    if (!t && !o) {
                        pbPageRequestMessage.set_banner(1);
                        pbPageRequestMessage.set_back(0);
                        if (q != 0 && q != 2) {
                            z2 = false;
                            if (!z2) {
                                pbPageRequestMessage.set_pn(1);
                            } else {
                                pbPageRequestMessage.set_last(1);
                                pbPageRequestMessage.set_pn(1);
                            }
                            if (t) {
                                pbPageRequestMessage.set_st_type("store_thread");
                            }
                            o(pbPageRequestMessage);
                            pbPageRequestMessage.setIsFromMark(Boolean.valueOf(t));
                            pbPageRequestMessage.setCacheKey(g());
                            pbPageRequestMessage.setObjParam1(String.valueOf(j));
                            pbPageRequestMessage.setIsSubPostDataReverse(false);
                            pbPageRequestMessage.setFromSmartFrs(!A ? 1 : 0);
                            if (!UtilHelper.isUgcThreadType(d)) {
                                pbPageRequestMessage.setForumId(String.valueOf(0));
                            } else {
                                pbPageRequestMessage.setForumId(m);
                            }
                            pbPageRequestMessage.setNeedRepostRecommendForum(n);
                            if (j != 7) {
                                pbPageRequestMessage.setFrom_push(1);
                            } else {
                                pbPageRequestMessage.setFrom_push(0);
                            }
                            if (j != 7 && j != 5 && !h) {
                                pbPageRequestMessage.setSourceType(2);
                                pbPageRequestMessage.setOriUgcNid(b);
                                pbPageRequestMessage.setOriUgcTid(c);
                                pbPageRequestMessage.setOriUgcType(d);
                                pbPageRequestMessage.setOriUgcVid(e);
                                if (!StringUtils.isNull(f)) {
                                    pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(f));
                                }
                                int i2 = -1;
                                if (pbPageRequestMessage.getPn() != null) {
                                    if (pbPageRequestMessage.getR().intValue() == 1) {
                                        if (pbPageRequestMessage.getPn().intValue() == 1) {
                                            pbPageRequestMessage.setAfterAdThreadCount(i2);
                                            pbPageRequestMessage.setImmersionVideoCommentSource(0);
                                            pbPageRequestMessage.setReqFoldComment(false);
                                            pbPageRequestMessage.getHttpMessage().addHeader("thread_id", a);
                                            pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                                            pbPageRequestMessage.setFromPbOptimize(true);
                                            lt7.a().f(true);
                                            Class.forName("com.baidu.tieba.pb.pb.main.PbActivityStatic");
                                            MessageManager.getInstance().registerListener(D);
                                            MessageManager.getInstance().sendMessage(pbPageRequestMessage);
                                        }
                                    } else if (pbPageRequestMessage.getPn().intValue() == 1) {
                                        pbPageRequestMessage.setAfterAdThreadCount(i2);
                                        pbPageRequestMessage.setImmersionVideoCommentSource(0);
                                        pbPageRequestMessage.setReqFoldComment(false);
                                        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", a);
                                        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                                        pbPageRequestMessage.setFromPbOptimize(true);
                                        lt7.a().f(true);
                                        Class.forName("com.baidu.tieba.pb.pb.main.PbActivityStatic");
                                        MessageManager.getInstance().registerListener(D);
                                        MessageManager.getInstance().sendMessage(pbPageRequestMessage);
                                    }
                                }
                                i2 = 0;
                                pbPageRequestMessage.setAfterAdThreadCount(i2);
                                pbPageRequestMessage.setImmersionVideoCommentSource(0);
                                pbPageRequestMessage.setReqFoldComment(false);
                                pbPageRequestMessage.getHttpMessage().addHeader("thread_id", a);
                                pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                                pbPageRequestMessage.setFromPbOptimize(true);
                                lt7.a().f(true);
                                Class.forName("com.baidu.tieba.pb.pb.main.PbActivityStatic");
                                MessageManager.getInstance().registerListener(D);
                                MessageManager.getInstance().sendMessage(pbPageRequestMessage);
                            }
                            pbPageRequestMessage.setSourceType(1);
                            pbPageRequestMessage.setOriUgcNid(b);
                            pbPageRequestMessage.setOriUgcTid(c);
                            pbPageRequestMessage.setOriUgcType(d);
                            pbPageRequestMessage.setOriUgcVid(e);
                            if (!StringUtils.isNull(f)) {
                            }
                            int i22 = -1;
                            if (pbPageRequestMessage.getPn() != null) {
                            }
                            i22 = 0;
                            pbPageRequestMessage.setAfterAdThreadCount(i22);
                            pbPageRequestMessage.setImmersionVideoCommentSource(0);
                            pbPageRequestMessage.setReqFoldComment(false);
                            pbPageRequestMessage.getHttpMessage().addHeader("thread_id", a);
                            pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                            pbPageRequestMessage.setFromPbOptimize(true);
                            lt7.a().f(true);
                            Class.forName("com.baidu.tieba.pb.pb.main.PbActivityStatic");
                            MessageManager.getInstance().registerListener(D);
                            MessageManager.getInstance().sendMessage(pbPageRequestMessage);
                        }
                        z2 = true;
                        if (!z2) {
                        }
                        if (t) {
                        }
                        o(pbPageRequestMessage);
                        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(t));
                        pbPageRequestMessage.setCacheKey(g());
                        pbPageRequestMessage.setObjParam1(String.valueOf(j));
                        pbPageRequestMessage.setIsSubPostDataReverse(false);
                        pbPageRequestMessage.setFromSmartFrs(!A ? 1 : 0);
                        if (!UtilHelper.isUgcThreadType(d)) {
                        }
                        pbPageRequestMessage.setNeedRepostRecommendForum(n);
                        if (j != 7) {
                        }
                        if (j != 7) {
                            pbPageRequestMessage.setSourceType(2);
                            pbPageRequestMessage.setOriUgcNid(b);
                            pbPageRequestMessage.setOriUgcTid(c);
                            pbPageRequestMessage.setOriUgcType(d);
                            pbPageRequestMessage.setOriUgcVid(e);
                            if (!StringUtils.isNull(f)) {
                            }
                            int i222 = -1;
                            if (pbPageRequestMessage.getPn() != null) {
                            }
                            i222 = 0;
                            pbPageRequestMessage.setAfterAdThreadCount(i222);
                            pbPageRequestMessage.setImmersionVideoCommentSource(0);
                            pbPageRequestMessage.setReqFoldComment(false);
                            pbPageRequestMessage.getHttpMessage().addHeader("thread_id", a);
                            pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                            pbPageRequestMessage.setFromPbOptimize(true);
                            lt7.a().f(true);
                            Class.forName("com.baidu.tieba.pb.pb.main.PbActivityStatic");
                            MessageManager.getInstance().registerListener(D);
                            MessageManager.getInstance().sendMessage(pbPageRequestMessage);
                        }
                        pbPageRequestMessage.setSourceType(1);
                        pbPageRequestMessage.setOriUgcNid(b);
                        pbPageRequestMessage.setOriUgcTid(c);
                        pbPageRequestMessage.setOriUgcType(d);
                        pbPageRequestMessage.setOriUgcVid(e);
                        if (!StringUtils.isNull(f)) {
                        }
                        int i2222 = -1;
                        if (pbPageRequestMessage.getPn() != null) {
                        }
                        i2222 = 0;
                        pbPageRequestMessage.setAfterAdThreadCount(i2222);
                        pbPageRequestMessage.setImmersionVideoCommentSource(0);
                        pbPageRequestMessage.setReqFoldComment(false);
                        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", a);
                        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                        pbPageRequestMessage.setFromPbOptimize(true);
                        lt7.a().f(true);
                        Class.forName("com.baidu.tieba.pb.pb.main.PbActivityStatic");
                        MessageManager.getInstance().registerListener(D);
                        MessageManager.getInstance().sendMessage(pbPageRequestMessage);
                    }
                    pbPageRequestMessage.set_banner(0);
                    pbPageRequestMessage.set_back(0);
                    if (q != 0) {
                        z2 = false;
                        if (!z2) {
                        }
                        if (t) {
                        }
                        o(pbPageRequestMessage);
                        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(t));
                        pbPageRequestMessage.setCacheKey(g());
                        pbPageRequestMessage.setObjParam1(String.valueOf(j));
                        pbPageRequestMessage.setIsSubPostDataReverse(false);
                        pbPageRequestMessage.setFromSmartFrs(!A ? 1 : 0);
                        if (!UtilHelper.isUgcThreadType(d)) {
                        }
                        pbPageRequestMessage.setNeedRepostRecommendForum(n);
                        if (j != 7) {
                        }
                        if (j != 7) {
                        }
                        pbPageRequestMessage.setSourceType(1);
                        pbPageRequestMessage.setOriUgcNid(b);
                        pbPageRequestMessage.setOriUgcTid(c);
                        pbPageRequestMessage.setOriUgcType(d);
                        pbPageRequestMessage.setOriUgcVid(e);
                        if (!StringUtils.isNull(f)) {
                        }
                        int i22222 = -1;
                        if (pbPageRequestMessage.getPn() != null) {
                        }
                        i22222 = 0;
                        pbPageRequestMessage.setAfterAdThreadCount(i22222);
                        pbPageRequestMessage.setImmersionVideoCommentSource(0);
                        pbPageRequestMessage.setReqFoldComment(false);
                        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", a);
                        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                        pbPageRequestMessage.setFromPbOptimize(true);
                        lt7.a().f(true);
                        Class.forName("com.baidu.tieba.pb.pb.main.PbActivityStatic");
                        MessageManager.getInstance().registerListener(D);
                        MessageManager.getInstance().sendMessage(pbPageRequestMessage);
                    }
                    z2 = true;
                    if (!z2) {
                    }
                    if (t) {
                    }
                    o(pbPageRequestMessage);
                    pbPageRequestMessage.setIsFromMark(Boolean.valueOf(t));
                    pbPageRequestMessage.setCacheKey(g());
                    pbPageRequestMessage.setObjParam1(String.valueOf(j));
                    pbPageRequestMessage.setIsSubPostDataReverse(false);
                    pbPageRequestMessage.setFromSmartFrs(!A ? 1 : 0);
                    if (!UtilHelper.isUgcThreadType(d)) {
                    }
                    pbPageRequestMessage.setNeedRepostRecommendForum(n);
                    if (j != 7) {
                    }
                    if (j != 7) {
                    }
                    pbPageRequestMessage.setSourceType(1);
                    pbPageRequestMessage.setOriUgcNid(b);
                    pbPageRequestMessage.setOriUgcTid(c);
                    pbPageRequestMessage.setOriUgcType(d);
                    pbPageRequestMessage.setOriUgcVid(e);
                    if (!StringUtils.isNull(f)) {
                    }
                    int i222222 = -1;
                    if (pbPageRequestMessage.getPn() != null) {
                    }
                    i222222 = 0;
                    pbPageRequestMessage.setAfterAdThreadCount(i222222);
                    pbPageRequestMessage.setImmersionVideoCommentSource(0);
                    pbPageRequestMessage.setReqFoldComment(false);
                    pbPageRequestMessage.getHttpMessage().addHeader("thread_id", a);
                    pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                    pbPageRequestMessage.setFromPbOptimize(true);
                    lt7.a().f(true);
                    Class.forName("com.baidu.tieba.pb.pb.main.PbActivityStatic");
                    MessageManager.getInstance().registerListener(D);
                    MessageManager.getInstance().sendMessage(pbPageRequestMessage);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void m(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, intent) == null) || intent == null) {
            return;
        }
        j(intent);
        l();
    }

    public static void n(String[] strArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65550, null, strArr) == null) && k(strArr) == 0) {
            j(C.getIntent());
            l();
        }
    }

    public static void o(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, null, pbPageRequestMessage) == null) || TextUtils.isEmpty(w) || ma8.q().b() == null) {
            return;
        }
        pbPageRequestMessage.setRefreshCount(ma8.q().b().d(w, true) + 1);
        pbPageRequestMessage.setLoadCount(ma8.q().b().e(w, true));
    }
}
