package com.example.shareplugin;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.c.f;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SharepluginPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "shareplugin").setMethodCallHandler(new SharepluginPlugin());
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        if (methodCall.method.equals("getPlatformVersion")) {
            result.success("Android " + Build.VERSION.RELEASE);
        } else if (methodCall.method.equals("shareThread")) {
            try {
                JSONObject jSONObject = new JSONObject((Map) methodCall.argument("item"));
                bv bvVar = new bv();
                bvVar.parserJson(jSONObject);
                showShareDialog(bvVar);
                result.success("");
            } catch (Exception e) {
                BdLog.e(e);
            }
        } else {
            result.notImplemented();
        }
    }

    private void showShareDialog(bv bvVar) {
        String tid;
        String str;
        String format;
        String str2;
        if (bvVar != null) {
            String valueOf = String.valueOf(bvVar.getFid());
            String aWp = bvVar.aWp();
            if (bvVar.dUt != null) {
                valueOf = bvVar.dUt.id;
                aWp = bvVar.dUt.ori_fname;
            }
            String title = bvVar.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = bvVar.getAbstract();
            }
            if (bvVar.aUV()) {
                tid = bvVar.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&dtype=" + bvVar.getBaijiahaoData().oriUgcType + "&dvid=" + bvVar.getBaijiahaoData().oriUgcVid + "&nid=" + bvVar.getBaijiahaoData().oriUgcNid;
            } else {
                tid = bvVar.getTid();
                str = "?share=9105&fr=share";
            }
            String str3 = "http://tieba.baidu.com/p/" + tid + str;
            boolean z = true;
            if (bvVar.aWF() != null && bvVar.aWF().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str2 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(bvVar.aWF().user_info.user_name, "utf-8");
                    } else {
                        str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(bvVar.aWF().user_info.user_name, "utf-8");
                    }
                    str3 = str2;
                    z = false;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            String shareImageUrl = getShareImageUrl(bvVar);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str4 = bvVar.getAbstract();
            String string = TbadkApplication.getInst().getResources().getString(R.string.share_content_tpl);
            String string2 = TbadkApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
            if (!bvVar.aUV() || bvVar.aWl() == null) {
                format = MessageFormat.format(string, title, str4);
            } else {
                format = (TextUtils.isEmpty(bvVar.getTitle()) || TextUtils.isEmpty(str4)) ? MessageFormat.format(string2, bvVar.aWl().getName_show(), TbadkApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix)) : str4;
            }
            String cutString = as.cutString(title, 100);
            String cutString2 = as.cutString(format, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.title = cutString;
            shareItem.content = cutString2;
            int stateThreadType = getStateThreadType(bvVar);
            if (bvVar.aUV()) {
                shareItem.readCount = -1L;
                shareItem.etQ = cutString2;
            } else {
                if (stateThreadType == 2 && bvVar.aWD() != null) {
                    shareItem.readCount = bvVar.aWD().play_count.intValue();
                } else if (stateThreadType == 1) {
                    shareItem.readCount = bvVar.aWd();
                }
                shareItem.etQ = str4;
            }
            shareItem.linkUrl = str3;
            shareItem.extData = tid;
            shareItem.fid = valueOf;
            shareItem.fName = aWp;
            shareItem.tid = tid;
            shareItem.etH = true;
            shareItem.dVb = 6;
            shareItem.etS = 8;
            shareItem.etX = stateThreadType;
            shareItem.etT = 3;
            shareItem.etU = getShareObjParam2(bvVar);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (bvVar.aUV()) {
                z = false;
            }
            shareItem.canShareBySmartApp = z;
            if (z) {
                shareItem.euh = bvVar.getShareImageUrl();
            }
            shareItem.eua = OriginalThreadInfo.ShareInfo.generateShareInfo(bvVar);
            shareItem.eub = ShareItem.ForwardInfo.generateForwardInfo(bvVar);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.etT);
            bundle.putInt("obj_type", shareItem.etX);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.dVb);
            shareItem.af(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(TbadkCoreApplication.getInst().getCurrentActivity(), shareItem, true);
            boolean z2 = false;
            shareDialogConfig.setIsAlaLive((bvVar.getThreadType() == 49 || bvVar.getThreadType() == 60) ? true : true);
            shareDialogConfig.setFrom(ShareDialogConfig.From.PersonPolymeric);
            f.bSP().b(shareDialogConfig);
        }
    }

    private int getStateThreadType(bv bvVar) {
        if (bvVar != null) {
            if (bvVar.aWn()) {
                return 4;
            }
            if (bvVar.aWi() == 1) {
                return 3;
            }
            if (bvVar.aUT()) {
                return 5;
            }
            if (bvVar.aUU()) {
                return 6;
            }
            if (bvVar.aYg()) {
                return 7;
            }
            if (bvVar.aYh()) {
                return 8;
            }
            if (!bvVar.isShareThread || bvVar.dUi == null) {
                return bvVar.aXD() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    private int getShareObjParam2(bv bvVar) {
        if (bvVar == null) {
            return 0;
        }
        if (bvVar.aUT()) {
            return 10;
        }
        if (bvVar.aUU()) {
            return 9;
        }
        if (bvVar.aYh()) {
            return 8;
        }
        if (bvVar.aYg()) {
            return 7;
        }
        if (bvVar.isShareThread) {
            return 6;
        }
        if (bvVar.threadType == 0) {
            return 1;
        }
        if (bvVar.threadType == 40) {
            return 2;
        }
        if (bvVar.threadType == 49) {
            return 3;
        }
        if (bvVar.threadType == 54) {
            return 4;
        }
        return 5;
    }

    private String getShareImageUrl(bv bvVar) {
        String str;
        if (bvVar == null) {
            return null;
        }
        if (bvVar.aWF() != null && !TextUtils.isEmpty(bvVar.aWF().cover)) {
            return bvVar.aWF().cover;
        }
        if (bvVar.aWu() == null) {
            return null;
        }
        ArrayList<MediaData> aWu = bvVar.aWu();
        int size = aWu.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = aWu.get(i);
            if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                    str = mediaData.getThumbnails_url();
                    break;
                } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                    str = mediaData.getPicUrl();
                    break;
                }
            }
            i++;
        }
        if (str == null && bvVar.aWD() != null && !TextUtils.isEmpty(bvVar.aWD().thumbnail_url)) {
            return bvVar.aWD().thumbnail_url;
        }
        return str;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }
}
