package com.repackage;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.w35;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class z37 {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, String> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755162861, "Lcom/repackage/z37;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755162861, "Lcom/repackage/z37;");
                return;
            }
        }
        HashMap<String, String> hashMap = new HashMap<>();
        a = hashMap;
        hashMap.put("#(呵呵)", "image_emoticon");
        a.put("#(哈哈)", "image_emoticon2");
        a.put("#(吐舌)", "image_emoticon3");
        a.put("#(啊)", "image_emoticon4");
        a.put("#(啊?)", "image_emoticon4");
        a.put("#(酷)", "image_emoticon5");
        a.put("#(怒)", "image_emoticon6");
        a.put("#(开心)", "image_emoticon7");
        a.put("#(汗)", "image_emoticon8");
        a.put("#(泪)", "image_emoticon9");
        a.put("#(黑线)", "image_emoticon10");
        a.put("#(鄙视)", "image_emoticon11");
        a.put("#(不高兴)", "image_emoticon12");
        a.put("#(真棒)", "image_emoticon13");
        a.put("#(钱)", "image_emoticon14");
        a.put("#(疑问)", "image_emoticon15");
        a.put("#(阴险)", "image_emoticon16");
        a.put("#(吐)", "image_emoticon17");
        a.put("#(咦)", "image_emoticon18");
        a.put("#(咦?)", "image_emoticon18");
        a.put("#(委屈)", "image_emoticon19");
        a.put("#(花心)", "image_emoticon20");
        a.put("#(呼~)", "image_emoticon21");
        a.put("#(笑眼)", "image_emoticon22");
        a.put("#(冷)", "image_emoticon23");
        a.put("#(太开心)", "image_emoticon24");
        a.put("#(滑稽)", "image_emoticon25");
        a.put("#(勉强)", "image_emoticon26");
        a.put("#(狂汗)", "image_emoticon27");
        a.put("#(乖)", "image_emoticon28");
        a.put("#(睡觉)", "image_emoticon29");
        a.put("#(惊哭)", "image_emoticon30");
        a.put("#(升起)", "image_emoticon31");
        a.put("#(惊讶)", "image_emoticon32");
        a.put("#(喷)", "image_emoticon33");
        a.put("#(爱心)", "image_emoticon34");
        a.put("#(心碎)", "image_emoticon35");
        a.put("#(玫瑰)", "image_emoticon36");
        a.put("#(礼物)", "image_emoticon37");
        a.put("#(彩虹)", "image_emoticon38");
        a.put("#(星星月亮)", "image_emoticon39");
        a.put("#(太阳)", "image_emoticon40");
        a.put("#(钱币)", "image_emoticon41");
        a.put("#(灯泡)", "image_emoticon42");
        a.put("#(茶杯)", "image_emoticon43");
        a.put("#(蛋糕)", "image_emoticon44");
        a.put("#(音乐)", "image_emoticon45");
        a.put("#(haha)", "image_emoticon46");
        a.put("#(胜利)", "image_emoticon47");
        a.put("#(大拇指)", "image_emoticon48");
        a.put("#(弱)", "image_emoticon49");
        a.put("#(OK)", "image_emoticon50");
        a.put("#(哼)", "image_emoticon61");
        a.put("#(吃瓜)", "image_emoticon62");
        a.put("#(扔便便)", "image_emoticon63");
        a.put("#(惊恐)", "image_emoticon64");
        a.put("#(哎呦)", "image_emoticon65");
        a.put("#(小乖)", "image_emoticon66");
        a.put("#(捂嘴笑)", "image_emoticon67");
        a.put("#(你懂的)", "image_emoticon68");
        a.put("#(what)", "image_emoticon69");
        a.put("#(酸爽)", "image_emoticon70");
        a.put("#(呀咩爹)", "image_emoticon71");
        a.put("#(笑尿)", "image_emoticon72");
        a.put("#(挖鼻)", "image_emoticon73");
        a.put("#(犀利)", "image_emoticon74");
        a.put("#(小红脸)", "image_emoticon75");
        a.put("#(懒得理)", "image_emoticon76");
        a.put("#(沙发)", "image_emoticon77");
        a.put("#(手纸)", "image_emoticon78");
        a.put("#(香蕉)", "image_emoticon79");
        a.put("#(便便)", "image_emoticon80");
        a.put("#(药丸)", "image_emoticon81");
        a.put("#(红领巾)", "image_emoticon82");
        a.put("#(蜡烛)", "image_emoticon83");
        a.put("#(三道杠)", "image_emoticon84");
        a.put("#(赖皮)", "ali_001");
        a.put("#(感动)", "ali_002");
        a.put("#(十分惊讶)", "ali_003");
        a.put("#(怒气)", "ali_004");
        a.put("#(哭泣)", "ali_005");
        a.put("#(吃惊)", "ali_006");
        a.put("#(嘲弄)", "ali_007");
        a.put("#(飘过)", "ali_008");
        a.put("#(转圈哭)", "ali_009");
        a.put("#(神经病)", "ali_010");
        a.put("#(揪耳朵)", "ali_011");
        a.put("#(惊汗)", "ali_012");
        a.put("#(隐身)", "ali_013");
        a.put("#(不要嘛)", "ali_014");
        a.put("#(遁)", "ali_015");
        a.put("#(不公平)", "ali_016");
        a.put("#(爬来了)", "ali_017");
        a.put("#(蛋花哭)", "ali_018");
        a.put("#(温暖)", "ali_019");
        a.put("#(点头)", "ali_020");
        a.put("#(撒钱)", "ali_021");
        a.put("#(献花)", "ali_022");
        a.put("#(寒)", "ali_023");
        a.put("#(傻笑)", "ali_024");
        a.put("#(扭扭)", "ali_025");
        a.put("#(疯)", "ali_026");
        a.put("#(抓狂)", "ali_027");
        a.put("#(抓)", "ali_028");
        a.put("#(蜷)", "ali_029");
        a.put("#(挠墙)", "ali_030");
        a.put("#(狂笑)", "ali_031");
        a.put("#(抱枕)", "ali_032");
        a.put("#(吼叫)", "ali_033");
        a.put("#(嚷)", "ali_034");
        a.put("#(唠叨)", "ali_035");
        a.put("#(捏脸)", "ali_036");
        a.put("#(爆笑)", "ali_037");
        a.put("#(郁闷)", "ali_038");
        a.put("#(潜水)", "ali_039");
        a.put("#(十分开心)", "ali_040");
        a.put("#(冷笑话)", "ali_041");
        a.put("#(顶！)", "ali_042");
        a.put("#(潜)", "ali_043");
        a.put("#(画圈圈)", "ali_044");
        a.put("#(玩电脑)", "ali_045");
        a.put("#(狂吐)", "ali_046");
        a.put("#(哭着跑)", "ali_047");
        a.put("#(阿狸侠)", "ali_048");
        a.put("#(冷死了)", "ali_049");
        a.put("#(惆怅~)", "ali_050");
        a.put("#(摸头)", "ali_051");
        a.put("#(蹭)", "ali_052");
        a.put("#(打滚)", "ali_053");
        a.put("#(叩拜)", "ali_054");
        a.put("#(摸)", "ali_055");
        a.put("#(数钱)", "ali_056");
        a.put("#(拖走)", "ali_057");
        a.put("#(热)", "ali_058");
        a.put("#(加1)", "ali_059");
        a.put("#(压力)", "ali_060");
        a.put("#(表逼我)", "ali_061");
        a.put("#(人呢)", "ali_062");
        a.put("#(摇晃)", "ali_063");
        a.put("#(打地鼠)", "ali_064");
        a.put("#(这个屌)", "ali_065");
        a.put("#(恐慌)", "ali_066");
        a.put("#(晕乎乎)", "ali_067");
        a.put("#(浮云)", "ali_068");
        a.put("#(给力)", "ali_069");
        a.put("#(杯具了)", "ali_070");
        a.put("#(焦糖舞)", "yz_001");
        a.put("#(翻滚)", "yz_002");
        a.put("#(拍屁股做鬼脸)", "yz_003");
        a.put("#(不)", "yz_004");
        a.put("#(河蟹掉啦)", "yz_005");
        a.put("#(哦耶)", "yz_006");
        a.put("#(我倒)", "yz_007");
        a.put("#(投降)", "yz_008");
        a.put("#(微笑)", "b01");
        a.put("#(帅哥)", "b02");
        a.put("#(美女)", "b03");
        a.put("#(老大)", "b04");
        a.put("#(哈哈哈)", "b05");
        a.put("#(奸笑)", "b06");
        a.put("#(傻乐)", "b07");
        a.put("#(飞吻)", "b08");
        a.put("#(害羞)", "b09");
        a.put("#(花痴)", "b10");
        a.put("#(憧憬)", "b11");
        a.put("#(你牛)", "b12");
        a.put("#(鼓掌)", "b13");
        a.put("#(可爱)", "b14");
        a.put("#(太委屈)", "b15");
        a.put("#(大哭)", "b16");
        a.put("#(泪奔)", "b17");
        a.put("#(寻死)", "b18");
        a.put("#(非常惊讶)", "b19");
        a.put("#(表示疑问)", "b20");
        a.put("#(暗中观察)", "image_emoticon85");
        a.put("#(吃瓜)", "image_emoticon86");
        a.put("#(喝酒)", "image_emoticon87");
        a.put("#(嘿嘿嘿)", "image_emoticon88");
        a.put("#(噗)", "image_emoticon89");
        a.put("#(困成狗)", "image_emoticon90");
        a.put("#(微微一笑)", "image_emoticon91");
        a.put("#(托腮)", "image_emoticon92");
        a.put("#(摊手)", "image_emoticon93");
        a.put("#(柯基暗中观察)", "image_emoticon94");
        a.put("#(欢呼)", "image_emoticon95");
        a.put("#(炸药)", "image_emoticon96");
        a.put("#(突然兴奋)", "image_emoticon97");
        a.put("#(紧张)", "image_emoticon98");
        a.put("#(黑头瞪眼)", "image_emoticon99");
        a.put("#(黑头高兴)", "image_emoticon100");
        a.put("#(奥特曼)", "image_emoticon125");
        a.put("#(不听)", "image_emoticon126");
        a.put("#(干饭)", "image_emoticon127");
        a.put("#(望远镜)", "image_emoticon128");
        a.put("#(菜狗)", "image_emoticon129");
        a.put("#(老虎)", "image_emoticon130");
        a.put("#(嗷呜)", "image_emoticon131");
        a.put("#(烟花)", "image_emoticon132");
        a.put("#(香槟)", "image_emoticon133");
        a.put("#(不跟丑人说话)", "image_emoticon101");
        a.put("#(么么哒)", "image_emoticon102");
        a.put("#(亲亲才能起来)", "image_emoticon103");
        a.put("#(伦家只是宝宝)", "image_emoticon104");
        a.put("#(你是我的人)", "image_emoticon105");
        a.put("#(假装看不见)", "image_emoticon106");
        a.put("#(单身等撩)", "image_emoticon107");
        a.put("#(吓到宝宝了)", "image_emoticon108");
        a.put("#(哈哈哈)", "image_emoticon109");
        a.put("#(嗯嗯)", "image_emoticon110");
        a.put("#(好幸福)", "image_emoticon111");
        a.put("#(宝宝不开心)", "image_emoticon112");
        a.put("#(小姐姐别走)", "image_emoticon113");
        a.put("#(小姐姐在吗)", "image_emoticon114");
        a.put("#(小姐姐来啦)", "image_emoticon115");
        a.put("#(小姐姐来玩呀)", "image_emoticon116");
        a.put("#(我养你)", "image_emoticon117");
        a.put("#(我是不会骗你的)", "image_emoticon118");
        a.put("#(扎心了)", "image_emoticon119");
        a.put("#(无聊)", "image_emoticon120");
        a.put("#(月亮代表我的心)", "image_emoticon121");
        a.put("#(来追我呀)", "image_emoticon122");
        a.put("#(爱你的形状)", "image_emoticon123");
        a.put("#(白眼)", "image_emoticon124");
        a.put("#(熊-88)", "bearchildren_01");
        a.put("#(熊-HI)", "bearchildren_02");
        a.put("#(熊-人艰不拆)", "bearchildren_03");
        a.put("#(熊-啥)", "bearchildren_04");
        a.put("#(熊-大哭)", "bearchildren_05");
        a.put("#(熊-失落)", "bearchildren_06");
        a.put("#(熊-怒赞)", "bearchildren_07");
        a.put("#(熊-惊呆了)", "bearchildren_08");
        a.put("#(熊-李菊福)", "bearchildren_09");
        a.put("#(熊-来信砍)", "bearchildren_10");
        a.put("#(熊-欢迎入群)", "bearchildren_11");
        a.put("#(熊-牛闪闪)", "bearchildren_12");
        a.put("#(熊-生日快乐)", "bearchildren_13");
        a.put("#(熊-石化)", "bearchildren_14");
        a.put("#(熊-羞羞哒)", "bearchildren_15");
        a.put("#(熊-肥皂必杀)", "bearchildren_16");
        a.put("#(熊-谢谢你)", "bearchildren_17");
        a.put("#(熊-跳舞)", "bearchildren_18");
        a.put("#(熊-霹雳舞)", "bearchildren_19");
        a.put("#(熊-鼓掌)", "bearchildren_20");
    }

    public static SpannableString a(ArrayList<wf5> arrayList, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, arrayList, str, str2)) == null) {
            int b = TbFaceManager.e().b(str);
            if (b != 0) {
                SpannableString spannableString = new SpannableString(str2 + " ");
                wf5 wf5Var = new wf5(TbadkCoreApplication.getInst(), b);
                if (arrayList != null) {
                    arrayList.add(wf5Var);
                }
                w35.a c = TbFaceManager.e().c(str);
                if (c != null) {
                    int a2 = (int) (c.a() * 0.5d);
                    wf5Var.setBounds(new Rect(0, 0, a2, a2));
                } else {
                    wf5Var.setBounds(new Rect(0, 0, 0, 0));
                }
                spannableString.setSpan(new g86(wf5Var, 1), 0, str2.length(), 33);
                return spannableString;
            }
            return null;
        }
        return (SpannableString) invokeLLL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? a.get(str) : (String) invokeL.objValue;
    }

    public static SpannableString c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str == null) {
                return null;
            }
            return UrlManager.findAllWebUrl(str);
        }
        return (SpannableString) invokeL.objValue;
    }

    public static ArrayList<TbRichTextData> d(String str, int i) {
        InterceptResult invokeLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i)) == null) {
            ArrayList<TbRichTextData> arrayList = new ArrayList<>();
            if (TextUtils.isEmpty(str)) {
                return arrayList;
            }
            TbRichTextData tbRichTextData = new TbRichTextData(1);
            arrayList.add(tbRichTextData);
            try {
                int length = str.length();
                int i3 = 0;
                String str2 = "";
                while (i3 < str.length()) {
                    char charAt = str.charAt(i3);
                    if (charAt == '#' && i3 < length - 1 && str.charAt(i3 + 1) == '(') {
                        String str3 = SmallTailInfo.EMOTION_PREFIX;
                        i3 += 2;
                        while (i3 < length) {
                            char charAt2 = str.charAt(i3);
                            str3 = str3 + charAt2;
                            if (charAt2 != ')' && ((i2 = i3 + 1) >= length || str.charAt(i2) != '#')) {
                                i3 = i2;
                            }
                        }
                        String b = b(str3);
                        if (TextUtils.isEmpty(b)) {
                            str2 = str2 + str3;
                        } else {
                            if (!TextUtils.isEmpty(str2)) {
                                if (i == 1) {
                                    tbRichTextData.z(str2);
                                } else {
                                    SpannableString c = c(str2);
                                    if (c != null) {
                                        tbRichTextData.z(c);
                                    }
                                }
                                str2 = "";
                            }
                            SpannableString a2 = a(tbRichTextData.A(), b, str3);
                            if (a2 != null) {
                                tbRichTextData.z(a2);
                            }
                        }
                    } else {
                        str2 = str2 + charAt;
                    }
                    i3++;
                }
                if (!TextUtils.isEmpty(str2)) {
                    if (i == 1) {
                        tbRichTextData.z(str2);
                    } else {
                        SpannableString c2 = c(str2);
                        if (c2 != null) {
                            tbRichTextData.z(c2);
                        }
                    }
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }
        return (ArrayList) invokeLI.objValue;
    }
}
