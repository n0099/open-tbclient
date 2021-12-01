package com.tachikoma.core.component.imageview;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.filter.FilterValue;
import com.kwad.sdk.e.d;
import com.kwad.sdk.e.f;
import com.tachikoma.annotation.TK_EXPORT_CLASS;
import com.tachikoma.core.Tachikoma;
import com.tachikoma.core.api.IWebImageHandlerInner;
import com.tachikoma.core.component.TKBase;
import com.tachikoma.core.config.BlockOptConfig;
import com.tachikoma.core.log.Logger;
import com.tachikoma.core.manager.TKModuleManager;
import com.tachikoma.core.utility.FileUtil;
import com.tachikoma.core.utility.TKAsync;
import com.tachikoma.core.utility.TKColorUtil;
import com.tachikoma.core.utility.TKConverter;
import com.tachikoma.core.utility.TKUtility;
import com.tachikoma.core.utility.UriUtil;
import java.io.File;
import java.util.List;
@TK_EXPORT_CLASS
/* loaded from: classes2.dex */
public class TKImage extends TKBase<RoundImageView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int blurRadius;
    public final Handler mHandler;
    public String mPlaceHolder;
    public long setId;
    @Deprecated
    public String src;
    public String uri;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TKImage(Context context, List<Object> list) {
        super(context, list);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHandler = new Handler();
        this.setId = 0L;
    }

    private int calculateInSampleSize(BitmapFactory.Options options, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, this, options, i2, i3)) == null) {
            int i4 = options.outHeight;
            int i5 = options.outWidth;
            int i6 = 1;
            if (i4 > i3 || i5 > i2) {
                int i7 = i4 / 2;
                int i8 = i5 / 2;
                while (i7 / i6 > i3 && i8 / i6 > i2) {
                    i6 *= 2;
                }
            }
            return i6;
        }
        return invokeLII.intValue;
    }

    private BitmapFactory.Options getBoundsOptions(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            return options;
        }
        return (BitmapFactory.Options) invokeL.objValue;
    }

    private BitmapFactory.Options getSampleSizeOptions(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, str)) == null) {
            BitmapFactory.Options boundsOptions = getBoundsOptions(str);
            boundsOptions.inJustDecodeBounds = false;
            boundsOptions.inSampleSize = calculateInSampleSize(boundsOptions, (int) getDomNode().getYogaNode().getWidth().value, (int) getDomNode().getYogaNode().getHeight().value);
            return boundsOptions;
        }
        return (BitmapFactory.Options) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUrls(List<TKCDNUrlInner> list, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65543, this, list, i2, i3) == null) {
            IWebImageHandlerInner iWebImageHandlerInner = (IWebImageHandlerInner) TKModuleManager.getInstance().getHandler(this.mTKJSContext, IWebImageHandlerInner.class);
            if (list == null || list.isEmpty()) {
                iWebImageHandlerInner.load("", getView(), 0);
            } else if (TextUtils.isEmpty(this.mPlaceHolder)) {
                if (iWebImageHandlerInner != null) {
                    iWebImageHandlerInner.load(getView(), list, i2, i3, this.blurRadius);
                }
            } else {
                String concat = getRootDir().concat(this.mPlaceHolder);
                BitmapDrawable bitmapDrawable = new File(concat).exists() ? new BitmapDrawable(BitmapFactory.decodeFile(concat, getSampleSizeOptions(concat))) : null;
                if (iWebImageHandlerInner != null) {
                    iWebImageHandlerInner.load(getView(), list, i2, i3, bitmapDrawable, this.blurRadius);
                }
            }
        }
    }

    private void setUrlsAfterOpt(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65544, this, str, i2, i3) == null) {
            long j2 = this.setId + 1;
            this.setId = j2;
            setUrls((List<TKCDNUrlInner>) null, i2, i3);
            TKAsync.execute(new Runnable(this, str, j2, i2, i3) { // from class: com.tachikoma.core.component.imageview.TKImage.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TKImage this$0;
                public final /* synthetic */ String val$cdnUrlsJson;
                public final /* synthetic */ long val$currentId;
                public final /* synthetic */ int val$height;
                public final /* synthetic */ int val$width;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$cdnUrlsJson = str;
                    this.val$currentId = j2;
                    this.val$width = i2;
                    this.val$height = i3;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.this$0.mHandler.post(new Runnable(this, f.a(this.val$cdnUrlsJson, new d<TKCDNUrlInner>(this) { // from class: com.tachikoma.core.component.imageview.TKImage.2.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass2 this$1;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i4 = newInitContext.flag;
                                        if ((i4 & 1) != 0) {
                                            int i5 = i4 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                }

                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.kwad.sdk.e.d
                                public TKCDNUrlInner createInstance() {
                                    InterceptResult invokeV;
                                    Interceptable interceptable3 = $ic;
                                    return (interceptable3 == null || (invokeV = interceptable3.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new TKCDNUrlInner() : (TKCDNUrlInner) invokeV.objValue;
                                }
                            })) { // from class: com.tachikoma.core.component.imageview.TKImage.2.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass2 this$1;
                                public final /* synthetic */ List val$list;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, r7};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i4 = newInitContext.flag;
                                        if ((i4 & 1) != 0) {
                                            int i5 = i4 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                    this.val$list = r7;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        AnonymousClass2 anonymousClass2 = this.this$1;
                                        if (anonymousClass2.val$currentId == anonymousClass2.this$0.setId) {
                                            AnonymousClass2 anonymousClass22 = this.this$1;
                                            anonymousClass22.this$0.setUrls(this.val$list, anonymousClass22.val$width, anonymousClass22.val$height);
                                        }
                                    }
                                }
                            });
                        } catch (Exception e2) {
                            Logger.logE("TKImage TKCDNUrlInner fromJson exception", e2);
                        }
                    }
                }
            });
        }
    }

    private void setUrlsBeforeOpt(String str, int i2, int i3) {
        List<TKCDNUrlInner> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65545, this, str, i2, i3) == null) {
            try {
                list = f.a(str, new d<TKCDNUrlInner>(this) { // from class: com.tachikoma.core.component.imageview.TKImage.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TKImage this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.kwad.sdk.e.d
                    public TKCDNUrlInner createInstance() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new TKCDNUrlInner() : (TKCDNUrlInner) invokeV.objValue;
                    }
                });
            } catch (Exception e2) {
                Logger.logE("TKImage TKCDNUrlInner fromJson exception", e2);
                list = null;
            }
            if (list == null || list.isEmpty()) {
                return;
            }
            IWebImageHandlerInner iWebImageHandlerInner = (IWebImageHandlerInner) TKModuleManager.getInstance().getHandler(this.mTKJSContext, IWebImageHandlerInner.class);
            if (TextUtils.isEmpty(this.mPlaceHolder)) {
                if (iWebImageHandlerInner != null) {
                    iWebImageHandlerInner.load(getView(), list, i2, i3, this.blurRadius);
                    return;
                }
                return;
            }
            String concat = getRootDir().concat(this.mPlaceHolder);
            BitmapDrawable bitmapDrawable = new File(concat).exists() ? new BitmapDrawable(BitmapFactory.decodeFile(concat, getSampleSizeOptions(concat))) : null;
            if (iWebImageHandlerInner != null) {
                iWebImageHandlerInner.load(getView(), list, i2, i3, bitmapDrawable, this.blurRadius);
            }
        }
    }

    private void showAssetImage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            getView().setImageResource(TKUtility.getResourceId(UriUtil.getResName(this.uri), "drawable", null));
        }
    }

    private void showBundleImage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            String concat = getRootDir().concat(UriUtil.getMappedPath(this.uri, UriUtil.BUNDLE_PREFIX));
            if (FileUtil.exists(concat)) {
                getView().setImageBitmap(BitmapFactory.decodeFile(concat, getSampleSizeOptions(concat)));
            }
        }
    }

    private void showFileImage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            String mappedPath = UriUtil.getMappedPath(this.uri, "file://");
            if (FileUtil.exists(mappedPath)) {
                getView().setImageBitmap(BitmapFactory.decodeFile(mappedPath, getSampleSizeOptions(mappedPath)));
            }
        }
    }

    private void showNetImage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            IWebImageHandlerInner iWebImageHandlerInner = (IWebImageHandlerInner) TKModuleManager.getInstance().getHandler(this.mTKJSContext, IWebImageHandlerInner.class);
            if (iWebImageHandlerInner == null) {
                Logger.logE("TKImage", new IllegalStateException("IWebImageHandlerInner is null"));
            } else if (TextUtils.isEmpty(this.mPlaceHolder)) {
                iWebImageHandlerInner.load(this.uri, getView(), this.blurRadius);
            } else {
                String concat = getRootDir().concat(this.mPlaceHolder);
                iWebImageHandlerInner.load(getView(), this.uri, FileUtil.exists(concat) ? new BitmapDrawable(BitmapFactory.decodeFile(concat, getSampleSizeOptions(concat))) : null, this.blurRadius);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tachikoma.core.component.TKBase
    public RoundImageView createViewInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? new RoundImageView(context) : (RoundImageView) invokeL.objValue;
    }

    @Override // com.tachikoma.core.component.TKBase, com.tachikoma.core.common.ILifeCycle
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onCreate();
        }
    }

    @Override // com.tachikoma.core.component.TKBase, com.tachikoma.core.common.ILifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.tachikoma.core.component.TKBase
    public void onShadowSet(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f2) == null) {
            super.onShadowSet(f2);
            getView().onShadowSet(f2);
        }
    }

    public void setBlurRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.blurRadius = i2;
        }
    }

    @Override // com.tachikoma.core.component.TKBase
    public void setBorderColor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            super.setBorderColor(str);
            getView().setBorderColor(Color.parseColor(TKColorUtil.rgba2argb(str)));
        }
    }

    @Override // com.tachikoma.core.component.TKBase
    public void setBorderRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.setBorderRadius(i2);
            getView().setBorderRadius(i2);
        }
    }

    @Override // com.tachikoma.core.component.TKBase
    public void setBorderWidth(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Double.valueOf(d2)}) == null) {
            super.setBorderWidth(d2);
            getView().setBorderWidth(TKConverter.dp2px(Tachikoma.sApplication, (float) d2));
        }
    }

    @Override // com.tachikoma.core.component.TKBase
    public void setBottomLeftRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            super.setBottomLeftRadius(i2);
            getView().setBottomLeftRoundRadius(TKConverter.dp2px(Tachikoma.sApplication, i2));
        }
    }

    @Override // com.tachikoma.core.component.TKBase
    public void setBottomRightRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            super.setBottomRightRadius(i2);
            getView().setBottomRightRoundRadius(TKConverter.dp2px(Tachikoma.sApplication, i2));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void setContentMode(String str) {
        char c2;
        RoundImageView view;
        ImageView.ScaleType scaleType;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            switch (str.hashCode()) {
                case -1881872635:
                    if (str.equals("stretch")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1008619738:
                    if (str.equals(FilterValue.DEFAULT_FILTER_VALUE)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 94852023:
                    if (str.equals(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 951526612:
                    if (str.equals("contain")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                view = getView();
                scaleType = ImageView.ScaleType.FIT_START;
            } else if (c2 == 1) {
                view = getView();
                scaleType = ImageView.ScaleType.FIT_CENTER;
            } else if (c2 == 2) {
                view = getView();
                scaleType = ImageView.ScaleType.CENTER_CROP;
            } else if (c2 != 3) {
                return;
            } else {
                view = getView();
                scaleType = ImageView.ScaleType.FIT_XY;
            }
            view.setScaleType(scaleType);
        }
    }

    public void setPlaceholder(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.mPlaceHolder = str;
        }
    }

    @Deprecated
    public void setSrc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.src = str;
            if (str.startsWith("//")) {
                this.src = UrlSchemaHelper.SCHEMA_TYPE_HTTPS + this.src;
            }
            if (!this.src.startsWith("http")) {
                String concat = getRootDir().concat(this.src);
                if (new File(concat).exists()) {
                    getView().setImageBitmap(BitmapFactory.decodeFile(concat, getSampleSizeOptions(concat)));
                    return;
                } else {
                    getView().setImageResource(TKUtility.getResourceId(this.src, "drawable", null));
                    return;
                }
            }
            IWebImageHandlerInner iWebImageHandlerInner = (IWebImageHandlerInner) TKModuleManager.getInstance().getHandler(this.mTKJSContext, IWebImageHandlerInner.class);
            if (TextUtils.isEmpty(this.mPlaceHolder)) {
                if (iWebImageHandlerInner != null) {
                    iWebImageHandlerInner.load(this.src, getView(), this.blurRadius);
                    return;
                }
                return;
            }
            String concat2 = getRootDir().concat(this.mPlaceHolder);
            BitmapDrawable bitmapDrawable = new File(concat2).exists() ? new BitmapDrawable(BitmapFactory.decodeFile(concat2, getSampleSizeOptions(concat2))) : null;
            if (iWebImageHandlerInner != null) {
                iWebImageHandlerInner.load(getView(), this.src, bitmapDrawable, this.blurRadius);
            }
        }
    }

    @Override // com.tachikoma.core.component.TKBase
    public void setTopLeftRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            super.setTopLeftRadius(i2);
            getView().setTopLeftRoundRadius(TKConverter.dp2px(Tachikoma.sApplication, i2));
        }
    }

    @Override // com.tachikoma.core.component.TKBase
    public void setTopRightRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            super.setTopRightRadius(i2);
            getView().setTopRightRoundRadius(TKConverter.dp2px(Tachikoma.sApplication, i2));
        }
    }

    public void setUri(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.uri = str;
            if (str == null || str.length() <= 0) {
                return;
            }
            try {
                if (str.startsWith("asset://")) {
                    showAssetImage();
                    return;
                }
                if (!str.startsWith(UriUtil.BUNDLE_PREFIX)) {
                    if (str.startsWith("file://")) {
                        showFileImage();
                        return;
                    } else if (str.startsWith("https://") || str.startsWith("http://")) {
                        showNetImage();
                        return;
                    }
                }
                showBundleImage();
            } catch (Throwable th) {
                Logger.logE("TKImage", th);
            }
        }
    }

    public void setUrls(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048593, this, str, i2, i3) == null) {
            if (BlockOptConfig.blockOpt()) {
                setUrlsAfterOpt(str, i2, i3);
            } else {
                setUrlsBeforeOpt(str, i2, i3);
            }
        }
    }
}
