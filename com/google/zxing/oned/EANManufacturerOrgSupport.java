package com.google.zxing.oned;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.ResponseCode;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.center.clearcache.UserSettingForceListListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.titan.sdk.verifier.ApkSignatureSchemeV2Verifier;
import com.baidu.ugc.editvideo.record.RecordConstants;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.google.zxing.client.result.ExpandedProductParsedResult;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class EANManufacturerOrgSupport {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<String> countryIdentifiers;
    public final List<int[]> ranges;

    public EANManufacturerOrgSupport() {
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
        this.ranges = new ArrayList();
        this.countryIdentifiers = new ArrayList();
    }

    private void add(int[] iArr, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, iArr, str) == null) {
            this.ranges.add(iArr);
            this.countryIdentifiers.add(str);
        }
    }

    private synchronized void initIfNeeded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            synchronized (this) {
                if (this.ranges.isEmpty()) {
                    add(new int[]{0, 19}, "US/CA");
                    add(new int[]{30, 39}, "US");
                    add(new int[]{60, Cea708Decoder.COMMAND_TGW}, "US/CA");
                    add(new int[]{300, 379}, "FR");
                    add(new int[]{380}, "BG");
                    add(new int[]{383}, "SI");
                    add(new int[]{385}, "HR");
                    add(new int[]{387}, "BA");
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
                    add(new int[]{480}, "PH");
                    add(new int[]{481}, "BY");
                    add(new int[]{482}, "UA");
                    add(new int[]{484}, "MD");
                    add(new int[]{485}, "AM");
                    add(new int[]{486}, "GE");
                    add(new int[]{487}, "KZ");
                    add(new int[]{489}, "HK");
                    add(new int[]{490, DownloadConstants.STATUS_DEVICE_NOT_FOUND_ERROR}, "JP");
                    add(new int[]{500, 509}, "GB");
                    add(new int[]{520}, "GR");
                    add(new int[]{528}, ExpandedProductParsedResult.POUND);
                    add(new int[]{529}, "CY");
                    add(new int[]{531}, "MK");
                    add(new int[]{535}, "MT");
                    add(new int[]{539}, "IE");
                    add(new int[]{RecordConstants.DEFAULT_PREVIEW_WIDTH, 549}, "BE/LU");
                    add(new int[]{560}, "PT");
                    add(new int[]{569}, "IS");
                    add(new int[]{570, 579}, "DK");
                    add(new int[]{590}, "PL");
                    add(new int[]{594}, "RO");
                    add(new int[]{599}, "HU");
                    add(new int[]{600, 601}, "ZA");
                    add(new int[]{ResponseCode.TFE_IMMGR_KVACCESS_NOT_EXIST}, "GH");
                    add(new int[]{608}, "BH");
                    add(new int[]{609}, "MU");
                    add(new int[]{611}, "MA");
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
                    add(new int[]{700, 709}, HlsPlaylistParser.BOOLEAN_FALSE);
                    add(new int[]{729}, "IL");
                    add(new int[]{730, 739}, "SE");
                    add(new int[]{740}, "GT");
                    add(new int[]{741}, "SV");
                    add(new int[]{742}, "HN");
                    add(new int[]{743}, "NI");
                    add(new int[]{744}, "CR");
                    add(new int[]{745}, "PA");
                    add(new int[]{746}, "DO");
                    add(new int[]{PassBiometricUtil.k}, "MX");
                    add(new int[]{754, 755}, "CA");
                    add(new int[]{759}, "VE");
                    add(new int[]{760, ApkSignatureSchemeV2Verifier.SIGNATURE_DSA_WITH_SHA256}, "CH");
                    add(new int[]{770}, "CO");
                    add(new int[]{773}, "UY");
                    add(new int[]{775}, "PE");
                    add(new int[]{777}, "BO");
                    add(new int[]{779}, "AR");
                    add(new int[]{780}, "CL");
                    add(new int[]{784}, "PY");
                    add(new int[]{785}, "PE");
                    add(new int[]{786}, "EC");
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
                    add(new int[]{899}, UserSettingForceListListener.FORCE_LIST_ITEM_ID_KEY);
                    add(new int[]{900, CyberPlayerManager.MEDIA_INFO_CONNECT_BEGIN}, "AT");
                    add(new int[]{930, CyberPlayerManager.MEDIA_INFO_VIDEO_BITRATE}, "AU");
                    add(new int[]{CyberPlayerManager.MEDIA_INFO_VIDEO_FRAMERATE, 949}, "AZ");
                    add(new int[]{955}, "MY");
                    add(new int[]{958}, "MO");
                }
            }
        }
    }

    public String lookupCountryIdentifier(String str) {
        InterceptResult invokeL;
        int[] iArr;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            initIfNeeded();
            int parseInt = Integer.parseInt(str.substring(0, 3));
            int size = this.ranges.size();
            for (int i2 = 0; i2 < size && parseInt >= (i = (iArr = this.ranges.get(i2))[0]); i2++) {
                if (iArr.length != 1) {
                    i = iArr[1];
                }
                if (parseInt <= i) {
                    return this.countryIdentifiers.get(i2);
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
