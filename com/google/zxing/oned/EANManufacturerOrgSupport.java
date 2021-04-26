package com.google.zxing.oned;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.mapapi.UIMsg;
import com.baidu.mobads.container.info.XDeviceInfo;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tieba.aiapps.apps.guide.AiAppGuideActivity;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.fingerprint.bean.FingerprintBeanFactory;
import com.bytedance.sdk.adnet.err.VAdError;
import com.google.zxing.client.result.ExpandedProductParsedResult;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class EANManufacturerOrgSupport {
    public final List<int[]> ranges = new ArrayList();
    public final List<String> countryIdentifiers = new ArrayList();

    private void add(int[] iArr, String str) {
        this.ranges.add(iArr);
        this.countryIdentifiers.add(str);
    }

    private synchronized void initIfNeeded() {
        if (this.ranges.isEmpty()) {
            add(new int[]{0, 19}, "US/CA");
            add(new int[]{30, 39}, "US");
            add(new int[]{60, 139}, "US/CA");
            add(new int[]{300, 379}, "FR");
            add(new int[]{380}, "BG");
            add(new int[]{SDKLogTypeConstants.SPLASH_VIDEO_MONITOR}, "SI");
            add(new int[]{385}, "HR");
            add(new int[]{SDKLogTypeConstants.TYPE_SEND_INFO}, "BA");
            add(new int[]{400, 440}, "DE");
            add(new int[]{450, 459}, "JP");
            add(new int[]{460, 469}, "RU");
            add(new int[]{471}, "TW");
            add(new int[]{474}, "EE");
            add(new int[]{475}, "LV");
            add(new int[]{476}, "AZ");
            add(new int[]{477}, "LT");
            add(new int[]{478}, "UZ");
            add(new int[]{479}, "LK");
            add(new int[]{480}, XDeviceInfo.PH);
            add(new int[]{481}, "BY");
            add(new int[]{482}, "UA");
            add(new int[]{484}, "MD");
            add(new int[]{485}, "AM");
            add(new int[]{486}, "GE");
            add(new int[]{487}, "KZ");
            add(new int[]{489}, "HK");
            add(new int[]{490, DownloadConstants.STATUS_DEVICE_NOT_FOUND_ERROR}, "JP");
            add(new int[]{500, 509}, "GB");
            add(new int[]{UIMsg.m_AppUI.MSG_PLACEFIELD_RELOAD}, "GR");
            add(new int[]{528}, ExpandedProductParsedResult.POUND);
            add(new int[]{529}, "CY");
            add(new int[]{PayBeanFactory.BEAN_ID_RCS_APPLY_NO_PWD}, "MK");
            add(new int[]{535}, "MT");
            add(new int[]{539}, "IE");
            add(new int[]{540, 549}, "BE/LU");
            add(new int[]{PayBeanFactory.BEAN_ID_PAY_SORT_SAVE}, "PT");
            add(new int[]{569}, "IS");
            add(new int[]{570, 579}, "DK");
            add(new int[]{590}, "PL");
            add(new int[]{PayBeanFactory.BEAN_ID_SCANCODE_PAY}, "RO");
            add(new int[]{PayBeanFactory.BEAN_ID_CARD_LIST}, "HU");
            add(new int[]{600, 601}, "ZA");
            add(new int[]{603}, "GH");
            add(new int[]{VAdError.NETWORK_DISPATCH_FAIL_CODE}, "BH");
            add(new int[]{VAdError.RENAME_DOWNLOAD_FILE_FAIL_CODE}, "MU");
            add(new int[]{VAdError.DOWNLOAD_FILE_CANCEL_FAIL_CODE}, "MA");
            add(new int[]{613}, "DZ");
            add(new int[]{IMConstants.ERROR_MSG_SHEILD_ME_TIPS}, "KE");
            add(new int[]{618}, "CI");
            add(new int[]{619}, "TN");
            add(new int[]{621}, "SY");
            add(new int[]{622}, "EG");
            add(new int[]{624}, "LY");
            add(new int[]{625}, "JO");
            add(new int[]{626}, "IR");
            add(new int[]{627}, "KW");
            add(new int[]{628}, "SA");
            add(new int[]{629}, "AE");
            add(new int[]{640, 649}, "FI");
            add(new int[]{690, 695}, "CN");
            add(new int[]{700, SDKLogTypeConstants.ADSERV_AD_CLICK_TYPE}, "NO");
            add(new int[]{729}, "IL");
            add(new int[]{730, 739}, "SE");
            add(new int[]{740}, "GT");
            add(new int[]{741}, "SV");
            add(new int[]{742}, "HN");
            add(new int[]{743}, "NI");
            add(new int[]{744}, "CR");
            add(new int[]{745}, "PA");
            add(new int[]{746}, "DO");
            add(new int[]{750}, "MX");
            add(new int[]{754, 755}, "CA");
            add(new int[]{759}, "VE");
            add(new int[]{AiAppGuideActivity.GIF_WIDTH, BankSignFactory.BEAN_ID_POLLING}, "CH");
            add(new int[]{BankSignFactory.BEAN_ID_QUERY}, "CO");
            add(new int[]{FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_CLOSE}, "UY");
            add(new int[]{775}, "PE");
            add(new int[]{777}, "BO");
            add(new int[]{779}, "AR");
            add(new int[]{780}, "CL");
            add(new int[]{784}, "PY");
            add(new int[]{785}, "PE");
            add(new int[]{BeanConstants.BEAN_ID_FOR_NEW_INIT}, "EC");
            add(new int[]{789, AppConfig.VOICE_ID}, "BR");
            add(new int[]{800, 839}, "IT");
            add(new int[]{840, 849}, "ES");
            add(new int[]{850}, OneKeyLoginSdkCall.OPERATOR_TYPE_CUCC);
            add(new int[]{858}, "SK");
            add(new int[]{859}, "CZ");
            add(new int[]{860}, "YU");
            add(new int[]{865}, "MN");
            add(new int[]{867}, "KP");
            add(new int[]{868, 869}, "TR");
            add(new int[]{870, 879}, "NL");
            add(new int[]{880}, "KR");
            add(new int[]{885}, "TH");
            add(new int[]{888}, "SG");
            add(new int[]{890}, "IN");
            add(new int[]{893}, "VN");
            add(new int[]{896}, "PK");
            add(new int[]{899}, "ID");
            add(new int[]{900, CyberPlayerManager.MEDIA_INFO_CONNECT_BEGIN}, "AT");
            add(new int[]{930, CyberPlayerManager.MEDIA_INFO_VIDEO_BITRATE}, "AU");
            add(new int[]{CyberPlayerManager.MEDIA_INFO_VIDEO_FRAMERATE, 949}, "AZ");
            add(new int[]{CyberPlayerManager.MEDIA_INFO_LOOP_REPLAYED}, "MY");
            add(new int[]{958}, "MO");
        }
    }

    public String lookupCountryIdentifier(String str) {
        int[] iArr;
        int i2;
        initIfNeeded();
        int parseInt = Integer.parseInt(str.substring(0, 3));
        int size = this.ranges.size();
        for (int i3 = 0; i3 < size && parseInt >= (i2 = (iArr = this.ranges.get(i3))[0]); i3++) {
            if (iArr.length != 1) {
                i2 = iArr[1];
            }
            if (parseInt <= i2) {
                return this.countryIdentifiers.get(i3);
            }
        }
        return null;
    }
}
