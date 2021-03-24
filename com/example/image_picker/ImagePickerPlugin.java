package com.example.image_picker;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.personExtra.EditHeadActivity;
import com.example.image_picker.PostAsyncTask;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import com.kwai.video.player.PlayerPostEvent;
import d.b.h0.z0.q;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class ImagePickerPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    public static String barId = null;
    public static BroadcastReciver broadcastReciver = null;
    public static PostAsyncTask.PostCallback callback = null;
    public static MethodChannel channel = null;
    public static MethodChannel channel_utily = null;
    public static Activity currentActivity = null;
    public static boolean isEditHeadImage = false;
    public static boolean onlyNeedImageUrl = false;
    public static double scaleRate = 1.0d;

    /* loaded from: classes6.dex */
    public static class BroadcastReciver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && EditHeadActivity.FLUTTER_ACTION.equals(intent.getAction())) {
                if (intent.getBooleanExtra("isHeadImage", false)) {
                    if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380));
                        return;
                    }
                    return;
                }
                PhotoUrlData photoUrlData = (PhotoUrlData) intent.getSerializableExtra("pic_info");
                if (photoUrlData == null || !TbadkCoreApplication.getInst().isMainProcess(true)) {
                    return;
                }
                String originPic = photoUrlData.getOriginPic();
                if (ImagePickerPlugin.onlyNeedImageUrl) {
                    ImagePickerPlugin.notifyFlutter(0, "", originPic);
                } else {
                    new PostAsyncTask(originPic, ImagePickerPlugin.barId, ImagePickerPlugin.callback).execute(new String[0]);
                }
            }
        }
    }

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921464, new CustomMessageTask.CustomRunnable<Intent>() { // from class: com.example.image_picker.ImagePickerPlugin.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Intent> customMessage) {
                Intent data;
                String stringExtra;
                if (customMessage != null && (data = customMessage.getData()) != null && (stringExtra = data.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
                    WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
                    writeImagesInfo.parseJson(stringExtra);
                    writeImagesInfo.updateQuality();
                    if (!ListUtils.isEmpty(writeImagesInfo.getChosedFiles())) {
                        if (ImagePickerPlugin.isEditHeadImage) {
                            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) ImagePickerPlugin.currentActivity, (int) PlayerPostEvent.MEDIA_REP_CHANGE_END, 12009, data.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, writeImagesInfo.getChosedFiles().get(0).getFilePath(), (float) ImagePickerPlugin.scaleRate, true);
                            editHeadActivityConfig.setWaterMaskType(3);
                            editHeadActivityConfig.setFromWhere(EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER);
                            editHeadActivityConfig.setNeedPaste(true);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editHeadActivityConfig));
                        } else {
                            EditHeadActivityConfig editHeadActivityConfig2 = new EditHeadActivityConfig((Context) ImagePickerPlugin.currentActivity, (int) PlayerPostEvent.MEDIA_REP_CHANGE_END, 12009, data.getData(), TbadkCoreApplication.getCurrentAccountObj(), 4, writeImagesInfo.getChosedFiles().get(0).getFilePath(), (float) ImagePickerPlugin.scaleRate, true);
                            editHeadActivityConfig2.setWaterMaskType(3);
                            editHeadActivityConfig2.setFromWhere(EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER);
                            editHeadActivityConfig2.setNeedPaste(false);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editHeadActivityConfig2));
                        }
                    }
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        callback = new PostAsyncTask.PostCallback() { // from class: com.example.image_picker.ImagePickerPlugin.2
            @Override // com.example.image_picker.PostAsyncTask.PostCallback
            public void onFailure(PostAsyncTask.ResultData resultData) {
                if (resultData == null) {
                    return;
                }
                ImagePickerPlugin.notifyFlutter(resultData.error_code, resultData.error_msg, resultData.url);
            }

            @Override // com.example.image_picker.PostAsyncTask.PostCallback
            public void onSuccess(PostAsyncTask.ResultData resultData) {
                if (resultData == null) {
                    return;
                }
                ImagePickerPlugin.notifyFlutter(resultData.error_code, "提交成功，我们会尽快完成审核", resultData.url);
            }
        };
    }

    public static void notifyFlutter(int i, String str, String str2) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("imgUrl", str2);
        }
        hashMap.put("msg", str);
        hashMap.put("errorcode", String.valueOf(i));
        HashMap hashMap2 = new HashMap();
        if (onlyNeedImageUrl) {
            hashMap2.put("uniqueKey", "kUpDateBaHeadNSNotificationBarBroadcast");
        } else {
            hashMap2.put("uniqueKey", "kUpDateBaHeadNSNotification");
        }
        hashMap2.put("data", hashMap);
        Log.e("notifyflutter", hashMap2.toString());
        channel_utily.invokeMethod("onNotification", hashMap2);
    }

    public final void downloadImage(String str) {
        if (currentActivity == null) {
            return;
        }
        q qVar = new q(currentActivity, str, new q.a(this) { // from class: com.example.image_picker.ImagePickerPlugin.3
            @Override // d.b.h0.z0.q.a
            public void onError(int i, String str2) {
                ImagePickerPlugin.notifyFlutter(i, str2, "");
            }

            @Override // d.b.h0.z0.q.a
            public void onSuccess(String str2) {
                ImagePickerPlugin.notifyFlutter(0, "保存成功！", "");
            }
        });
        qVar.o(false);
        qVar.q(true);
        qVar.execute(new String[0]);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "image_picker");
        channel = methodChannel;
        methodChannel.setMethodCallHandler(new ImagePickerPlugin());
        channel_utily = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "utility_plugin");
        registerBroadcastReciver();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        unRegisterBroadcastReciver();
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Log.e("ImagePickerPlugin", "onMethodCall: " + methodCall.method + methodCall.arguments);
        if (methodCall.method.equals("editUserPortrait")) {
            currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(currentActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            if (permissionJudgePolicy.startRequestPermission(currentActivity)) {
                return;
            }
            isEditHeadImage = true;
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) currentActivity, new WriteImagesInfo().toJsonString(), true);
            albumActivityConfig.getIntent().putExtra("from", AlbumActivityConfig.FROM_FLUTTER);
            albumActivityConfig.setRequestCode(PlayerPostEvent.MEDIA_REP_CHANGE_END);
            albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            albumActivityConfig.setResourceType(2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            result.success(Boolean.TRUE);
        } else if (!methodCall.method.equals("takePhoto") && !methodCall.method.equals("chosePhotoLibrary")) {
            if (methodCall.method.equals("savePhoto")) {
                Map map = (Map) methodCall.arguments;
                if (map == null) {
                    return;
                }
                currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                PermissionJudgePolicy permissionJudgePolicy2 = new PermissionJudgePolicy();
                permissionJudgePolicy2.clearRequestPermissionList();
                permissionJudgePolicy2.appendRequestPermission(currentActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                if (permissionJudgePolicy2.startRequestPermission(TbadkCoreApplication.getInst().getCurrentActivity())) {
                    if (PreferenceUtils.getBoolean("imagepicker_tost_show", false) && !ActivityCompat.shouldShowRequestPermissionRationale(TbadkCoreApplication.getInst().getCurrentActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
                        BdToast.c(currentActivity, "请到设置-隐私-照片开启照片权限").q();
                    }
                    PreferenceUtils.setBoolean("imagepicker_tost_show", true);
                    return;
                }
                onlyNeedImageUrl = false;
                isEditHeadImage = false;
                if (map.containsKey("onlyNeedImageUrl")) {
                    onlyNeedImageUrl = ((Boolean) map.get("onlyNeedImageUrl")).booleanValue();
                }
                downloadImage((String) map.get("avatar"));
                return;
            }
            result.notImplemented();
        } else {
            currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            PermissionJudgePolicy permissionJudgePolicy3 = new PermissionJudgePolicy();
            permissionJudgePolicy3.clearRequestPermissionList();
            permissionJudgePolicy3.appendRequestPermission(currentActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            if (permissionJudgePolicy3.startRequestPermission(TbadkCoreApplication.getInst().getCurrentActivity())) {
                if (PreferenceUtils.getBoolean("imagepicker_tost_show", false) && !ActivityCompat.shouldShowRequestPermissionRationale(TbadkCoreApplication.getInst().getCurrentActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
                    BdToast.c(currentActivity, "请到设置-隐私-照片开启照片权限").q();
                }
                PreferenceUtils.setBoolean("imagepicker_tost_show", true);
                return;
            }
            Map map2 = (Map) methodCall.arguments;
            if (map2 == null) {
                return;
            }
            onlyNeedImageUrl = false;
            barId = null;
            scaleRate = 1.0d;
            isEditHeadImage = false;
            if (map2.containsKey("onlyNeedImageUrl")) {
                onlyNeedImageUrl = ((Boolean) map2.get("onlyNeedImageUrl")).booleanValue();
            }
            if (onlyNeedImageUrl) {
                scaleRate = 0.5625d;
            }
            if (map2.containsKey("barId")) {
                barId = (String) map2.get("barId");
            }
            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig((Context) currentActivity, new WriteImagesInfo().toJsonString(), true);
            albumActivityConfig2.setRequestCode(PlayerPostEvent.MEDIA_REP_CHANGE_END);
            albumActivityConfig2.setIntentAction(IntentAction.ActivityForResult);
            albumActivityConfig2.setCanEditImage(false);
            albumActivityConfig2.getIntent().putExtra("from", AlbumActivityConfig.FROM_FLUTTER);
            albumActivityConfig2.setResourceType(2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
        }
    }

    public final void registerBroadcastReciver() {
        try {
            broadcastReciver = new BroadcastReciver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(EditHeadActivity.FLUTTER_ACTION);
            TbadkCoreApplication.getInst().registerReceiver(broadcastReciver, intentFilter);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public final void unRegisterBroadcastReciver() {
        try {
            if (broadcastReciver != null) {
                TbadkCoreApplication.getInst().unregisterReceiver(broadcastReciver);
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }
}
