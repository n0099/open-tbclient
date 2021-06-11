package d.a.m0.w.p;

import android.content.Context;
import com.baidu.tieba.R;
import d.a.m0.a0.a;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements d.a.m0.a0.a {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, Integer> f54533a = new HashMap<>(200);

    /* renamed from: b  reason: collision with root package name */
    public static final ArrayList<Integer> f54534b = new ArrayList<>(180);

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, Integer> f54535c = new HashMap<>(180);

    /* renamed from: d  reason: collision with root package name */
    public static final HashMap<String, String> f54536d;

    static {
        HashMap<String, String> hashMap = new HashMap<>(180);
        f54536d = hashMap;
        hashMap.put("image_emoticon", "呵呵");
        f54536d.put("image_emoticon2", "哈哈");
        f54536d.put("image_emoticon3", "吐舌");
        f54536d.put("image_emoticon4", "啊");
        f54536d.put("image_emoticon5", "酷");
        f54536d.put("image_emoticon6", "怒");
        f54536d.put("image_emoticon7", "开心");
        f54536d.put("image_emoticon8", "汗");
        f54536d.put("image_emoticon9", "泪");
        f54536d.put("image_emoticon10", "黑线");
        f54536d.put("image_emoticon11", "鄙视");
        f54536d.put("image_emoticon12", "不高兴");
        f54536d.put("image_emoticon13", "真棒");
        f54536d.put("image_emoticon14", "钱");
        f54536d.put("image_emoticon15", "疑问");
        f54536d.put("image_emoticon16", "阴险");
        f54536d.put("image_emoticon17", "吐");
        f54536d.put("image_emoticon18", "咦");
        f54536d.put("image_emoticon19", "委屈");
        f54536d.put("image_emoticon20", "花心");
        f54536d.put("image_emoticon21", "呼~");
        f54536d.put("image_emoticon22", "笑眼");
        f54536d.put("image_emoticon23", "冷");
        f54536d.put("image_emoticon24", "太开心");
        f54536d.put("image_emoticon25", "滑稽");
        f54536d.put("image_emoticon26", "勉强");
        f54536d.put("image_emoticon27", "狂汗");
        f54536d.put("image_emoticon28", "乖");
        f54536d.put("image_emoticon29", "睡觉");
        f54536d.put("image_emoticon30", "惊哭");
        f54536d.put("image_emoticon31", "生气");
        f54536d.put("image_emoticon32", "惊讶");
        f54536d.put("image_emoticon33", "喷");
        f54536d.put("image_emoticon34", "爱心");
        f54536d.put("image_emoticon35", "心碎");
        f54536d.put("image_emoticon36", "玫瑰");
        f54536d.put("image_emoticon37", "礼物");
        f54536d.put("image_emoticon38", "彩虹");
        f54536d.put("image_emoticon39", "星星月亮");
        f54536d.put("image_emoticon40", "太阳");
        f54536d.put("image_emoticon41", "钱币");
        f54536d.put("image_emoticon42", "灯泡");
        f54536d.put("image_emoticon43", "茶杯");
        f54536d.put("image_emoticon44", "蛋糕");
        f54536d.put("image_emoticon45", "音乐");
        f54536d.put("image_emoticon46", "haha");
        f54536d.put("image_emoticon47", "胜利");
        f54536d.put("image_emoticon48", "大拇指");
        f54536d.put("image_emoticon49", "弱");
        f54536d.put("image_emoticon50", "OK");
        f54536d.put("image_emoticon61", "哼");
        f54536d.put("image_emoticon62", "吃瓜");
        f54536d.put("image_emoticon63", "扔便便");
        f54536d.put("image_emoticon64", "惊恐");
        f54536d.put("image_emoticon65", "哎呦");
        f54536d.put("image_emoticon66", "小乖");
        f54536d.put("image_emoticon67", "捂嘴笑");
        f54536d.put("image_emoticon68", "你懂的");
        f54536d.put("image_emoticon69", "what");
        f54536d.put("image_emoticon70", "酸爽");
        f54536d.put("image_emoticon71", "呀咩爹");
        f54536d.put("image_emoticon72", "笑尿");
        f54536d.put("image_emoticon73", "挖鼻");
        f54536d.put("image_emoticon74", "犀利");
        f54536d.put("image_emoticon75", "小红脸");
        f54536d.put("image_emoticon76", "懒得理");
        f54536d.put("image_emoticon77", "沙发");
        f54536d.put("image_emoticon78", "手纸");
        f54536d.put("image_emoticon79", "香蕉");
        f54536d.put("image_emoticon80", "便便");
        f54536d.put("image_emoticon81", "药丸");
        f54536d.put("image_emoticon82", "红领巾");
        f54536d.put("image_emoticon83", "蜡烛");
        f54536d.put("image_emoticon84", "三道杠");
        f54536d.put("image_emoticon85", "暗中观察");
        f54536d.put("image_emoticon86", "吃瓜");
        f54536d.put("image_emoticon87", "喝酒");
        f54536d.put("image_emoticon88", "嘿嘿嘿");
        f54536d.put("image_emoticon89", "噗");
        f54536d.put("image_emoticon90", "困成狗");
        f54536d.put("image_emoticon91", "微微一笑");
        f54536d.put("image_emoticon92", "托腮");
        f54536d.put("image_emoticon93", "摊手");
        f54536d.put("image_emoticon94", "柯基暗中观察");
        f54536d.put("image_emoticon95", "欢呼");
        f54536d.put("image_emoticon96", "炸药");
        f54536d.put("image_emoticon97", "突然兴奋");
        f54536d.put("image_emoticon98", "紧张");
        f54536d.put("image_emoticon99", "黑头瞪眼");
        f54536d.put("image_emoticon100", "黑头高兴");
        f54536d.put("image_emoticon125", "奥特曼");
        f54536d.put("image_emoticon126", "不听");
        f54536d.put("image_emoticon127", "干饭");
        f54536d.put("image_emoticon128", "望远镜");
        f54536d.put("image_emoticon101", "不跟丑人说话");
        f54536d.put("image_emoticon102", "么么哒");
        f54536d.put("image_emoticon103", "亲亲才能起来");
        f54536d.put("image_emoticon104", "伦家只是宝宝");
        f54536d.put("image_emoticon105", "你是我的人");
        f54536d.put("image_emoticon106", "假装看不见");
        f54536d.put("image_emoticon107", "单身等撩");
        f54536d.put("image_emoticon108", "吓到宝宝了");
        f54536d.put("image_emoticon109", "哈哈哈");
        f54536d.put("image_emoticon110", "嗯嗯");
        f54536d.put("image_emoticon111", "好幸福");
        f54536d.put("image_emoticon112", "宝宝不开心");
        f54536d.put("image_emoticon113", "小姐姐别走");
        f54536d.put("image_emoticon114", "小姐姐在吗");
        f54536d.put("image_emoticon115", "小姐姐来啦");
        f54536d.put("image_emoticon116", "小姐姐来玩呀");
        f54536d.put("image_emoticon117", "我养你");
        f54536d.put("image_emoticon118", "我是不会骗你的");
        f54536d.put("image_emoticon119", "扎心了");
        f54536d.put("image_emoticon120", "无聊");
        f54536d.put("image_emoticon121", "月亮代表我的心");
        f54536d.put("image_emoticon122", "来追我呀");
        f54536d.put("image_emoticon123", "爱你的形状");
        f54536d.put("image_emoticon124", "白眼");
        f54536d.put("ali_001", "赖皮");
        f54536d.put("ali_002", "感动");
        f54536d.put("ali_003", "十分惊讶");
        f54536d.put("ali_004", "怒气");
        f54536d.put("ali_005", "哭泣");
        f54536d.put("ali_006", "吃惊");
        f54536d.put("ali_007", "嘲弄");
        f54536d.put("ali_008", "飘过");
        f54536d.put("ali_009", "转圈哭");
        f54536d.put("ali_010", "神经病");
        f54536d.put("ali_011", "揪耳朵");
        f54536d.put("ali_012", "惊汗");
        f54536d.put("ali_013", "隐身");
        f54536d.put("ali_014", "不要嘛");
        f54536d.put("ali_015", "遁");
        f54536d.put("ali_016", "不公平");
        f54536d.put("ali_017", "爬来了");
        f54536d.put("ali_018", "蛋花哭");
        f54536d.put("ali_019", "温暖");
        f54536d.put("ali_020", "点头");
        f54536d.put("ali_021", "撒钱");
        f54536d.put("ali_022", "献花");
        f54536d.put("ali_023", "寒");
        f54536d.put("ali_024", "傻笑");
        f54536d.put("ali_025", "扭扭");
        f54536d.put("ali_026", "疯");
        f54536d.put("ali_027", "抓狂");
        f54536d.put("ali_028", "抓");
        f54536d.put("ali_029", "蜷");
        f54536d.put("ali_030", "挠墙");
        f54536d.put("ali_031", "狂笑");
        f54536d.put("ali_032", "抱枕");
        f54536d.put("ali_033", "吼叫");
        f54536d.put("ali_034", "嚷");
        f54536d.put("ali_035", "唠叨");
        f54536d.put("ali_036", "捏脸");
        f54536d.put("ali_037", "爆笑");
        f54536d.put("ali_038", "郁闷");
        f54536d.put("ali_039", "潜水");
        f54536d.put("ali_040", "十分开心");
        f54536d.put("ali_041", "冷笑话");
        f54536d.put("ali_042", "顶！");
        f54536d.put("ali_043", "潜");
        f54536d.put("ali_044", "画圈圈");
        f54536d.put("ali_045", "玩电脑");
        f54536d.put("ali_046", "狂吐");
        f54536d.put("ali_047", "哭着跑");
        f54536d.put("ali_048", "阿狸侠");
        f54536d.put("ali_049", "冷死了");
        f54536d.put("ali_050", "惆怅~");
        f54536d.put("ali_051", "摸头");
        f54536d.put("ali_052", "蹭");
        f54536d.put("ali_053", "打滚");
        f54536d.put("ali_054", "叩拜");
        f54536d.put("ali_055", "摸");
        f54536d.put("ali_056", "数钱");
        f54536d.put("ali_057", "拖走");
        f54536d.put("ali_058", "热");
        f54536d.put("ali_059", "加1");
        f54536d.put("ali_060", "压力");
        f54536d.put("ali_061", "表逼我");
        f54536d.put("ali_062", "人呢");
        f54536d.put("ali_063", "摇晃");
        f54536d.put("ali_064", "打地鼠");
        f54536d.put("ali_065", "这个屌");
        f54536d.put("ali_066", "恐慌");
        f54536d.put("ali_067", "晕乎乎");
        f54536d.put("ali_068", "浮云");
        f54536d.put("ali_069", "给力");
        f54536d.put("ali_070", "杯具了");
        f54536d.put("b01", "微笑");
        f54536d.put("b02", "帅哥");
        f54536d.put("b03", "美女");
        f54536d.put("b04", "老大");
        f54536d.put("b05", "哈哈哈");
        f54536d.put("b06", "奸笑");
        f54536d.put("b07", "傻乐");
        f54536d.put("b08", "飞吻");
        f54536d.put("b09", "害羞");
        f54536d.put("b10", "花痴");
        f54536d.put("b11", "憧憬");
        f54536d.put("b12", "你牛");
        f54536d.put("b13", "鼓掌");
        f54536d.put("b14", "可爱");
        f54536d.put("b15", "太委屈");
        f54536d.put("b16", "大哭");
        f54536d.put("b17", "泪奔");
        f54536d.put("b18", "寻死");
        f54536d.put("b19", "非常惊讶");
        f54536d.put("b20", "表示疑问");
        f54536d.put("yz_001", "焦糖舞");
        f54536d.put("yz_002", "翻滚");
        f54536d.put("yz_003", "拍屁股做鬼脸");
        f54536d.put("yz_004", "不");
        f54536d.put("yz_005", "河蟹掉啦");
        f54536d.put("yz_006", "哦耶");
        f54536d.put("yz_007", "我倒");
        f54536d.put("yz_008", "投降");
        f54536d.put("shoubai_emoji_face_01", "微笑");
        f54536d.put("shoubai_emoji_face_02", "开心");
        f54536d.put("shoubai_emoji_face_03", "期待");
        f54536d.put("shoubai_emoji_face_04", "大笑");
        f54536d.put("shoubai_emoji_face_05", "鼓掌");
        f54536d.put("shoubai_emoji_face_06", "悠闲");
        f54536d.put("shoubai_emoji_face_07", "笑哭");
        f54536d.put("shoubai_emoji_face_08", "不要啊");
        f54536d.put("shoubai_emoji_face_09", "啊");
        f54536d.put("shoubai_emoji_face_10", "哟");
        f54536d.put("shoubai_emoji_face_11", "汗");
        f54536d.put("shoubai_emoji_face_12", "抠鼻");
        f54536d.put("shoubai_emoji_face_13", "哼");
        f54536d.put("shoubai_emoji_face_14", "发怒");
        f54536d.put("shoubai_emoji_face_15", "委屈");
        f54536d.put("shoubai_emoji_face_16", "不高兴");
        f54536d.put("shoubai_emoji_face_17", "囧");
        f54536d.put("shoubai_emoji_face_18", "惊哭");
        f54536d.put("shoubai_emoji_face_19", "大哭");
        f54536d.put("shoubai_emoji_face_20", "流泪");
        f54536d.put("shoubai_emoji_face_21", "害羞");
        f54536d.put("shoubai_emoji_face_22", "亲亲");
        f54536d.put("shoubai_emoji_face_23", "色");
        f54536d.put("shoubai_emoji_face_24", "舔屏");
        f54536d.put("shoubai_emoji_face_25", "得意");
        f54536d.put("shoubai_emoji_face_26", "疑问");
        f54536d.put("shoubai_emoji_face_27", "晕");
        f54536d.put("shoubai_emoji_face_28", "大哈");
        f54536d.put("shoubai_emoji_face_29", "二哈");
        f54536d.put("shoubai_emoji_face_30", "三哈");
        f54536d.put("shoubai_emoji_face_31", "白眼");
        f54536d.put("shoubai_emoji_face_32", "阴险");
        f54536d.put("shoubai_emoji_face_33", "你懂的");
        f54536d.put("shoubai_emoji_face_34", "偷笑");
        f54536d.put("shoubai_emoji_face_35", "睡觉");
        f54536d.put("shoubai_emoji_face_36", "哈欠");
        f54536d.put("shoubai_emoji_face_37", "再见");
        f54536d.put("shoubai_emoji_face_38", "鄙视");
        f54536d.put("shoubai_emoji_face_39", "抓狂");
        f54536d.put("shoubai_emoji_face_40", "咒骂");
        f54536d.put("shoubai_emoji_face_41", "衰");
        f54536d.put("shoubai_emoji_face_42", "骷髅");
        f54536d.put("shoubai_emoji_face_43", "嘘");
        f54536d.put("shoubai_emoji_face_44", "闭嘴");
        f54536d.put("shoubai_emoji_face_45", "呆");
        f54536d.put("shoubai_emoji_face_46", "什么鬼");
        f54536d.put("shoubai_emoji_face_47", "吐");
        f54536d.put("shoubai_emoji_face_48", "已阅");
        f54536d.put("shoubai_emoji_face_49", "同上");
        f54536d.put("shoubai_emoji_face_50", "友军");
        f54536d.put("shoubai_emoji_face_51", "爱钱");
        f54536d.put("shoubai_emoji_face_52", "Freestyle");
        f54536d.put("shoubai_emoji_face_53", "国宝");
        f54536d.put("shoubai_emoji_face_54", "羊驼");
        f54536d.put("shoubai_emoji_face_55", "鲜花");
        f54536d.put("shoubai_emoji_face_56", "中国加油");
        f54536d.put("shoubai_emoji_face_57", "庆祝");
        f54536d.put("shoubai_emoji_face_58", "生日蛋糕");
        f54536d.put("shoubai_emoji_face_59", "MicDrop");
        f54536d.put("shoubai_emoji_face_60", "赞同");
        f54536d.put("shoubai_emoji_face_61", "药丸");
        f54536d.put("shoubai_emoji_face_62", "蜡烛");
        f54536d.put("shoubai_emoji_face_63", "鸡蛋");
        f54536d.put("shoubai_emoji_face_64", "浪");
        f54536d.put("shoubai_emoji_face_65", "打call");
        f54536d.put("shoubai_emoji_face_66", "尬笑");
        f54536d.put("shoubai_emoji_face_67", "坏笑");
        f54536d.put("shoubai_emoji_face_68", "没眼看");
        f54536d.put("shoubai_emoji_face_69", "嘿哈");
        f54536d.put("shoubai_emoji_face_70", "前面的别走");
        f54536d.put("shoubai_emoji_face_71", "滑稽");
        f54536d.put("shoubai_emoji_face_72", "捂脸");
        f54536d.put("shoubai_emoji_face_73", "左捂脸");
        f54536d.put("shoubai_emoji_face_74", "666");
        f54536d.put("shoubai_emoji_face_75", "2018");
        f54536d.put("shoubai_emoji_face_76", "福");
        f54536d.put("shoubai_emoji_face_77", "红包");
        f54536d.put("shoubai_emoji_face_78", "鞭炮");
        f54536d.put("shoubai_emoji_face_79", "财神");
        f54536d.put("shoubai_emoji_face_80", "饺子");
        f54536d.put("shoubai_emoji_face_81", "车票");
        f54536d.put("shoubai_emoji_face_82", "火车");
        f54536d.put("shoubai_emoji_face_83", "飞机");
        f54536d.put("shoubai_emoji_face_84", "射门");
        f54536d.put("shoubai_emoji_face_85", "红牌");
        f54536d.put("shoubai_emoji_face_86", "黄牌");
        f54536d.put("shoubai_emoji_face_87", "哨子");
        f54536d.put("shoubai_emoji_face_88", "比分");
        f54536d.put("shoubai_emoji_face_89", "啤酒");
        f54536d.put("shoubai_emoji_face_90", "足球");
        f54536d.put("shoubai_emoji_face_91", "大力神杯");
        f54536d.put("shoubai_emoji_face_92", "锦鲤");
        f54536d.put("shoubai_emoji_face_93", "2019");
        f54536d.put("shoubai_emoji_face_94", "猪年");
        f54536d.put("shoubai_emoji_face_95", "双手鼓掌");
        f54536d.put("shoubai_emoji_face_96", "火焰");
        f54536d.put("shoubai_emoji_face_97", "祈福");
        f54536d.put("shoubai_emoji_face_98", "亲吻");
        f54536d.put("shoubai_emoji_face_99", "天使");
        f54536d.put("shoubai_emoji_face_100", "樱花");
        f54536d.put("shoubai_emoji_face_101", "加油");
        f54536d.put("shoubai_emoji_face_102", "泡泡枪");
        f54536d.put("shoubai_emoji_face_103", "气球");
        f54536d.put("shoubai_emoji_face_104", "棒棒糖");
        f54536d.put("shoubai_emoji_face_105", "小黄鸭");
        f54536d.put("shoubai_emoji_face_106", "粽子");
        f54536d.put("bearchildren_01", "熊-88");
        f54536d.put("bearchildren_02", "熊-HI");
        f54536d.put("bearchildren_03", "熊-人艰不拆");
        f54536d.put("bearchildren_04", "熊-啥");
        f54536d.put("bearchildren_05", "熊-大哭");
        f54536d.put("bearchildren_06", "熊-失落");
        f54536d.put("bearchildren_07", "熊-怒赞");
        f54536d.put("bearchildren_08", "熊-惊呆了");
        f54536d.put("bearchildren_09", "熊-李菊福");
        f54536d.put("bearchildren_10", "熊-来信砍");
        f54536d.put("bearchildren_11", "熊-欢迎入群");
        f54536d.put("bearchildren_12", "熊-牛闪闪");
        f54536d.put("bearchildren_13", "熊-生日快乐");
        f54536d.put("bearchildren_14", "熊-石化");
        f54536d.put("bearchildren_15", "熊-羞羞哒");
        f54536d.put("bearchildren_16", "熊-肥皂必杀");
        f54536d.put("bearchildren_17", "熊-谢谢你");
        f54536d.put("bearchildren_18", "熊-跳舞");
        f54536d.put("bearchildren_19", "熊-霹雳舞");
        f54536d.put("bearchildren_20", "熊-鼓掌");
    }

    @Override // d.a.m0.a0.a
    public int a() {
        return f54534b.size();
    }

    @Override // d.a.m0.a0.a
    public String b(String str) {
        return f54536d.get(str);
    }

    @Override // d.a.m0.a0.a
    public a.C1155a c(Context context, String str) {
        return null;
    }

    @Override // d.a.m0.a0.a
    public int d(String str) {
        Integer num = f54533a.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(R.drawable.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // d.a.m0.a0.a
    public int e(String str) {
        Integer num = f54535c.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}
