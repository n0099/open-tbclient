package com.sina.weibo.sdk.share;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.IntentConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.api.StoryMessage;
import com.sina.weibo.sdk.api.StoryObject;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.web.view.WbSdkProgressBar;
/* loaded from: classes9.dex */
public class WbShareToStoryActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String callbackActivity;
    public View progressBar;
    public int progressColor;
    public int progressId;
    public FrameLayout rootLayout;
    public SaveFileTask saveFileTask;

    public WbShareToStoryActivity() {
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
        this.progressColor = -1;
        this.progressId = -1;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
        }
    }

    private boolean checkInfo(StoryMessage storyMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, storyMessage)) == null) {
            if (storyMessage.checkSource() && WbSdk.supportMultiImage(this)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void gotoSave(StoryMessage storyMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, storyMessage) == null) {
            SaveFileTask saveFileTask = this.saveFileTask;
            if (saveFileTask != null) {
                saveFileTask.cancel(true);
            }
            SaveFileTask saveFileTask2 = new SaveFileTask(this, new TransResourceCallback(this) { // from class: com.sina.weibo.sdk.share.WbShareToStoryActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WbShareToStoryActivity this$0;

                @Override // com.sina.weibo.sdk.share.TransResourceCallback
                public void onTransFinish(TransResourceResult transResourceResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, transResourceResult) == null) {
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
                public void onTransFinish(StoryObject storyObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, storyObject) == null) {
                        if (storyObject == null) {
                            this.this$0.setCallbackActivity(2);
                            return;
                        }
                        try {
                            Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse("sinaweibo://story/publish?forceedit=1&finish=true"));
                            intent.setPackage(intent.getStringExtra(WBConstants.SHARE_START_PACKAGE));
                            intent.putExtra("storyData", storyObject);
                            this.this$0.startActivity(intent);
                        } catch (Exception unused) {
                            this.this$0.setCallbackActivity(2);
                        }
                    }
                }
            });
            this.saveFileTask = saveFileTask2;
            saveFileTask2.execute(storyMessage);
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            super.onNewIntent(intent);
            try {
                i = intent.getIntExtra("backType", 0);
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 0) {
                setCallbackActivity(1);
            } else {
                setCallbackActivity(0);
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString(WBConstants.SHARE_START_ACTIVITY, this.callbackActivity);
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            try {
                this.progressColor = getIntent().getIntExtra(WBConstants.TRANS_PROGRESS_COLOR, -1);
                this.progressId = getIntent().getIntExtra(WBConstants.TRANS_PROGRESS_ID, -1);
            } catch (Exception unused) {
            }
            this.rootLayout = new FrameLayout(this);
            if (this.progressId != -1) {
                try {
                    this.progressBar = ((LayoutInflater) getSystemService("layout_inflater")).inflate(this.progressId, (ViewGroup) null);
                } catch (Exception unused2) {
                    this.progressBar = new WbSdkProgressBar(this);
                }
            } else {
                WbSdkProgressBar wbSdkProgressBar = new WbSdkProgressBar(this);
                this.progressBar = wbSdkProgressBar;
                int i = this.progressColor;
                if (i != -1) {
                    wbSdkProgressBar.setProgressColor(i);
                }
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.rootLayout.addView(this.progressBar, layoutParams);
            this.rootLayout.setBackgroundColor(855638016);
            setContentView(this.rootLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallbackActivity(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65541, this, i) == null) {
            FrameLayout frameLayout = this.rootLayout;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            try {
                Intent intent = new Intent();
                intent.putExtra(WBConstants.Response.ERRCODE, i);
                setResult(-1, intent);
            } catch (Exception e) {
                LogUtil.v("weibo sdk", e.toString());
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.sina.weibo.sdk.share.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            Intent intent = getIntent();
            if (intent == null) {
                return;
            }
            try {
                if (bundle != null) {
                    this.callbackActivity = bundle.getString(WBConstants.SHARE_START_ACTIVITY);
                } else {
                    this.callbackActivity = intent.getStringExtra(WBConstants.SHARE_START_ACTIVITY);
                }
            } catch (Exception unused) {
            }
            if (intent.getIntExtra(WBConstants.SHARE_START_FLAG, -1) != 0) {
                finish();
            } else if (TextUtils.isEmpty(this.callbackActivity)) {
                finish();
            } else {
                StoryMessage storyMessage = null;
                try {
                    storyMessage = (StoryMessage) getIntent().getParcelableExtra(WBConstants.Msg.STORY);
                } catch (Exception unused2) {
                }
                if (storyMessage == null) {
                    setCallbackActivity(2);
                } else if (checkInfo(storyMessage)) {
                    initView();
                    gotoSave(storyMessage);
                } else {
                    setCallbackActivity(2);
                }
            }
        }
    }
}
