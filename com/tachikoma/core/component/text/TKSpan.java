package com.tachikoma.core.component.text;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8Array;
import com.kwad.v8.V8Function;
import com.kwad.v8.V8Object;
import com.tachikoma.annotation.TK_EXPORT_CLASS;
import com.tachikoma.core.bridge.JSContext;
import com.tachikoma.core.component.TKBase;
import com.tachikoma.core.exception.TKExceptionDispatcher;
import com.tachikoma.core.log.Logger;
import com.tachikoma.core.utility.TKAsync;
import com.tachikoma.core.utility.TKColorUtil;
import com.tachikoma.core.utility.TKConverter;
import com.tachikoma.core.utility.UIThreadUtil;
import com.tachikoma.core.utility.V8Proxy;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@TK_EXPORT_CLASS
/* loaded from: classes4.dex */
public class TKSpan extends TKBase<View> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float DP;
    public static final String IMAGE_PLACE_HOLDER = " ";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public final Map<SpanItem, V8Function> mItemFunctions;
    public final List<JSContext.V8AssociateReference> mSpanAsoRefList;
    public final List<SpanItem> mSpanItems;
    public List<SpanItemData> mSpans;

    /* loaded from: classes4.dex */
    public static class SpanItemData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mEnd;
        public Object mSpan;
        public int mStart;

        public SpanItemData(Object obj, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mSpan = obj;
            this.mStart = i2;
            this.mEnd = i3;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1782603264, "Lcom/tachikoma/core/component/text/TKSpan;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1782603264, "Lcom/tachikoma/core/component/text/TKSpan;");
                return;
            }
        }
        DP = Resources.getSystem().getDisplayMetrics().density;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TKSpan(Context context, List<Object> list) {
        super(context, list);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSpanAsoRefList = new ArrayList();
        this.mItemFunctions = new HashMap();
        this.mContext = context;
        this.mSpanItems = new ArrayList();
        this.mSpans = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SpannableString appendImagePlaceHolder(SpannableString spannableString, SpanItem spanItem) {
        InterceptResult invokeLL;
        StringBuilder sb;
        Object obj;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, spannableString, spanItem)) == null) {
            String spannableString2 = spannableString.toString();
            int i3 = spanItem.index;
            if (i3 < 1) {
                sb = new StringBuilder();
                sb.append(" ");
            } else if (i3 > spannableString2.length()) {
                sb = new StringBuilder();
                sb.append(spannableString2);
                sb.append(" ");
                SpannableString spannableString3 = new SpannableString(sb.toString());
                if (this.mSpans.size() > 0) {
                    for (SpanItemData spanItemData : this.mSpans) {
                        int i4 = spanItem.index;
                        int i5 = spanItemData.mStart;
                        if (i4 <= i5 || i4 >= (i2 = spanItemData.mEnd)) {
                            int i6 = spanItem.index;
                            int i7 = spanItemData.mEnd;
                            if (i6 > i7) {
                                spannableString3.setSpan(spanItemData.mSpan, spanItemData.mStart, i7, 17);
                            } else {
                                int i8 = spanItemData.mStart;
                                if (i6 < i8 || i6 == i8) {
                                    obj = spanItemData.mSpan;
                                    i8++;
                                } else if (i6 == i7) {
                                    obj = spanItemData.mSpan;
                                }
                                spannableString3.setSpan(obj, i8, i7 + 1, 17);
                            }
                        } else {
                            spannableString3.setSpan(spanItemData.mSpan, i5, i2 + 1, 17);
                        }
                    }
                }
                return spannableString3;
            } else {
                sb = new StringBuilder();
                sb.append(spannableString2.substring(0, spanItem.index));
                sb.append(" ");
                spannableString2 = spannableString2.substring(spanItem.index);
            }
            sb.append(spannableString2);
            SpannableString spannableString32 = new SpannableString(sb.toString());
            if (this.mSpans.size() > 0) {
            }
            return spannableString32;
        }
        return (SpannableString) invokeLL.objValue;
    }

    private void fetchBitmapAndSetImageSpan(SpanItem spanItem, SpannableString spannableString, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, this, spanItem, spannableString, textView) == null) {
            TKAsync.execute(new Runnable(this, spanItem, spannableString, textView) { // from class: com.tachikoma.core.component.text.TKSpan.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TKSpan this$0;
                public final /* synthetic */ SpanItem val$item;
                public final /* synthetic */ SpannableString val$spanString;
                public final /* synthetic */ TextView val$textView;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, spanItem, spannableString, textView};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$item = spanItem;
                    this.val$spanString = spannableString;
                    this.val$textView = textView;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        InputStream inputStream = null;
                        try {
                            try {
                                try {
                                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.val$item.imageUrl).openConnection();
                                    httpURLConnection.setConnectTimeout(5000);
                                    httpURLConnection.connect();
                                    if (httpURLConnection.getResponseCode() == 200) {
                                        inputStream = httpURLConnection.getInputStream();
                                        UIThreadUtil.runOnUiThread(new Runnable(this, BitmapFactory.decodeStream(inputStream)) { // from class: com.tachikoma.core.component.text.TKSpan.2.1
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;
                                            public final /* synthetic */ AnonymousClass2 this$1;
                                            public final /* synthetic */ Bitmap val$bitmap;

                                            {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 != null) {
                                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                                    newInitContext.initArgs = r2;
                                                    Object[] objArr = {this, r7};
                                                    interceptable3.invokeUnInit(65536, newInitContext);
                                                    int i2 = newInitContext.flag;
                                                    if ((i2 & 1) != 0) {
                                                        int i3 = i2 & 2;
                                                        newInitContext.thisArg = this;
                                                        interceptable3.invokeInitBody(65536, newInitContext);
                                                        return;
                                                    }
                                                }
                                                this.this$1 = this;
                                                this.val$bitmap = r7;
                                            }

                                            @Override // java.lang.Runnable
                                            public void run() {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                    AnonymousClass2 anonymousClass2 = this.this$1;
                                                    SpannableString appendImagePlaceHolder = anonymousClass2.this$0.appendImagePlaceHolder(anonymousClass2.val$spanString, anonymousClass2.val$item);
                                                    this.this$1.this$0.setImageSpan(new BitmapDrawable(this.this$1.this$0.mContext.getResources(), this.val$bitmap), appendImagePlaceHolder, this.this$1.val$item);
                                                    TextView textView2 = this.this$1.val$textView;
                                                    if (textView2 != null) {
                                                        textView2.setText(appendImagePlaceHolder);
                                                    }
                                                }
                                            }
                                        });
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                } catch (Exception e2) {
                                    Logger.logE("fetchSpanBitmap", e2);
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                }
                            } catch (IOException e3) {
                                Logger.logE("fetchSpanBitmap close io", e3);
                            }
                        } catch (Throwable th) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e4) {
                                    Logger.logE("fetchSpanBitmap close io", e4);
                                }
                            }
                            throw th;
                        }
                    }
                }
            });
        }
    }

    private Drawable getSpanDrawable(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65545, this, str)) != null) {
            return (Drawable) invokeL.objValue;
        }
        BitmapDrawable bitmapDrawable = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String concat = getRootDir().concat(str);
            if (new File(concat).exists()) {
                BitmapDrawable bitmapDrawable2 = new BitmapDrawable(BitmapFactory.decodeFile(concat));
                try {
                    bitmapDrawable2.setBounds(0, 0, bitmapDrawable2.getIntrinsicWidth(), bitmapDrawable2.getIntrinsicHeight());
                    return bitmapDrawable2;
                } catch (Exception e2) {
                    e = e2;
                    bitmapDrawable = bitmapDrawable2;
                    Logger.logE("getSpanDrawable", e);
                    return bitmapDrawable;
                }
            }
            return null;
        } catch (Exception e3) {
            e = e3;
        }
    }

    private void setFontFamilySpan(SpannableString spannableString, SpanItem spanItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, this, spannableString, spanItem) == null) || TextUtils.isEmpty(spanItem.fontFamily)) {
            return;
        }
        Typeface typeface = FontManager.getInstance().getTypeface(spanItem.fontFamily, 0, this.mContext.getAssets(), getRootDir().concat(spanItem.fontFamily));
        if (typeface != null) {
            CustomTypefaceSpan customTypefaceSpan = new CustomTypefaceSpan(null, typeface);
            spannableString.setSpan(customTypefaceSpan, spanItem.start, spanItem.end, 17);
            this.mSpans.add(new SpanItemData(customTypefaceSpan, spanItem.start, spanItem.end));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageSpan(Drawable drawable, SpannableString spannableString, SpanItem spanItem) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65547, this, drawable, spannableString, spanItem) == null) || drawable == null) {
            return;
        }
        CenterImageSpan centerImageSpan = new CenterImageSpan(drawable, "");
        int i3 = spanItem.imageWidth;
        centerImageSpan.setImageRect((i3 <= 0 || spanItem.imageHeight <= 0) ? drawable.getIntrinsicWidth() : (int) TKConverter.dp2px(this.mContext, i3), (spanItem.imageWidth <= 0 || (i2 = spanItem.imageHeight) <= 0) ? drawable.getIntrinsicHeight() : (int) TKConverter.dp2px(this.mContext, i2)).setMarginLeft(TKConverter.dp2px(this.mContext, spanItem.marginLeft)).setMarginRight(TKConverter.dp2px(this.mContext, spanItem.marginRight)).setOffsetY(TKConverter.dp2px(this.mContext, spanItem.offsetY));
        int i4 = spanItem.index;
        spannableString.setSpan(centerImageSpan, i4, i4 + 1, 17);
    }

    private void setSizeSpan(SpannableString spannableString, SpanItem spanItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, this, spannableString, spanItem) == null) || spanItem.size <= 0) {
            return;
        }
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan((int) (spanItem.size * DP));
        spannableString.setSpan(absoluteSizeSpan, spanItem.start, spanItem.end, 17);
        this.mSpans.add(new SpanItemData(absoluteSizeSpan, spanItem.start, spanItem.end));
    }

    private void setStyleSpan(SpannableString spannableString, SpanItem spanItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, this, spannableString, spanItem) == null) {
            StyleSpan styleSpan = new StyleSpan(SpanItem.STYLE_BOLD.equals(spanItem.textStyle) ? 1 : SpanItem.STYLE_BOLD_ITALIC.equals(spanItem.textStyle) ? 3 : SpanItem.STYLE_ITALIC.equals(spanItem.textStyle) ? 2 : 0);
            spannableString.setSpan(styleSpan, spanItem.start, spanItem.end, 17);
            this.mSpans.add(new SpanItemData(styleSpan, spanItem.start, spanItem.end));
        }
    }

    public void addSpan(V8Object v8Object) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, v8Object) == null) {
            JSContext.V8AssociateReference associateReference = this.mTKJSContext.context().getAssociateReference(v8Object);
            this.mSpanItems.add((SpanItem) associateReference.nativeObject);
            this.mSpanAsoRefList.add(associateReference);
        }
    }

    @Override // com.tachikoma.core.component.TKBase
    public View createViewInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return null;
        }
        return (View) invokeL.objValue;
    }

    public CharSequence getSpannableString(String str, TextView textView) {
        InterceptResult invokeLL;
        List<SpanItemData> list;
        SpanItemData spanItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, textView)) == null) {
            SpannableString spannableString = new SpannableString(str);
            for (SpanItem spanItem : this.mSpanItems) {
                String str2 = spanItem.spanType;
                char c2 = 65535;
                switch (str2.hashCode()) {
                    case -1224696685:
                        if (str2.equals(SpanItem.TYPE_FONT_FAMILY)) {
                            c2 = '\b';
                            break;
                        }
                        break;
                    case -1134113256:
                        if (str2.equals(SpanItem.TYPE_ABSOLUTE_SIZE)) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -1048634236:
                        if (str2.equals(SpanItem.TYPE_TEXT_STYLE)) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case -1027917076:
                        if (str2.equals(SpanItem.TYPE_UNDERLINE)) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case -641062944:
                        if (str2.equals(SpanItem.TYPE_FOREGROUND_COLOR)) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 116079:
                        if (str2.equals("url")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 94750088:
                        if (str2.equals("click")) {
                            c2 = '\t';
                            break;
                        }
                        break;
                    case 100313435:
                        if (str2.equals("image")) {
                            c2 = 7;
                            break;
                        }
                        break;
                    case 692131507:
                        if (str2.equals(SpanItem.TYPE_STRIKE_THROUGH)) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 1287124693:
                        if (str2.equals("backgroundColor")) {
                            c2 = 1;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        URLSpan uRLSpan = new URLSpan(spanItem.url);
                        spannableString.setSpan(uRLSpan, spanItem.start, spanItem.end, 17);
                        list = this.mSpans;
                        spanItemData = new SpanItemData(uRLSpan, spanItem.start, spanItem.end);
                        list.add(spanItemData);
                        break;
                    case 1:
                        if (TextUtils.isEmpty(spanItem.color)) {
                            break;
                        } else {
                            BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(Color.parseColor(TKColorUtil.rgba2argb(spanItem.color)));
                            spannableString.setSpan(backgroundColorSpan, spanItem.start, spanItem.end, 17);
                            list = this.mSpans;
                            spanItemData = new SpanItemData(backgroundColorSpan, spanItem.start, spanItem.end);
                            list.add(spanItemData);
                            break;
                        }
                    case 2:
                        if (TextUtils.isEmpty(spanItem.color)) {
                            break;
                        } else {
                            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor(TKColorUtil.rgba2argb(spanItem.color)));
                            spannableString.setSpan(foregroundColorSpan, spanItem.start, spanItem.end, 17);
                            list = this.mSpans;
                            spanItemData = new SpanItemData(foregroundColorSpan, spanItem.start, spanItem.end);
                            list.add(spanItemData);
                            break;
                        }
                    case 3:
                        setSizeSpan(spannableString, spanItem);
                        break;
                    case 4:
                        setStyleSpan(spannableString, spanItem);
                        break;
                    case 5:
                        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
                        spannableString.setSpan(strikethroughSpan, spanItem.start, spanItem.end, 17);
                        list = this.mSpans;
                        spanItemData = new SpanItemData(strikethroughSpan, spanItem.start, spanItem.end);
                        list.add(spanItemData);
                        break;
                    case 6:
                        UnderlineSpan underlineSpan = new UnderlineSpan();
                        spannableString.setSpan(underlineSpan, spanItem.start, spanItem.end, 17);
                        list = this.mSpans;
                        spanItemData = new SpanItemData(underlineSpan, spanItem.start, spanItem.end);
                        list.add(spanItemData);
                        break;
                    case 7:
                        if (TextUtils.isEmpty(spanItem.imageUrl)) {
                            break;
                        } else if (spanItem.imageUrl.startsWith("http")) {
                            fetchBitmapAndSetImageSpan(spanItem, spannableString, textView);
                            break;
                        } else {
                            spannableString = appendImagePlaceHolder(spannableString, spanItem);
                            setImageSpan(getSpanDrawable(spanItem.imageUrl), spannableString, spanItem);
                            break;
                        }
                    case '\b':
                        setFontFamilySpan(spannableString, spanItem);
                        setSizeSpan(spannableString, spanItem);
                        setStyleSpan(spannableString, spanItem);
                        break;
                    case '\t':
                        V8Function v8Function = spanItem.getV8Function();
                        if (V8Proxy.isV8Valid(v8Function)) {
                            V8Function twin = v8Function.twin();
                            V8Function v8Function2 = this.mItemFunctions.get(spanItem);
                            if (v8Function2 != null) {
                                V8Proxy.release(v8Function2);
                            }
                            this.mItemFunctions.put(spanItem, twin);
                            textView.setMovementMethod(LinkMovementMethod.getInstance());
                            spannableString.setSpan(new ClickableSpan(this, spanItem) { // from class: com.tachikoma.core.component.text.TKSpan.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ TKSpan this$0;
                                public final /* synthetic */ SpanItem val$item;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, spanItem};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                    this.val$item = spanItem;
                                }

                                @Override // android.text.style.ClickableSpan
                                public void onClick(@NonNull View view) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                        V8Function v8Function3 = (V8Function) this.this$0.mItemFunctions.get(this.val$item);
                                        if (V8Proxy.isV8Valid(v8Function3)) {
                                            try {
                                                v8Function3.call(null, new V8Array(v8Function3.getRuntime()));
                                            } catch (Throwable th) {
                                                TKExceptionDispatcher.reportException(this.this$0.mTKJSContext, th);
                                            }
                                        }
                                    }
                                }

                                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                                public void updateDrawState(@NonNull TextPaint textPaint) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                                        super.updateDrawState(textPaint);
                                        String str3 = this.val$item.color;
                                        if (str3 != null) {
                                            textPaint.setColor(Color.parseColor(str3));
                                        }
                                        textPaint.setUnderlineText(false);
                                    }
                                }
                            }, spanItem.start, spanItem.end, 17);
                            break;
                        } else {
                            break;
                        }
                }
            }
            return spannableString;
        }
        return (CharSequence) invokeLL.objValue;
    }

    @Override // com.tachikoma.core.component.TKBase, com.tachikoma.core.common.ILifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            JSContext.V8AssociateReference.closeAllReference(this.mSpanAsoRefList.iterator());
            this.mSpanAsoRefList.clear();
            for (Map.Entry<SpanItem, V8Function> entry : this.mItemFunctions.entrySet()) {
                V8Proxy.release(entry.getValue());
            }
            this.mItemFunctions.clear();
        }
    }
}
