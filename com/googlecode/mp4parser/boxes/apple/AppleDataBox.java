package com.googlecode.mp4parser.boxes.apple;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.annotations.DoNotParseDetail;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Locale;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;
/* loaded from: classes10.dex */
public abstract class AppleDataBox extends AbstractBox {
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_1 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_2 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_3 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_4 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_5 = null;
    public static HashMap<String, String> language;
    public int dataCountry;
    public int dataLanguage;
    public int dataType;

    public abstract int getDataLength();

    public abstract void parseData(ByteBuffer byteBuffer);

    public abstract byte[] writeData();

    static {
        ajc$preClinit();
        HashMap<String, String> hashMap = new HashMap<>();
        language = hashMap;
        hashMap.put("0", "English");
        language.put("1", "French");
        language.put("2", "German");
        language.put("3", "Italian");
        language.put("4", "Dutch");
        language.put("5", "Swedish");
        language.put("6", "Spanish");
        language.put("7", "Danish");
        language.put("8", "Portuguese");
        language.put("9", "Norwegian");
        language.put("10", "Hebrew");
        language.put("11", "Japanese");
        language.put("12", "Arabic");
        language.put("13", "Finnish");
        language.put("14", "Greek");
        language.put("15", "Icelandic");
        language.put("16", "Maltese");
        language.put("17", "Turkish");
        language.put("18", "Croatian");
        language.put("19", "Traditional_Chinese");
        language.put(PayUVEventType.PAY_WALLET_BANNER_SHOW, "Urdu");
        language.put("21", "Hindi");
        language.put("22", "Thai");
        language.put("23", "Korean");
        language.put("24", "Lithuanian");
        language.put("25", "Polish");
        language.put("26", "Hungarian");
        language.put(PayUVEventType.PAY_WAY_FAQ_ENTRANCE_CLICK, "Estonian");
        language.put("28", "Lettish");
        language.put(PayUVEventType.THIRD_PAY_WAY_DIALOG_COMFIRM_BTN_CLICK, "Sami");
        language.put(PayUVEventType.THIRD_PAY_WAY_DIALOG_CHANNEL_CLICK, "Faroese");
        language.put(PayUVEventType.PAY_SPLIT_ORDER_PAGE_SHOW, "Farsi");
        language.put(PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK, "Russian");
        language.put(PayUVEventType.PAY_SPLIT_ORDER_BACK_BTN_CLICK, "Simplified_Chinese");
        language.put(PayUVEventType.PAY_SPLIT_ORDER_MOTIFY_BTN_CLICK, "Flemish");
        language.put(PayUVEventType.PAY_SPLIT_ORDER_LINK_ITME_CLICK, "Irish");
        language.put("36", "Albanian");
        language.put("37", "Romanian");
        language.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_CLOSE_BTN_CLICK, "Czech");
        language.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_BACK_BTN_CLICK, "Slovak");
        language.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_MOTIFY_BTN_CLICK, "Slovenian");
        language.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_LINK_ITME_CLICK, "Yiddish");
        language.put("42", "Serbian");
        language.put(PayUVEventType.PAY_WAY_DIALOG_CLOSE_BTN_CLICK, "Macedonian");
        language.put(PayUVEventType.PAY_WAY_FULL_PAGE_CLOSE_BTN_CLICK, "Bulgarian");
        language.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_PAGE_SHOW, "Ukrainian");
        language.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_CLOSE_BTN_CLICK, "Belarusian");
        language.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_LINK_ITEM_CLICK, "Uzbek");
        language.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_AMOUNT_ITEM_CLICK, "Kazakh");
        language.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_PAGE_SHOW, "Azerbaijani");
        language.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_CLOSE_BTN_CLICK, "AzerbaijanAr");
        language.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_LINK_ITEM_CLICK, "Armenian");
        language.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_AMOUNT_ITEM_CLICK, "Georgian");
        language.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_SUCCESS_PAGE_SHOW, "Moldavian");
        language.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_SUCCESS_CLOSE_BTN_CLICK, "Kirghiz");
        language.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_SUCCESS_LINK_ITEM_CLICK, "Tajiki");
        language.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_SUCCESS_AMOUNT_ITEM_CLICK, "Turkmen");
        language.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_FAIL_PAGE_SHOW, "Mongolian");
        language.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_FAIL_CLOSE_BTN_CLICK, "MongolianCyr");
        language.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_FAIL_LINK_ITEM_CLICK, "Pashto");
        language.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_FAIL_AMOUNT_ITEM_CLICK, "Kurdish");
        language.put(PayUVEventType.PAY_SIGN_DIALOG_SHOW, "Kashmiri");
        language.put(PayUVEventType.PAY_SIGN_DIALOG_CONFIRM_BTN_CLICK, "Sindhi");
        language.put(PayUVEventType.PAY_SIGN_DIALOG_DONT_REMIND_CLICK, "Tibetan");
        language.put("64", "Nepali");
        language.put(PayUVEventType.PAY_WALLET_RIGHT_SET_BTN_CLICK, "Sanskrit");
        language.put(PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW, "Marathi");
        language.put(PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_CLICK, "Bengali");
        language.put(PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, "Assamese");
        language.put(PayUVEventType.PAY_AMOUNT_FULL_PAGE_CHANNEL_CLICK, "Gujarati");
        language.put(PayUVEventType.PAY_AMOUNT_MORE_PAY_WAY_CLICK, "Punjabi");
        language.put("71", "Oriya");
        language.put("72", "Malayalam");
        language.put("73", "Kannada");
        language.put("74", "Tamil");
        language.put("75", "Telugu");
        language.put("76", "Sinhala");
        language.put("77", "Burmese");
        language.put("78", "Khmer");
        language.put("79", "Lao");
        language.put("80", "Vietnamese");
        language.put("81", "Indonesian");
        language.put("82", "Tagalog");
        language.put("83", "MalayRoman");
        language.put("84", "MalayArabic");
        language.put("85", "Amharic");
        language.put("87", "Galla");
        language.put("87", "Oromo");
        language.put("88", "Somali");
        language.put("89", "Swahili");
        language.put("90", "Kinyarwanda");
        language.put("91", "Rundi");
        language.put("92", "Nyanja");
        language.put("93", "Malagasy");
        language.put("94", "Esperanto");
        language.put("128", "Welsh");
        language.put("129", "Basque");
        language.put("130", "Catalan");
        language.put("131", "Latin");
        language.put("132", "Quechua");
        language.put("133", "Guarani");
        language.put("134", "Aymara");
        language.put("135", "Tatar");
        language.put("136", "Uighur");
        language.put("137", "Dzongkha");
        language.put(UnitedSchemeMainDispatcher.UBC_OUTER_INVOKE_TO_TAYGET_ID, "JavaneseRom");
        language.put("32767", "Unspecified");
    }

    public AppleDataBox(String str, int i) {
        super(str);
        this.dataType = i;
    }

    public static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("AppleDataBox.java", AppleDataBox.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getLanguageString", "com.googlecode.mp4parser.boxes.apple.AppleDataBox", "", "", "", "java.lang.String"), 25);
        ajc$tjp_1 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getDataType", "com.googlecode.mp4parser.boxes.apple.AppleDataBox", "", "", "", IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL), 43);
        ajc$tjp_2 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getDataCountry", "com.googlecode.mp4parser.boxes.apple.AppleDataBox", "", "", "", IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL), 47);
        ajc$tjp_3 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setDataCountry", "com.googlecode.mp4parser.boxes.apple.AppleDataBox", IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, "dataCountry", "", "void"), 51);
        ajc$tjp_4 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getDataLanguage", "com.googlecode.mp4parser.boxes.apple.AppleDataBox", "", "", "", IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL), 55);
        ajc$tjp_5 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setDataLanguage", "com.googlecode.mp4parser.boxes.apple.AppleDataBox", IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, "dataLanguage", "", "void"), 59);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseData(parseDataLength4ccTypeCountryLanguageAndReturnRest(byteBuffer));
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeDataLength4ccTypeCountryLanguage(byteBuffer);
        byteBuffer.put(writeData());
    }

    public void setDataCountry(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_3, this, this, Conversions.intObject(i)));
        this.dataCountry = i;
    }

    public void setDataLanguage(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_5, this, this, Conversions.intObject(i)));
        this.dataLanguage = i;
    }

    @DoNotParseDetail
    public void writeDataLength4ccTypeCountryLanguage(ByteBuffer byteBuffer) {
        byteBuffer.putInt(getDataLength() + 16);
        byteBuffer.put("data".getBytes());
        byteBuffer.putInt(this.dataType);
        IsoTypeWriter.writeUInt16(byteBuffer, this.dataCountry);
        IsoTypeWriter.writeUInt16(byteBuffer, this.dataLanguage);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        return getDataLength() + 16;
    }

    public int getDataCountry() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_2, this, this));
        return this.dataCountry;
    }

    public int getDataLanguage() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_4, this, this));
        return this.dataLanguage;
    }

    public int getDataType() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_1, this, this));
        return this.dataType;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0014: IGET  (r2v0 int A[REMOVE]) = (r3v0 'this' com.googlecode.mp4parser.boxes.apple.AppleDataBox A[IMMUTABLE_TYPE, THIS]) com.googlecode.mp4parser.boxes.apple.AppleDataBox.dataLanguage int)] */
    public String getLanguageString() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_0, this, this));
        HashMap<String, String> hashMap = language;
        StringBuilder sb = new StringBuilder();
        sb.append(this.dataLanguage);
        String str = hashMap.get(sb.toString());
        if (str == null) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[2]);
            IsoTypeWriter.writeUInt16(wrap, this.dataLanguage);
            wrap.reset();
            return new Locale(IsoTypeReader.readIso639(wrap)).getDisplayLanguage();
        }
        return str;
    }

    @DoNotParseDetail
    public ByteBuffer parseDataLength4ccTypeCountryLanguageAndReturnRest(ByteBuffer byteBuffer) {
        int i = byteBuffer.getInt();
        byteBuffer.getInt();
        this.dataType = byteBuffer.getInt();
        short s = byteBuffer.getShort();
        this.dataCountry = s;
        if (s < 0) {
            this.dataCountry = s + 65536;
        }
        short s2 = byteBuffer.getShort();
        this.dataLanguage = s2;
        if (s2 < 0) {
            this.dataLanguage = s2 + 65536;
        }
        int i2 = i - 16;
        ByteBuffer byteBuffer2 = (ByteBuffer) byteBuffer.duplicate().slice().limit(i2);
        byteBuffer.position(i2 + byteBuffer.position());
        return byteBuffer2;
    }
}
