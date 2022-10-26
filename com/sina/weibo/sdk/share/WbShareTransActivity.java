package com.sina.weibo.sdk.share;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.api.StoryObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.WbAppInfo;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;
import com.sina.weibo.sdk.utils.WbSdkVersion;
import com.sina.weibo.sdk.web.view.WbSdkProgressBar;
/* loaded from: classes8.dex */
public class WbShareTransActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CopyResourceTask copyResourceTask;
    public boolean flag;
    public Handler handler;
    public FrameLayout rootLayout;

    public WbShareTransActivity() {
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
        this.flag = false;
        this.handler = new Handler(this, Looper.getMainLooper()) { // from class: com.sina.weibo.sdk.share.WbShareTransActivity.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WbShareTransActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super((Looper) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    super.handleMessage(message);
                    this.this$0.sendCallback(1);
                }
            }
        };
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, keyEvent)) == null) {
            if (i == 4) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    private void checkSource(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, intent) == null) {
            try {
                Bundle extras = intent.getExtras();
                if (extras == null) {
                    finish();
                    return;
                }
                WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
                weiboMultiMessage.toObject(extras);
                transPicAndVideoResource(weiboMultiMessage);
            } catch (Exception unused) {
                finish();
            }
        }
    }

    @Override // com.sina.weibo.sdk.share.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            initView();
            Intent intent = getIntent();
            if (intent == null) {
                return;
            }
            if (intent.getIntExtra(WBConstants.SHARE_START_FLAG, -1) != 0) {
                finish();
            } else {
                checkSource(intent);
            }
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            super.onNewIntent(intent);
            LogUtil.i("Share", "startTransActivity.onNewIntent()");
            Handler handler = this.handler;
            if (handler != null) {
                handler.removeMessages(0);
                this.handler = null;
            }
            setResult(-1, intent);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.remove(WBConstants.SHARE_START_FLAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoWeiboComposer(WeiboMultiMessage weiboMultiMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, weiboMultiMessage) == null) {
            LogUtil.d("Share", "gotoWeiboComposer");
            Intent intent = getIntent();
            this.flag = true;
            try {
                intent.putExtra(WBConstants.SHARE_START_FLAG, -1);
                Intent intent2 = new Intent(WBConstants.ACTIVITY_WEIBO);
                Bundle extras = intent.getExtras();
                weiboMultiMessage.toBundle(extras);
                intent2.putExtras(extras);
                String packageName = getPackageName();
                intent2.putExtra(WBConstants.Base.SDK_VER, WbSdkVersion.WEIBO_SDK_VERSION_CODE);
                intent2.putExtra(WBConstants.Base.APP_PKG, packageName);
                intent2.putExtra(WBConstants.Base.APP_KEY, WbSdk.getAuthInfo().getAppKey());
                intent2.putExtra(WBConstants.SDK.FLAG, WBConstants.WEIBO_FLAG_SDK);
                intent2.putExtra(WBConstants.SIGN, MD5.hexdigest(Utility.getSign(this, packageName)));
                String stringExtra = intent.getStringExtra(WBConstants.SHARE_START_GOTO_ACTIVITY);
                if (!TextUtils.isEmpty(stringExtra) && "com.sina.weibo.sdk.web.WeiboSdkWebActivity".equals(stringExtra)) {
                    intent2.setClassName(this, "com.sina.weibo.sdk.web.WeiboSdkWebActivity");
                    startActivityForResult(intent2, WBConstants.SDK_ACTIVITY_FOR_RESULT_CODE);
                } else if (WbSdk.isWbInstall(this)) {
                    WbAppInfo wbAppInfo = WeiboAppManager.getInstance(this).getWbAppInfo();
                    if (wbAppInfo != null) {
                        intent2.setPackage(wbAppInfo.getPackageName());
                        startActivityForResult(intent2, WBConstants.SDK_ACTIVITY_FOR_RESULT_CODE);
                    } else {
                        startActivityForResult(intent2, WBConstants.SDK_ACTIVITY_FOR_RESULT_CODE);
                    }
                } else {
                    sendCallback(2);
                }
            } catch (Exception unused) {
                sendCallback(2);
            }
        }
    }

    private void initView() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            int intExtra = getIntent().getIntExtra(WBConstants.TRANS_PROGRESS_COLOR, -1);
            int intExtra2 = getIntent().getIntExtra(WBConstants.TRANS_PROGRESS_ID, -1);
            this.rootLayout = new FrameLayout(this);
            if (intExtra2 != -1) {
                try {
                    view2 = ((LayoutInflater) getSystemService("layout_inflater")).inflate(intExtra2, (ViewGroup) null);
                } catch (Exception unused) {
                    view2 = new WbSdkProgressBar(this);
                }
            } else {
                WbSdkProgressBar wbSdkProgressBar = new WbSdkProgressBar(this);
                if (intExtra != -1) {
                    wbSdkProgressBar.setProgressColor(intExtra);
                }
                view2 = wbSdkProgressBar;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.rootLayout.addView(view2, layoutParams);
            this.rootLayout.setBackgroundColor(855638016);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCallback(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, this, i) == null) {
            FrameLayout frameLayout = this.rootLayout;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            try {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putInt(WBConstants.Response.ERRCODE, i);
                intent.putExtras(bundle);
                setResult(-1, intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Handler handler = this.handler;
            if (handler != null) {
                handler.removeMessages(0);
                this.handler = null;
            }
            finish();
        }
    }

    private void transPicAndVideoResource(WeiboMultiMessage weiboMultiMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, weiboMultiMessage) == null) {
            setContentView(this.rootLayout);
            if (weiboMultiMessage.multiImageObject == null && weiboMultiMessage.videoSourceObject == null) {
                gotoWeiboComposer(weiboMultiMessage);
                return;
            }
            CopyResourceTask copyResourceTask = this.copyResourceTask;
            if (copyResourceTask != null) {
                copyResourceTask.cancel(true);
            }
            CopyResourceTask copyResourceTask2 = new CopyResourceTask(this, new TransResourceCallback(this) { // from class: com.sina.weibo.sdk.share.WbShareTransActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WbShareTransActivity this$0;

                @Override // com.sina.weibo.sdk.share.TransResourceCallback
                public void onTransFinish(StoryObject storyObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, storyObject) == null) {
                    }
                }

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.sina.weibo.sdk.share.TransResourceCallback
                public void onTransFinish(TransResourceResult transResourceResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, transResourceResult) == null) {
                        this.this$0.rootLayout.setVisibility(4);
                        if (transResourceResult == null || !transResourceResult.transDone) {
                            this.this$0.sendCallback(2);
                        } else {
                            this.this$0.gotoWeiboComposer(transResourceResult.message);
                        }
                    }
                }
            });
            this.copyResourceTask = copyResourceTask2;
            copyResourceTask2.execute(weiboMultiMessage);
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            Handler handler = this.handler;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(0, 100L);
            }
        }
    }
}
