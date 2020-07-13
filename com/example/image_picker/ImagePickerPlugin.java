package com.example.image_picker;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.util.o;
import com.example.image_picker.PostAsyncTask;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class ImagePickerPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private static PostAsyncTask.PostCallback callback;
    private static MethodChannel channel;
    private static MethodChannel channel_utily;
    private BroadcastReciver broadcastReciver;
    private static Activity currentActivity = null;
    private static String barId = null;

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921464, new CustomMessageTask.CustomRunnable<Intent>() { // from class: com.example.image_picker.ImagePickerPlugin.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Intent> customMessage) {
                Intent data;
                String stringExtra;
                if (customMessage != null && (data = customMessage.getData()) != null && (stringExtra = data.getStringExtra("album_result")) != null) {
                    WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
                    writeImagesInfo.parseJson(stringExtra);
                    writeImagesInfo.updateQuality();
                    if (!w.isEmpty(writeImagesInfo.getChosedFiles())) {
                        EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) ImagePickerPlugin.currentActivity, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, data.getData(), TbadkCoreApplication.getCurrentAccountObj(), 4, writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, true);
                        editHeadActivityConfig.setWaterMaskType(3);
                        editHeadActivityConfig.setNeedPaste(false);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editHeadActivityConfig));
                    }
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        callback = new PostAsyncTask.PostCallback() { // from class: com.example.image_picker.ImagePickerPlugin.2
            @Override // com.example.image_picker.PostAsyncTask.PostCallback
            public void onSuccess(PostAsyncTask.ResultData resultData) {
                if (resultData != null) {
                    ImagePickerPlugin.notifyFlutter(resultData.error_code, "提交成功，我们会尽快完成审核", resultData.url);
                }
            }

            @Override // com.example.image_picker.PostAsyncTask.PostCallback
            public void onFailure(PostAsyncTask.ResultData resultData) {
                if (resultData != null) {
                    ImagePickerPlugin.notifyFlutter(resultData.error_code, resultData.error_msg, "");
                }
            }
        };
    }

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        channel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "image_picker");
        channel.setMethodCallHandler(new ImagePickerPlugin());
        channel_utily = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "utility_plugin");
    }

    private void unRegisterBroadcastReciver() {
        try {
            if (this.broadcastReciver != null) {
                currentActivity.unregisterReceiver(this.broadcastReciver);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    private void registerBroadcastReciver() {
        try {
            this.broadcastReciver = new BroadcastReciver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tieba.action.ImagePickerPlugin");
            currentActivity.registerReceiver(this.broadcastReciver, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    /* loaded from: classes6.dex */
    public static class BroadcastReciver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            PhotoUrlData photoUrlData;
            if (intent != null && "com.tieba.action.ImagePickerPlugin".equals(intent.getAction()) && (photoUrlData = (PhotoUrlData) intent.getSerializableExtra("pic_info")) != null && TbadkCoreApplication.getInst().isMainProcess(true)) {
                new PostAsyncTask(photoUrlData.getOriginPic(), ImagePickerPlugin.barId, ImagePickerPlugin.callback).execute(new String[0]);
            }
        }
    }

    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        Map map;
        Log.e("ImagePickerPlugin", "onMethodCall: " + methodCall.method + methodCall.arguments);
        if (methodCall.method.equals("editUserPortrait")) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(currentActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!permissionJudgePolicy.startRequestPermission(TbadkCoreApplication.getInst().getCurrentActivity())) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) currentActivity, new WriteImagesInfo().toJsonString(), true);
                albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                albumActivityConfig.setResourceType(2);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                result.success(true);
            }
        } else if (methodCall.method.equals("takePhoto") || methodCall.method.equals("chosePhotoLibrary")) {
            currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            unRegisterBroadcastReciver();
            registerBroadcastReciver();
            PermissionJudgePolicy permissionJudgePolicy2 = new PermissionJudgePolicy();
            permissionJudgePolicy2.clearRequestPermissionList();
            permissionJudgePolicy2.appendRequestPermission(currentActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!permissionJudgePolicy2.startRequestPermission(TbadkCoreApplication.getInst().getCurrentActivity()) && (map = (Map) methodCall.arguments) != null) {
                barId = (String) map.get("barId");
                AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig((Context) currentActivity, new WriteImagesInfo().toJsonString(), true);
                albumActivityConfig2.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                albumActivityConfig2.setIntentAction(IntentAction.ActivityForResult);
                albumActivityConfig2.setCanEditImage(false);
                albumActivityConfig2.setResourceType(2);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig2));
            }
        } else if (methodCall.method.equals("savePhoto")) {
            Map map2 = (Map) methodCall.arguments;
            if (map2 != null) {
                currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                downloadImage((String) map2.get(TableDefine.PaSubscribeColumns.COLUMN_AVATAR));
            }
        } else {
            result.notImplemented();
        }
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        unRegisterBroadcastReciver();
    }

    private void downloadImage(String str) {
        if (currentActivity != null) {
            o oVar = new o(currentActivity, str, new o.a() { // from class: com.example.image_picker.ImagePickerPlugin.3
                @Override // com.baidu.tbadk.util.o.a
                public void onError(int i, String str2) {
                    ImagePickerPlugin.notifyFlutter(i, str2, "");
                }

                @Override // com.baidu.tbadk.util.o.a
                public void onSuccess(String str2) {
                    ImagePickerPlugin.notifyFlutter(0, "保存成功！", "");
                }
            });
            oVar.iF(false);
            oVar.iG(true);
            oVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyFlutter(int i, String str, String str2) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("imgUrl", str2);
        }
        hashMap.put("msg", str);
        hashMap.put("errorcode", String.valueOf(i));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("uniqueKey", "kUpDateBaHeadNSNotification");
        hashMap2.put("data", hashMap);
        Log.e("notifyflutter", hashMap2.toString());
        channel_utily.invokeMethod("onNotification", hashMap2);
    }
}
