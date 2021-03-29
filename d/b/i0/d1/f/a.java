package d.b.i0.d1.f;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import d.b.h0.a0.a;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, String> f53640a;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        f53640a = hashMap;
        hashMap.put("#(呵呵)", "image_emoticon");
        f53640a.put("#(哈哈)", "image_emoticon2");
        f53640a.put("#(吐舌)", "image_emoticon3");
        f53640a.put("#(啊)", "image_emoticon4");
        f53640a.put("#(啊?)", "image_emoticon4");
        f53640a.put("#(酷)", "image_emoticon5");
        f53640a.put("#(怒)", "image_emoticon6");
        f53640a.put("#(开心)", "image_emoticon7");
        f53640a.put("#(汗)", "image_emoticon8");
        f53640a.put("#(泪)", "image_emoticon9");
        f53640a.put("#(黑线)", "image_emoticon10");
        f53640a.put("#(鄙视)", "image_emoticon11");
        f53640a.put("#(不高兴)", "image_emoticon12");
        f53640a.put("#(真棒)", "image_emoticon13");
        f53640a.put("#(钱)", "image_emoticon14");
        f53640a.put("#(疑问)", "image_emoticon15");
        f53640a.put("#(阴险)", "image_emoticon16");
        f53640a.put("#(吐)", "image_emoticon17");
        f53640a.put("#(咦)", "image_emoticon18");
        f53640a.put("#(咦?)", "image_emoticon18");
        f53640a.put("#(委屈)", "image_emoticon19");
        f53640a.put("#(花心)", "image_emoticon20");
        f53640a.put("#(呼~)", "image_emoticon21");
        f53640a.put("#(笑眼)", "image_emoticon22");
        f53640a.put("#(冷)", "image_emoticon23");
        f53640a.put("#(太开心)", "image_emoticon24");
        f53640a.put("#(滑稽)", "image_emoticon25");
        f53640a.put("#(勉强)", "image_emoticon26");
        f53640a.put("#(狂汗)", "image_emoticon27");
        f53640a.put("#(乖)", "image_emoticon28");
        f53640a.put("#(睡觉)", "image_emoticon29");
        f53640a.put("#(惊哭)", "image_emoticon30");
        f53640a.put("#(升起)", "image_emoticon31");
        f53640a.put("#(惊讶)", "image_emoticon32");
        f53640a.put("#(喷)", "image_emoticon33");
        f53640a.put("#(爱心)", "image_emoticon34");
        f53640a.put("#(心碎)", "image_emoticon35");
        f53640a.put("#(玫瑰)", "image_emoticon36");
        f53640a.put("#(礼物)", "image_emoticon37");
        f53640a.put("#(彩虹)", "image_emoticon38");
        f53640a.put("#(星星月亮)", "image_emoticon39");
        f53640a.put("#(太阳)", "image_emoticon40");
        f53640a.put("#(钱币)", "image_emoticon41");
        f53640a.put("#(灯泡)", "image_emoticon42");
        f53640a.put("#(茶杯)", "image_emoticon43");
        f53640a.put("#(蛋糕)", "image_emoticon44");
        f53640a.put("#(音乐)", "image_emoticon45");
        f53640a.put("#(haha)", "image_emoticon46");
        f53640a.put("#(胜利)", "image_emoticon47");
        f53640a.put("#(大拇指)", "image_emoticon48");
        f53640a.put("#(弱)", "image_emoticon49");
        f53640a.put("#(OK)", "image_emoticon50");
        f53640a.put("#(哼)", "image_emoticon61");
        f53640a.put("#(吃瓜)", "image_emoticon62");
        f53640a.put("#(扔便便)", "image_emoticon63");
        f53640a.put("#(惊恐)", "image_emoticon64");
        f53640a.put("#(哎呦)", "image_emoticon65");
        f53640a.put("#(小乖)", "image_emoticon66");
        f53640a.put("#(捂嘴笑)", "image_emoticon67");
        f53640a.put("#(你懂的)", "image_emoticon68");
        f53640a.put("#(what)", "image_emoticon69");
        f53640a.put("#(酸爽)", "image_emoticon70");
        f53640a.put("#(呀咩爹)", "image_emoticon71");
        f53640a.put("#(笑尿)", "image_emoticon72");
        f53640a.put("#(挖鼻)", "image_emoticon73");
        f53640a.put("#(犀利)", "image_emoticon74");
        f53640a.put("#(小红脸)", "image_emoticon75");
        f53640a.put("#(懒得理)", "image_emoticon76");
        f53640a.put("#(沙发)", "image_emoticon77");
        f53640a.put("#(手纸)", "image_emoticon78");
        f53640a.put("#(香蕉)", "image_emoticon79");
        f53640a.put("#(便便)", "image_emoticon80");
        f53640a.put("#(药丸)", "image_emoticon81");
        f53640a.put("#(红领巾)", "image_emoticon82");
        f53640a.put("#(蜡烛)", "image_emoticon83");
        f53640a.put("#(三道杠)", "image_emoticon84");
        f53640a.put("#(赖皮)", "ali_001");
        f53640a.put("#(感动)", "ali_002");
        f53640a.put("#(十分惊讶)", "ali_003");
        f53640a.put("#(怒气)", "ali_004");
        f53640a.put("#(哭泣)", "ali_005");
        f53640a.put("#(吃惊)", "ali_006");
        f53640a.put("#(嘲弄)", "ali_007");
        f53640a.put("#(飘过)", "ali_008");
        f53640a.put("#(转圈哭)", "ali_009");
        f53640a.put("#(神经病)", "ali_010");
        f53640a.put("#(揪耳朵)", "ali_011");
        f53640a.put("#(惊汗)", "ali_012");
        f53640a.put("#(隐身)", "ali_013");
        f53640a.put("#(不要嘛)", "ali_014");
        f53640a.put("#(遁)", "ali_015");
        f53640a.put("#(不公平)", "ali_016");
        f53640a.put("#(爬来了)", "ali_017");
        f53640a.put("#(蛋花哭)", "ali_018");
        f53640a.put("#(温暖)", "ali_019");
        f53640a.put("#(点头)", "ali_020");
        f53640a.put("#(撒钱)", "ali_021");
        f53640a.put("#(献花)", "ali_022");
        f53640a.put("#(寒)", "ali_023");
        f53640a.put("#(傻笑)", "ali_024");
        f53640a.put("#(扭扭)", "ali_025");
        f53640a.put("#(疯)", "ali_026");
        f53640a.put("#(抓狂)", "ali_027");
        f53640a.put("#(抓)", "ali_028");
        f53640a.put("#(蜷)", "ali_029");
        f53640a.put("#(挠墙)", "ali_030");
        f53640a.put("#(狂笑)", "ali_031");
        f53640a.put("#(抱枕)", "ali_032");
        f53640a.put("#(吼叫)", "ali_033");
        f53640a.put("#(嚷)", "ali_034");
        f53640a.put("#(唠叨)", "ali_035");
        f53640a.put("#(捏脸)", "ali_036");
        f53640a.put("#(爆笑)", "ali_037");
        f53640a.put("#(郁闷)", "ali_038");
        f53640a.put("#(潜水)", "ali_039");
        f53640a.put("#(十分开心)", "ali_040");
        f53640a.put("#(冷笑话)", "ali_041");
        f53640a.put("#(顶！)", "ali_042");
        f53640a.put("#(潜)", "ali_043");
        f53640a.put("#(画圈圈)", "ali_044");
        f53640a.put("#(玩电脑)", "ali_045");
        f53640a.put("#(狂吐)", "ali_046");
        f53640a.put("#(哭着跑)", "ali_047");
        f53640a.put("#(阿狸侠)", "ali_048");
        f53640a.put("#(冷死了)", "ali_049");
        f53640a.put("#(惆怅~)", "ali_050");
        f53640a.put("#(摸头)", "ali_051");
        f53640a.put("#(蹭)", "ali_052");
        f53640a.put("#(打滚)", "ali_053");
        f53640a.put("#(叩拜)", "ali_054");
        f53640a.put("#(摸)", "ali_055");
        f53640a.put("#(数钱)", "ali_056");
        f53640a.put("#(拖走)", "ali_057");
        f53640a.put("#(热)", "ali_058");
        f53640a.put("#(加1)", "ali_059");
        f53640a.put("#(压力)", "ali_060");
        f53640a.put("#(表逼我)", "ali_061");
        f53640a.put("#(人呢)", "ali_062");
        f53640a.put("#(摇晃)", "ali_063");
        f53640a.put("#(打地鼠)", "ali_064");
        f53640a.put("#(这个屌)", "ali_065");
        f53640a.put("#(恐慌)", "ali_066");
        f53640a.put("#(晕乎乎)", "ali_067");
        f53640a.put("#(浮云)", "ali_068");
        f53640a.put("#(给力)", "ali_069");
        f53640a.put("#(杯具了)", "ali_070");
        f53640a.put("#(焦糖舞)", "yz_001");
        f53640a.put("#(翻滚)", "yz_002");
        f53640a.put("#(拍屁股做鬼脸)", "yz_003");
        f53640a.put("#(不)", "yz_004");
        f53640a.put("#(河蟹掉啦)", "yz_005");
        f53640a.put("#(哦耶)", "yz_006");
        f53640a.put("#(我倒)", "yz_007");
        f53640a.put("#(投降)", "yz_008");
        f53640a.put("#(微笑)", "b01");
        f53640a.put("#(帅哥)", "b02");
        f53640a.put("#(美女)", "b03");
        f53640a.put("#(老大)", "b04");
        f53640a.put("#(哈哈哈)", "b05");
        f53640a.put("#(奸笑)", "b06");
        f53640a.put("#(傻乐)", "b07");
        f53640a.put("#(飞吻)", "b08");
        f53640a.put("#(害羞)", "b09");
        f53640a.put("#(花痴)", "b10");
        f53640a.put("#(憧憬)", "b11");
        f53640a.put("#(你牛)", "b12");
        f53640a.put("#(鼓掌)", "b13");
        f53640a.put("#(可爱)", "b14");
        f53640a.put("#(太委屈)", "b15");
        f53640a.put("#(大哭)", "b16");
        f53640a.put("#(泪奔)", "b17");
        f53640a.put("#(寻死)", "b18");
        f53640a.put("#(非常惊讶)", "b19");
        f53640a.put("#(表示疑问)", "b20");
        f53640a.put("#(暗中观察)", "image_emoticon85");
        f53640a.put("#(吃瓜)", "image_emoticon86");
        f53640a.put("#(喝酒)", "image_emoticon87");
        f53640a.put("#(嘿嘿嘿)", "image_emoticon88");
        f53640a.put("#(噗)", "image_emoticon89");
        f53640a.put("#(困成狗)", "image_emoticon90");
        f53640a.put("#(微微一笑)", "image_emoticon91");
        f53640a.put("#(托腮)", "image_emoticon92");
        f53640a.put("#(摊手)", "image_emoticon93");
        f53640a.put("#(柯基暗中观察)", "image_emoticon94");
        f53640a.put("#(欢呼)", "image_emoticon95");
        f53640a.put("#(炸药)", "image_emoticon96");
        f53640a.put("#(突然兴奋)", "image_emoticon97");
        f53640a.put("#(紧张)", "image_emoticon98");
        f53640a.put("#(黑头瞪眼)", "image_emoticon99");
        f53640a.put("#(黑头高兴)", "image_emoticon100");
        f53640a.put("#(奥特曼)", "image_emoticon125");
        f53640a.put("#(不听)", "image_emoticon126");
        f53640a.put("#(干饭)", "image_emoticon127");
        f53640a.put("#(望远镜)", "image_emoticon128");
        f53640a.put("#(不跟丑人说话)", "image_emoticon101");
        f53640a.put("#(么么哒)", "image_emoticon102");
        f53640a.put("#(亲亲才能起来)", "image_emoticon103");
        f53640a.put("#(伦家只是宝宝)", "image_emoticon104");
        f53640a.put("#(你是我的人)", "image_emoticon105");
        f53640a.put("#(假装看不见)", "image_emoticon106");
        f53640a.put("#(单身等撩)", "image_emoticon107");
        f53640a.put("#(吓到宝宝了)", "image_emoticon108");
        f53640a.put("#(哈哈哈)", "image_emoticon109");
        f53640a.put("#(嗯嗯)", "image_emoticon110");
        f53640a.put("#(好幸福)", "image_emoticon111");
        f53640a.put("#(宝宝不开心)", "image_emoticon112");
        f53640a.put("#(小姐姐别走)", "image_emoticon113");
        f53640a.put("#(小姐姐在吗)", "image_emoticon114");
        f53640a.put("#(小姐姐来啦)", "image_emoticon115");
        f53640a.put("#(小姐姐来玩呀)", "image_emoticon116");
        f53640a.put("#(我养你)", "image_emoticon117");
        f53640a.put("#(我是不会骗你的)", "image_emoticon118");
        f53640a.put("#(扎心了)", "image_emoticon119");
        f53640a.put("#(无聊)", "image_emoticon120");
        f53640a.put("#(月亮代表我的心)", "image_emoticon121");
        f53640a.put("#(来追我呀)", "image_emoticon122");
        f53640a.put("#(爱你的形状)", "image_emoticon123");
        f53640a.put("#(白眼)", "image_emoticon124");
        f53640a.put("#(熊-88)", "bearchildren_01");
        f53640a.put("#(熊-HI)", "bearchildren_02");
        f53640a.put("#(熊-人艰不拆)", "bearchildren_03");
        f53640a.put("#(熊-啥)", "bearchildren_04");
        f53640a.put("#(熊-大哭)", "bearchildren_05");
        f53640a.put("#(熊-失落)", "bearchildren_06");
        f53640a.put("#(熊-怒赞)", "bearchildren_07");
        f53640a.put("#(熊-惊呆了)", "bearchildren_08");
        f53640a.put("#(熊-李菊福)", "bearchildren_09");
        f53640a.put("#(熊-来信砍)", "bearchildren_10");
        f53640a.put("#(熊-欢迎入群)", "bearchildren_11");
        f53640a.put("#(熊-牛闪闪)", "bearchildren_12");
        f53640a.put("#(熊-生日快乐)", "bearchildren_13");
        f53640a.put("#(熊-石化)", "bearchildren_14");
        f53640a.put("#(熊-羞羞哒)", "bearchildren_15");
        f53640a.put("#(熊-肥皂必杀)", "bearchildren_16");
        f53640a.put("#(熊-谢谢你)", "bearchildren_17");
        f53640a.put("#(熊-跳舞)", "bearchildren_18");
        f53640a.put("#(熊-霹雳舞)", "bearchildren_19");
        f53640a.put("#(熊-鼓掌)", "bearchildren_20");
    }

    public static SpannableString a(ArrayList<d.b.h0.b1.m.d> arrayList, String str, String str2) {
        int b2 = TbFaceManager.e().b(str);
        if (b2 != 0) {
            SpannableString spannableString = new SpannableString(str2 + " ");
            d.b.h0.b1.m.d dVar = new d.b.h0.b1.m.d(TbadkCoreApplication.getInst(), b2);
            if (arrayList != null) {
                arrayList.add(dVar);
            }
            a.C1043a c2 = TbFaceManager.e().c(str);
            if (c2 != null) {
                int a2 = (int) (c2.a() * 0.5d);
                dVar.setBounds(new Rect(0, 0, a2, a2));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
            return spannableString;
        }
        return null;
    }

    public static String b(String str) {
        return f53640a.get(str);
    }

    public static SpannableString c(Context context, String str) {
        if (str == null) {
            return null;
        }
        return UrlManager.findAllWebUrl(context, str);
    }

    public static ArrayList<TbRichTextData> d(Context context, String str, int i) {
        int i2;
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
                    String b2 = b(str3);
                    if (TextUtils.isEmpty(b2)) {
                        str2 = str2 + str3;
                    } else {
                        if (!TextUtils.isEmpty(str2)) {
                            if (i == 1) {
                                tbRichTextData.s(str2);
                            } else {
                                SpannableString c2 = c(context, str2);
                                if (c2 != null) {
                                    tbRichTextData.s(c2);
                                }
                            }
                            str2 = "";
                        }
                        SpannableString a2 = a(tbRichTextData.t(), b2, str3);
                        if (a2 != null) {
                            tbRichTextData.s(a2);
                        }
                    }
                } else {
                    str2 = str2 + charAt;
                }
                i3++;
            }
            if (!TextUtils.isEmpty(str2)) {
                if (i == 1) {
                    tbRichTextData.s(str2);
                } else {
                    SpannableString c3 = c(context, str2);
                    if (c3 != null) {
                        tbRichTextData.s(c3);
                    }
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
