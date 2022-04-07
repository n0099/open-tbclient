package com.tachikoma.core;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tachikoma.core.component.TKBase;
import com.tachikoma.core.component.anim.AnimationProperty;
import com.tachikoma.core.component.button.TKButton;
import com.tachikoma.core.component.imageview.TKImage;
import com.tachikoma.core.component.input.TKInput;
import com.tachikoma.core.component.input.TKTextArea;
import com.tachikoma.core.component.listview.TKIndicator;
import com.tachikoma.core.component.listview.TKListView;
import com.tachikoma.core.component.listview.TKRecyclerView;
import com.tachikoma.core.component.listview.TKViewPager;
import com.tachikoma.core.component.listview.TKWaterListView;
import com.tachikoma.core.component.progressbar.KTProgressBarView;
import com.tachikoma.core.component.recyclerview.export.TKRefreshAnimatableView;
import com.tachikoma.core.component.recyclerview.export.TKRefreshControl;
import com.tachikoma.core.component.switchview.TKSwitch;
import com.tachikoma.core.component.text.SpanItem;
import com.tachikoma.core.component.text.TKMarqueeText;
import com.tachikoma.core.component.text.TKSpan;
import com.tachikoma.core.component.text.TKText;
import com.tachikoma.core.component.view.TKView;
import com.tachikoma.core.manager.IProvider;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class AttributeProvider implements IProvider<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AttributeProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static double trans(Number number) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, number)) == null) ? number.doubleValue() : invokeL.doubleValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tachikoma.core.manager.IProvider
    public void apply(String str, Object obj, HashMap<String, Object> hashMap) {
        char c;
        Object obj2;
        Object obj3;
        TKMarqueeText tKMarqueeText;
        TKText tKText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, obj, hashMap) == null) {
            switch (str.hashCode()) {
                case -1815682644:
                    if (str.equals("com.tachikoma.core.component.listview.TKWaterListView")) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case -1568538173:
                    if (str.equals("com.tachikoma.core.component.recyclerview.export.TKRefreshAnimatableView")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -1490734452:
                    if (str.equals("com.tachikoma.core.component.switchview.TKSwitch")) {
                        c = 15;
                        break;
                    }
                    c = 65535;
                    break;
                case -1414476437:
                    if (str.equals("com.tachikoma.core.component.text.TKMarqueeText")) {
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                case -1289269710:
                    if (str.equals("com.tachikoma.core.component.listview.TKRecyclerView")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case -1114153406:
                    if (str.equals("com.tachikoma.core.component.imageview.TKImage")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -698705626:
                    if (str.equals("com.tachikoma.core.component.progressbar.KTProgressBarView")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -665940655:
                    if (str.equals("com.tachikoma.core.component.button.TKButton")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -324017669:
                    if (str.equals("com.tachikoma.core.component.input.TKInput")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 58022346:
                    if (str.equals("com.tachikoma.core.component.text.SpanItem")) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case 100018365:
                    if (str.equals("com.tachikoma.core.component.recyclerview.export.TKRefreshControl")) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case 591158801:
                    if (str.equals("com.tachikoma.core.component.listview.TKListView")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 753880526:
                    if (str.equals("com.tachikoma.core.component.text.TKSpan")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 753900465:
                    if (str.equals("com.tachikoma.core.component.text.TKText")) {
                        c = 16;
                        break;
                    }
                    c = 65535;
                    break;
                case 791338032:
                    if (str.equals("com.tachikoma.core.component.listview.TKViewPager")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 801286025:
                    if (str.equals("com.tachikoma.core.component.input.TKTextArea")) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case 1584334001:
                    if (str.equals("com.tachikoma.core.component.view.TKView")) {
                        c = 17;
                        break;
                    }
                    c = 65535;
                    break;
                case 1666774561:
                    if (str.equals("com.tachikoma.core.component.listview.TKIndicator")) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    TKButton tKButton = (TKButton) obj;
                    if (hashMap.get("backgroundColor") != null) {
                        tKButton.setBackgroundColor(hashMap.get("backgroundColor"));
                    }
                    if (hashMap.get("backgroundImage") != null) {
                        tKButton.setBackgroundImage((String) hashMap.get("backgroundImage"));
                    }
                    if (hashMap.get("borderColor") != null) {
                        tKButton.setBorderColor((String) hashMap.get("borderColor"));
                    }
                    if (hashMap.get("borderRadius") != null) {
                        tKButton.setBorderRadius((int) trans((Number) hashMap.get("borderRadius")));
                    }
                    if (hashMap.get("borderStyle") != null) {
                        tKButton.setBorderStyle((String) hashMap.get("borderStyle"));
                    }
                    if (hashMap.get("borderWidth") != null) {
                        tKButton.setBorderWidth(trans((Number) hashMap.get("borderWidth")));
                    }
                    if (hashMap.get("bottomLeftRadius") != null) {
                        tKButton.setBottomLeftRadius((int) trans((Number) hashMap.get("bottomLeftRadius")));
                    }
                    if (hashMap.get("bottomRightRadius") != null) {
                        tKButton.setBottomRightRadius((int) trans((Number) hashMap.get("bottomRightRadius")));
                    }
                    if (hashMap.get("color") != null) {
                        tKButton.setColor((String) hashMap.get("color"));
                    }
                    if (hashMap.get(CriusAttrConstants.DISPLAY) != null) {
                        tKButton.setDisplay((String) hashMap.get(CriusAttrConstants.DISPLAY));
                    }
                    if (hashMap.get("fontFamily") != null) {
                        tKButton.setFontFamily((String) hashMap.get("fontFamily"));
                    }
                    if (hashMap.get(TtmlNode.ATTR_TTS_FONT_SIZE) != null) {
                        tKButton.setFontSize((int) trans((Number) hashMap.get(TtmlNode.ATTR_TTS_FONT_SIZE)));
                    }
                    if (hashMap.get(TtmlNode.ATTR_TTS_FONT_WEIGHT) != null) {
                        tKButton.setFontWeight((String) hashMap.get(TtmlNode.ATTR_TTS_FONT_WEIGHT));
                    }
                    if (hashMap.get("gradientBgColor") != null) {
                        tKButton.setGradientBgColor((String) hashMap.get("gradientBgColor"));
                    }
                    if (hashMap.get(NativeConstants.OPACITY) != null) {
                        tKButton.setOpacity(trans((Number) hashMap.get(NativeConstants.OPACITY)));
                    }
                    if (hashMap.get("shadow") != null) {
                        tKButton.setShadow((String) hashMap.get("shadow"));
                    }
                    if (hashMap.get(TtmlNode.ATTR_TTS_TEXT_ALIGN) != null) {
                        tKButton.setTextAlign((String) hashMap.get(TtmlNode.ATTR_TTS_TEXT_ALIGN));
                    }
                    if (hashMap.get("textLineClamp") != null) {
                        tKButton.setTextLineClamp((int) trans((Number) hashMap.get("textLineClamp")));
                    }
                    if (hashMap.get("textOverflow") != null) {
                        tKButton.setTextOverflow((String) hashMap.get("textOverflow"));
                    }
                    if (hashMap.get("topLeftRadius") != null) {
                        tKButton.setTopLeftRadius((int) trans((Number) hashMap.get("topLeftRadius")));
                    }
                    if (hashMap.get("topRightRadius") != null) {
                        tKButton.setTopRightRadius((int) trans((Number) hashMap.get("topRightRadius")));
                    }
                    if (hashMap.get("visibility") != null) {
                        tKButton.setVisibility((String) hashMap.get("visibility"));
                        return;
                    }
                    return;
                case 1:
                    TKImage tKImage = (TKImage) obj;
                    if (hashMap.get("backgroundColor") != null) {
                        tKImage.setBackgroundColor(hashMap.get("backgroundColor"));
                    }
                    if (hashMap.get("backgroundImage") != null) {
                        tKImage.setBackgroundImage((String) hashMap.get("backgroundImage"));
                    }
                    if (hashMap.get("borderColor") != null) {
                        tKImage.setBorderColor((String) hashMap.get("borderColor"));
                    }
                    if (hashMap.get("borderRadius") != null) {
                        tKImage.setBorderRadius((int) trans((Number) hashMap.get("borderRadius")));
                    }
                    if (hashMap.get("borderStyle") != null) {
                        tKImage.setBorderStyle((String) hashMap.get("borderStyle"));
                    }
                    if (hashMap.get("borderWidth") != null) {
                        tKImage.setBorderWidth(trans((Number) hashMap.get("borderWidth")));
                    }
                    if (hashMap.get("bottomLeftRadius") != null) {
                        tKImage.setBottomLeftRadius((int) trans((Number) hashMap.get("bottomLeftRadius")));
                    }
                    if (hashMap.get("bottomRightRadius") != null) {
                        tKImage.setBottomRightRadius((int) trans((Number) hashMap.get("bottomRightRadius")));
                    }
                    if (hashMap.get(CriusAttrConstants.DISPLAY) != null) {
                        tKImage.setDisplay((String) hashMap.get(CriusAttrConstants.DISPLAY));
                    }
                    if (hashMap.get("gradientBgColor") != null) {
                        tKImage.setGradientBgColor((String) hashMap.get("gradientBgColor"));
                    }
                    if (hashMap.get(NativeConstants.OPACITY) != null) {
                        tKImage.setOpacity(trans((Number) hashMap.get(NativeConstants.OPACITY)));
                    }
                    if (hashMap.get("resize") != null) {
                        tKImage.setContentMode((String) hashMap.get("resize"));
                    }
                    if (hashMap.get("shadow") != null) {
                        tKImage.setShadow((String) hashMap.get("shadow"));
                    }
                    if (hashMap.get("topLeftRadius") != null) {
                        tKImage.setTopLeftRadius((int) trans((Number) hashMap.get("topLeftRadius")));
                    }
                    if (hashMap.get("topRightRadius") != null) {
                        tKImage.setTopRightRadius((int) trans((Number) hashMap.get("topRightRadius")));
                    }
                    obj2 = "visibility";
                    tKText = tKImage;
                    if (hashMap.get(obj2) == null) {
                        return;
                    }
                    tKText.setVisibility((String) hashMap.get(obj2));
                    return;
                case 2:
                    TKBase tKBase = (TKSpan) obj;
                    if (hashMap.get("backgroundColor") != null) {
                        tKBase.setBackgroundColor(hashMap.get("backgroundColor"));
                    }
                    if (hashMap.get("backgroundImage") != null) {
                        tKBase.setBackgroundImage((String) hashMap.get("backgroundImage"));
                    }
                    if (hashMap.get("borderColor") != null) {
                        tKBase.setBorderColor((String) hashMap.get("borderColor"));
                    }
                    if (hashMap.get("borderRadius") != null) {
                        tKBase.setBorderRadius((int) trans((Number) hashMap.get("borderRadius")));
                    }
                    if (hashMap.get("borderStyle") != null) {
                        tKBase.setBorderStyle((String) hashMap.get("borderStyle"));
                    }
                    if (hashMap.get("borderWidth") != null) {
                        tKBase.setBorderWidth(trans((Number) hashMap.get("borderWidth")));
                    }
                    if (hashMap.get("bottomLeftRadius") != null) {
                        tKBase.setBottomLeftRadius((int) trans((Number) hashMap.get("bottomLeftRadius")));
                    }
                    if (hashMap.get("bottomRightRadius") != null) {
                        tKBase.setBottomRightRadius((int) trans((Number) hashMap.get("bottomRightRadius")));
                    }
                    if (hashMap.get(CriusAttrConstants.DISPLAY) != null) {
                        tKBase.setDisplay((String) hashMap.get(CriusAttrConstants.DISPLAY));
                    }
                    if (hashMap.get("gradientBgColor") != null) {
                        tKBase.setGradientBgColor((String) hashMap.get("gradientBgColor"));
                    }
                    if (hashMap.get(NativeConstants.OPACITY) != null) {
                        tKBase.setOpacity(trans((Number) hashMap.get(NativeConstants.OPACITY)));
                    }
                    if (hashMap.get("shadow") != null) {
                        tKBase.setShadow((String) hashMap.get("shadow"));
                    }
                    if (hashMap.get("topLeftRadius") != null) {
                        tKBase.setTopLeftRadius((int) trans((Number) hashMap.get("topLeftRadius")));
                    }
                    if (hashMap.get("topRightRadius") != null) {
                        tKBase.setTopRightRadius((int) trans((Number) hashMap.get("topRightRadius")));
                    }
                    obj2 = "visibility";
                    tKText = tKBase;
                    if (hashMap.get(obj2) == null) {
                        return;
                    }
                    tKText.setVisibility((String) hashMap.get(obj2));
                    return;
                case 3:
                    TKBase tKBase2 = (TKViewPager) obj;
                    if (hashMap.get("backgroundColor") != null) {
                        tKBase2.setBackgroundColor(hashMap.get("backgroundColor"));
                    }
                    if (hashMap.get("backgroundImage") != null) {
                        tKBase2.setBackgroundImage((String) hashMap.get("backgroundImage"));
                    }
                    if (hashMap.get("borderColor") != null) {
                        tKBase2.setBorderColor((String) hashMap.get("borderColor"));
                    }
                    if (hashMap.get("borderRadius") != null) {
                        tKBase2.setBorderRadius((int) trans((Number) hashMap.get("borderRadius")));
                    }
                    if (hashMap.get("borderStyle") != null) {
                        tKBase2.setBorderStyle((String) hashMap.get("borderStyle"));
                    }
                    if (hashMap.get("borderWidth") != null) {
                        tKBase2.setBorderWidth(trans((Number) hashMap.get("borderWidth")));
                    }
                    if (hashMap.get("bottomLeftRadius") != null) {
                        tKBase2.setBottomLeftRadius((int) trans((Number) hashMap.get("bottomLeftRadius")));
                    }
                    if (hashMap.get("bottomRightRadius") != null) {
                        tKBase2.setBottomRightRadius((int) trans((Number) hashMap.get("bottomRightRadius")));
                    }
                    if (hashMap.get(CriusAttrConstants.DISPLAY) != null) {
                        tKBase2.setDisplay((String) hashMap.get(CriusAttrConstants.DISPLAY));
                    }
                    if (hashMap.get("gradientBgColor") != null) {
                        tKBase2.setGradientBgColor((String) hashMap.get("gradientBgColor"));
                    }
                    if (hashMap.get(NativeConstants.OPACITY) != null) {
                        tKBase2.setOpacity(trans((Number) hashMap.get(NativeConstants.OPACITY)));
                    }
                    if (hashMap.get("shadow") != null) {
                        tKBase2.setShadow((String) hashMap.get("shadow"));
                    }
                    if (hashMap.get("topLeftRadius") != null) {
                        tKBase2.setTopLeftRadius((int) trans((Number) hashMap.get("topLeftRadius")));
                    }
                    if (hashMap.get("topRightRadius") != null) {
                        tKBase2.setTopRightRadius((int) trans((Number) hashMap.get("topRightRadius")));
                    }
                    obj2 = "visibility";
                    tKText = tKBase2;
                    if (hashMap.get(obj2) == null) {
                        return;
                    }
                    tKText.setVisibility((String) hashMap.get(obj2));
                    return;
                case 4:
                    TKBase tKBase3 = (TKListView) obj;
                    if (hashMap.get("backgroundColor") != null) {
                        tKBase3.setBackgroundColor(hashMap.get("backgroundColor"));
                    }
                    if (hashMap.get("backgroundImage") != null) {
                        tKBase3.setBackgroundImage((String) hashMap.get("backgroundImage"));
                    }
                    if (hashMap.get("borderColor") != null) {
                        tKBase3.setBorderColor((String) hashMap.get("borderColor"));
                    }
                    if (hashMap.get("borderRadius") != null) {
                        tKBase3.setBorderRadius((int) trans((Number) hashMap.get("borderRadius")));
                    }
                    if (hashMap.get("borderStyle") != null) {
                        tKBase3.setBorderStyle((String) hashMap.get("borderStyle"));
                    }
                    if (hashMap.get("borderWidth") != null) {
                        tKBase3.setBorderWidth(trans((Number) hashMap.get("borderWidth")));
                    }
                    if (hashMap.get("bottomLeftRadius") != null) {
                        tKBase3.setBottomLeftRadius((int) trans((Number) hashMap.get("bottomLeftRadius")));
                    }
                    if (hashMap.get("bottomRightRadius") != null) {
                        tKBase3.setBottomRightRadius((int) trans((Number) hashMap.get("bottomRightRadius")));
                    }
                    if (hashMap.get(CriusAttrConstants.DISPLAY) != null) {
                        tKBase3.setDisplay((String) hashMap.get(CriusAttrConstants.DISPLAY));
                    }
                    if (hashMap.get("gradientBgColor") != null) {
                        tKBase3.setGradientBgColor((String) hashMap.get("gradientBgColor"));
                    }
                    if (hashMap.get(NativeConstants.OPACITY) != null) {
                        tKBase3.setOpacity(trans((Number) hashMap.get(NativeConstants.OPACITY)));
                    }
                    if (hashMap.get("shadow") != null) {
                        tKBase3.setShadow((String) hashMap.get("shadow"));
                    }
                    if (hashMap.get("topLeftRadius") != null) {
                        tKBase3.setTopLeftRadius((int) trans((Number) hashMap.get("topLeftRadius")));
                    }
                    if (hashMap.get("topRightRadius") != null) {
                        tKBase3.setTopRightRadius((int) trans((Number) hashMap.get("topRightRadius")));
                    }
                    obj2 = "visibility";
                    tKText = tKBase3;
                    if (hashMap.get(obj2) == null) {
                        return;
                    }
                    tKText.setVisibility((String) hashMap.get(obj2));
                    return;
                case 5:
                    TKInput tKInput = (TKInput) obj;
                    if (hashMap.get("backgroundColor") != null) {
                        tKInput.setBackgroundColor(hashMap.get("backgroundColor"));
                    }
                    if (hashMap.get("backgroundImage") != null) {
                        tKInput.setBackgroundImage((String) hashMap.get("backgroundImage"));
                    }
                    if (hashMap.get("borderColor") != null) {
                        tKInput.setBorderColor((String) hashMap.get("borderColor"));
                    }
                    if (hashMap.get("borderRadius") != null) {
                        tKInput.setBorderRadius((int) trans((Number) hashMap.get("borderRadius")));
                    }
                    if (hashMap.get("borderStyle") != null) {
                        tKInput.setBorderStyle((String) hashMap.get("borderStyle"));
                    }
                    if (hashMap.get("borderWidth") != null) {
                        tKInput.setBorderWidth(trans((Number) hashMap.get("borderWidth")));
                    }
                    if (hashMap.get("bottomLeftRadius") != null) {
                        tKInput.setBottomLeftRadius((int) trans((Number) hashMap.get("bottomLeftRadius")));
                    }
                    if (hashMap.get("bottomRightRadius") != null) {
                        tKInput.setBottomRightRadius((int) trans((Number) hashMap.get("bottomRightRadius")));
                    }
                    if (hashMap.get("color") != null) {
                        tKInput.setColor((String) hashMap.get("color"));
                    }
                    if (hashMap.get("cursorColor") != null) {
                        tKInput.setCursorColor((String) hashMap.get("cursorColor"));
                    }
                    if (hashMap.get(CriusAttrConstants.DISPLAY) != null) {
                        tKInput.setDisplay((String) hashMap.get(CriusAttrConstants.DISPLAY));
                    }
                    if (hashMap.get("fontFamily") != null) {
                        tKInput.setFontFamily((String) hashMap.get("fontFamily"));
                    }
                    if (hashMap.get(TtmlNode.ATTR_TTS_FONT_SIZE) != null) {
                        tKInput.setFontSize((int) trans((Number) hashMap.get(TtmlNode.ATTR_TTS_FONT_SIZE)));
                    }
                    if (hashMap.get("gradientBgColor") != null) {
                        tKInput.setGradientBgColor((String) hashMap.get("gradientBgColor"));
                    }
                    if (hashMap.get("maxLength") != null) {
                        tKInput.setMaxLength((int) trans((Number) hashMap.get("maxLength")));
                    }
                    if (hashMap.get(NativeConstants.OPACITY) != null) {
                        tKInput.setOpacity(trans((Number) hashMap.get(NativeConstants.OPACITY)));
                    }
                    if (hashMap.get("placeholderColor") != null) {
                        tKInput.setPlaceholderColor((String) hashMap.get("placeholderColor"));
                    }
                    if (hashMap.get("placeholderFontSize") != null) {
                        tKInput.setPlaceholderFontSize((float) trans((Number) hashMap.get("placeholderFontSize")));
                    }
                    if (hashMap.get("returnKeyType") != null) {
                        tKInput.setReturnKeyType((String) hashMap.get("returnKeyType"));
                    }
                    if (hashMap.get("shadow") != null) {
                        tKInput.setShadow((String) hashMap.get("shadow"));
                    }
                    if (hashMap.get(TtmlNode.ATTR_TTS_TEXT_ALIGN) != null) {
                        tKInput.setTextAlign((String) hashMap.get(TtmlNode.ATTR_TTS_TEXT_ALIGN));
                    }
                    if (hashMap.get("topLeftRadius") != null) {
                        tKInput.setTopLeftRadius((int) trans((Number) hashMap.get("topLeftRadius")));
                    }
                    if (hashMap.get("topRightRadius") != null) {
                        tKInput.setTopRightRadius((int) trans((Number) hashMap.get("topRightRadius")));
                    }
                    if (hashMap.get("type") != null) {
                        tKInput.setType((String) hashMap.get("type"));
                    }
                    obj2 = "visibility";
                    tKText = tKInput;
                    if (hashMap.get(obj2) == null) {
                        return;
                    }
                    tKText.setVisibility((String) hashMap.get(obj2));
                    return;
                case 6:
                    TKBase tKBase4 = (TKRefreshAnimatableView) obj;
                    if (hashMap.get("backgroundColor") != null) {
                        tKBase4.setBackgroundColor(hashMap.get("backgroundColor"));
                    }
                    if (hashMap.get("backgroundImage") != null) {
                        tKBase4.setBackgroundImage((String) hashMap.get("backgroundImage"));
                    }
                    if (hashMap.get("borderColor") != null) {
                        tKBase4.setBorderColor((String) hashMap.get("borderColor"));
                    }
                    if (hashMap.get("borderRadius") != null) {
                        tKBase4.setBorderRadius((int) trans((Number) hashMap.get("borderRadius")));
                    }
                    if (hashMap.get("borderStyle") != null) {
                        tKBase4.setBorderStyle((String) hashMap.get("borderStyle"));
                    }
                    if (hashMap.get("borderWidth") != null) {
                        tKBase4.setBorderWidth(trans((Number) hashMap.get("borderWidth")));
                    }
                    if (hashMap.get("bottomLeftRadius") != null) {
                        tKBase4.setBottomLeftRadius((int) trans((Number) hashMap.get("bottomLeftRadius")));
                    }
                    if (hashMap.get("bottomRightRadius") != null) {
                        tKBase4.setBottomRightRadius((int) trans((Number) hashMap.get("bottomRightRadius")));
                    }
                    if (hashMap.get(CriusAttrConstants.DISPLAY) != null) {
                        tKBase4.setDisplay((String) hashMap.get(CriusAttrConstants.DISPLAY));
                    }
                    if (hashMap.get("gradientBgColor") != null) {
                        tKBase4.setGradientBgColor((String) hashMap.get("gradientBgColor"));
                    }
                    if (hashMap.get(NativeConstants.OPACITY) != null) {
                        tKBase4.setOpacity(trans((Number) hashMap.get(NativeConstants.OPACITY)));
                    }
                    if (hashMap.get("shadow") != null) {
                        tKBase4.setShadow((String) hashMap.get("shadow"));
                    }
                    if (hashMap.get("topLeftRadius") != null) {
                        tKBase4.setTopLeftRadius((int) trans((Number) hashMap.get("topLeftRadius")));
                    }
                    if (hashMap.get("topRightRadius") != null) {
                        tKBase4.setTopRightRadius((int) trans((Number) hashMap.get("topRightRadius")));
                    }
                    obj2 = "visibility";
                    tKText = tKBase4;
                    if (hashMap.get(obj2) == null) {
                        return;
                    }
                    tKText.setVisibility((String) hashMap.get(obj2));
                    return;
                case 7:
                    KTProgressBarView kTProgressBarView = (KTProgressBarView) obj;
                    if (hashMap.get("backgroundColor") != null) {
                        kTProgressBarView.setBackgroundColor(hashMap.get("backgroundColor"));
                    }
                    if (hashMap.get("backgroundImage") != null) {
                        kTProgressBarView.setBackgroundImage((String) hashMap.get("backgroundImage"));
                    }
                    if (hashMap.get("borderColor") != null) {
                        kTProgressBarView.setBorderColor((String) hashMap.get("borderColor"));
                    }
                    if (hashMap.get("borderRadius") != null) {
                        kTProgressBarView.setBorderRadius((int) trans((Number) hashMap.get("borderRadius")));
                    }
                    if (hashMap.get("borderStyle") != null) {
                        kTProgressBarView.setBorderStyle((String) hashMap.get("borderStyle"));
                    }
                    if (hashMap.get("borderWidth") != null) {
                        kTProgressBarView.setBorderWidth(trans((Number) hashMap.get("borderWidth")));
                    }
                    if (hashMap.get("bottomLeftRadius") != null) {
                        kTProgressBarView.setBottomLeftRadius((int) trans((Number) hashMap.get("bottomLeftRadius")));
                    }
                    if (hashMap.get("bottomRightRadius") != null) {
                        kTProgressBarView.setBottomRightRadius((int) trans((Number) hashMap.get("bottomRightRadius")));
                    }
                    if (hashMap.get("cornerRadius") != null) {
                        kTProgressBarView.setCornerRadius((float) trans((Number) hashMap.get("cornerRadius")));
                    }
                    if (hashMap.get(CriusAttrConstants.DISPLAY) != null) {
                        kTProgressBarView.setDisplay((String) hashMap.get(CriusAttrConstants.DISPLAY));
                    }
                    if (hashMap.get("gradientBgColor") != null) {
                        kTProgressBarView.setGradientBgColor((String) hashMap.get("gradientBgColor"));
                    }
                    if (hashMap.get("indeterminate") != null) {
                        kTProgressBarView.setIndeterminate(((Boolean) hashMap.get("indeterminate")).booleanValue());
                    }
                    if (hashMap.get(NativeConstants.OPACITY) != null) {
                        kTProgressBarView.setOpacity(trans((Number) hashMap.get(NativeConstants.OPACITY)));
                    }
                    if (hashMap.get("shadow") != null) {
                        kTProgressBarView.setShadow((String) hashMap.get("shadow"));
                    }
                    if (hashMap.get("topLeftRadius") != null) {
                        kTProgressBarView.setTopLeftRadius((int) trans((Number) hashMap.get("topLeftRadius")));
                    }
                    if (hashMap.get("topRightRadius") != null) {
                        kTProgressBarView.setTopRightRadius((int) trans((Number) hashMap.get("topRightRadius")));
                    }
                    obj2 = "visibility";
                    tKText = kTProgressBarView;
                    if (hashMap.get(obj2) == null) {
                        return;
                    }
                    tKText.setVisibility((String) hashMap.get(obj2));
                    return;
                case '\b':
                    TKBase tKBase5 = (TKRecyclerView) obj;
                    if (hashMap.get("backgroundColor") != null) {
                        tKBase5.setBackgroundColor(hashMap.get("backgroundColor"));
                    }
                    if (hashMap.get("backgroundImage") != null) {
                        tKBase5.setBackgroundImage((String) hashMap.get("backgroundImage"));
                    }
                    if (hashMap.get("borderColor") != null) {
                        tKBase5.setBorderColor((String) hashMap.get("borderColor"));
                    }
                    if (hashMap.get("borderRadius") != null) {
                        tKBase5.setBorderRadius((int) trans((Number) hashMap.get("borderRadius")));
                    }
                    if (hashMap.get("borderStyle") != null) {
                        tKBase5.setBorderStyle((String) hashMap.get("borderStyle"));
                    }
                    if (hashMap.get("borderWidth") != null) {
                        tKBase5.setBorderWidth(trans((Number) hashMap.get("borderWidth")));
                    }
                    if (hashMap.get("bottomLeftRadius") != null) {
                        tKBase5.setBottomLeftRadius((int) trans((Number) hashMap.get("bottomLeftRadius")));
                    }
                    if (hashMap.get("bottomRightRadius") != null) {
                        tKBase5.setBottomRightRadius((int) trans((Number) hashMap.get("bottomRightRadius")));
                    }
                    if (hashMap.get(CriusAttrConstants.DISPLAY) != null) {
                        tKBase5.setDisplay((String) hashMap.get(CriusAttrConstants.DISPLAY));
                    }
                    if (hashMap.get("gradientBgColor") != null) {
                        tKBase5.setGradientBgColor((String) hashMap.get("gradientBgColor"));
                    }
                    if (hashMap.get(NativeConstants.OPACITY) != null) {
                        tKBase5.setOpacity(trans((Number) hashMap.get(NativeConstants.OPACITY)));
                    }
                    if (hashMap.get("shadow") != null) {
                        tKBase5.setShadow((String) hashMap.get("shadow"));
                    }
                    if (hashMap.get("topLeftRadius") != null) {
                        tKBase5.setTopLeftRadius((int) trans((Number) hashMap.get("topLeftRadius")));
                    }
                    if (hashMap.get("topRightRadius") != null) {
                        tKBase5.setTopRightRadius((int) trans((Number) hashMap.get("topRightRadius")));
                    }
                    obj2 = "visibility";
                    tKText = tKBase5;
                    if (hashMap.get(obj2) == null) {
                        return;
                    }
                    tKText.setVisibility((String) hashMap.get(obj2));
                    return;
                case '\t':
                    TKTextArea tKTextArea = (TKTextArea) obj;
                    if (hashMap.get("backgroundColor") != null) {
                        tKTextArea.setBackgroundColor(hashMap.get("backgroundColor"));
                    }
                    if (hashMap.get("backgroundImage") != null) {
                        tKTextArea.setBackgroundImage((String) hashMap.get("backgroundImage"));
                    }
                    if (hashMap.get("borderColor") != null) {
                        tKTextArea.setBorderColor((String) hashMap.get("borderColor"));
                    }
                    if (hashMap.get("borderRadius") != null) {
                        tKTextArea.setBorderRadius((int) trans((Number) hashMap.get("borderRadius")));
                    }
                    if (hashMap.get("borderStyle") != null) {
                        tKTextArea.setBorderStyle((String) hashMap.get("borderStyle"));
                    }
                    if (hashMap.get("borderWidth") != null) {
                        tKTextArea.setBorderWidth(trans((Number) hashMap.get("borderWidth")));
                    }
                    if (hashMap.get("bottomLeftRadius") != null) {
                        tKTextArea.setBottomLeftRadius((int) trans((Number) hashMap.get("bottomLeftRadius")));
                    }
                    if (hashMap.get("bottomRightRadius") != null) {
                        tKTextArea.setBottomRightRadius((int) trans((Number) hashMap.get("bottomRightRadius")));
                    }
                    if (hashMap.get("color") != null) {
                        tKTextArea.setColor((String) hashMap.get("color"));
                    }
                    if (hashMap.get("cursorColor") != null) {
                        tKTextArea.setCursorColor((String) hashMap.get("cursorColor"));
                    }
                    if (hashMap.get(CriusAttrConstants.DISPLAY) != null) {
                        tKTextArea.setDisplay((String) hashMap.get(CriusAttrConstants.DISPLAY));
                    }
                    if (hashMap.get("fontFamily") != null) {
                        tKTextArea.setFontFamily((String) hashMap.get("fontFamily"));
                    }
                    if (hashMap.get(TtmlNode.ATTR_TTS_FONT_SIZE) != null) {
                        tKTextArea.setFontSize((int) trans((Number) hashMap.get(TtmlNode.ATTR_TTS_FONT_SIZE)));
                    }
                    if (hashMap.get("gradientBgColor") != null) {
                        tKTextArea.setGradientBgColor((String) hashMap.get("gradientBgColor"));
                    }
                    if (hashMap.get("maxLength") != null) {
                        tKTextArea.setMaxLength((int) trans((Number) hashMap.get("maxLength")));
                    }
                    if (hashMap.get(NativeConstants.OPACITY) != null) {
                        tKTextArea.setOpacity(trans((Number) hashMap.get(NativeConstants.OPACITY)));
                    }
                    if (hashMap.get("placeholderColor") != null) {
                        tKTextArea.setPlaceholderColor((String) hashMap.get("placeholderColor"));
                    }
                    if (hashMap.get("placeholderFontSize") != null) {
                        tKTextArea.setPlaceholderFontSize((float) trans((Number) hashMap.get("placeholderFontSize")));
                    }
                    if (hashMap.get("returnKeyType") != null) {
                        tKTextArea.setReturnKeyType((String) hashMap.get("returnKeyType"));
                    }
                    if (hashMap.get("shadow") != null) {
                        tKTextArea.setShadow((String) hashMap.get("shadow"));
                    }
                    if (hashMap.get(TtmlNode.ATTR_TTS_TEXT_ALIGN) != null) {
                        tKTextArea.setTextAlign((String) hashMap.get(TtmlNode.ATTR_TTS_TEXT_ALIGN));
                    }
                    if (hashMap.get("textLineClamp") != null) {
                        tKTextArea.setTextLineClamp((int) trans((Number) hashMap.get("textLineClamp")));
                    }
                    if (hashMap.get("topLeftRadius") != null) {
                        tKTextArea.setTopLeftRadius((int) trans((Number) hashMap.get("topLeftRadius")));
                    }
                    if (hashMap.get("topRightRadius") != null) {
                        tKTextArea.setTopRightRadius((int) trans((Number) hashMap.get("topRightRadius")));
                    }
                    if (hashMap.get("type") != null) {
                        tKTextArea.setType((String) hashMap.get("type"));
                    }
                    obj2 = "visibility";
                    tKText = tKTextArea;
                    if (hashMap.get(obj2) == null) {
                        return;
                    }
                    tKText.setVisibility((String) hashMap.get(obj2));
                    return;
                case '\n':
                    TKBase tKBase6 = (TKRefreshControl) obj;
                    if (hashMap.get("backgroundColor") != null) {
                        tKBase6.setBackgroundColor(hashMap.get("backgroundColor"));
                    }
                    if (hashMap.get("backgroundImage") != null) {
                        tKBase6.setBackgroundImage((String) hashMap.get("backgroundImage"));
                    }
                    if (hashMap.get("borderColor") != null) {
                        tKBase6.setBorderColor((String) hashMap.get("borderColor"));
                    }
                    if (hashMap.get("borderRadius") != null) {
                        tKBase6.setBorderRadius((int) trans((Number) hashMap.get("borderRadius")));
                    }
                    if (hashMap.get("borderStyle") != null) {
                        tKBase6.setBorderStyle((String) hashMap.get("borderStyle"));
                    }
                    if (hashMap.get("borderWidth") != null) {
                        tKBase6.setBorderWidth(trans((Number) hashMap.get("borderWidth")));
                    }
                    if (hashMap.get("bottomLeftRadius") != null) {
                        tKBase6.setBottomLeftRadius((int) trans((Number) hashMap.get("bottomLeftRadius")));
                    }
                    if (hashMap.get("bottomRightRadius") != null) {
                        tKBase6.setBottomRightRadius((int) trans((Number) hashMap.get("bottomRightRadius")));
                    }
                    if (hashMap.get(CriusAttrConstants.DISPLAY) != null) {
                        tKBase6.setDisplay((String) hashMap.get(CriusAttrConstants.DISPLAY));
                    }
                    if (hashMap.get("gradientBgColor") != null) {
                        tKBase6.setGradientBgColor((String) hashMap.get("gradientBgColor"));
                    }
                    if (hashMap.get(NativeConstants.OPACITY) != null) {
                        tKBase6.setOpacity(trans((Number) hashMap.get(NativeConstants.OPACITY)));
                    }
                    if (hashMap.get("shadow") != null) {
                        tKBase6.setShadow((String) hashMap.get("shadow"));
                    }
                    if (hashMap.get("topLeftRadius") != null) {
                        tKBase6.setTopLeftRadius((int) trans((Number) hashMap.get("topLeftRadius")));
                    }
                    if (hashMap.get("topRightRadius") != null) {
                        tKBase6.setTopRightRadius((int) trans((Number) hashMap.get("topRightRadius")));
                    }
                    obj3 = "visibility";
                    tKMarqueeText = tKBase6;
                    if (hashMap.get(obj3) == null) {
                        return;
                    }
                    tKMarqueeText.setVisibility((String) hashMap.get(obj3));
                    return;
                case 11:
                    TKBase tKBase7 = (SpanItem) obj;
                    if (hashMap.get("backgroundColor") != null) {
                        tKBase7.setBackgroundColor(hashMap.get("backgroundColor"));
                    }
                    if (hashMap.get("backgroundImage") != null) {
                        tKBase7.setBackgroundImage((String) hashMap.get("backgroundImage"));
                    }
                    if (hashMap.get("borderColor") != null) {
                        tKBase7.setBorderColor((String) hashMap.get("borderColor"));
                    }
                    if (hashMap.get("borderRadius") != null) {
                        tKBase7.setBorderRadius((int) trans((Number) hashMap.get("borderRadius")));
                    }
                    if (hashMap.get("borderStyle") != null) {
                        tKBase7.setBorderStyle((String) hashMap.get("borderStyle"));
                    }
                    if (hashMap.get("borderWidth") != null) {
                        tKBase7.setBorderWidth(trans((Number) hashMap.get("borderWidth")));
                    }
                    if (hashMap.get("bottomLeftRadius") != null) {
                        tKBase7.setBottomLeftRadius((int) trans((Number) hashMap.get("bottomLeftRadius")));
                    }
                    if (hashMap.get("bottomRightRadius") != null) {
                        tKBase7.setBottomRightRadius((int) trans((Number) hashMap.get("bottomRightRadius")));
                    }
                    if (hashMap.get(CriusAttrConstants.DISPLAY) != null) {
                        tKBase7.setDisplay((String) hashMap.get(CriusAttrConstants.DISPLAY));
                    }
                    if (hashMap.get("gradientBgColor") != null) {
                        tKBase7.setGradientBgColor((String) hashMap.get("gradientBgColor"));
                    }
                    if (hashMap.get(NativeConstants.OPACITY) != null) {
                        tKBase7.setOpacity(trans((Number) hashMap.get(NativeConstants.OPACITY)));
                    }
                    if (hashMap.get("shadow") != null) {
                        tKBase7.setShadow((String) hashMap.get("shadow"));
                    }
                    if (hashMap.get("topLeftRadius") != null) {
                        tKBase7.setTopLeftRadius((int) trans((Number) hashMap.get("topLeftRadius")));
                    }
                    if (hashMap.get("topRightRadius") != null) {
                        tKBase7.setTopRightRadius((int) trans((Number) hashMap.get("topRightRadius")));
                    }
                    obj3 = "visibility";
                    tKMarqueeText = tKBase7;
                    if (hashMap.get(obj3) == null) {
                        return;
                    }
                    tKMarqueeText.setVisibility((String) hashMap.get(obj3));
                    return;
                case '\f':
                    TKBase tKBase8 = (TKWaterListView) obj;
                    if (hashMap.get("backgroundColor") != null) {
                        tKBase8.setBackgroundColor(hashMap.get("backgroundColor"));
                    }
                    if (hashMap.get("backgroundImage") != null) {
                        tKBase8.setBackgroundImage((String) hashMap.get("backgroundImage"));
                    }
                    if (hashMap.get("borderColor") != null) {
                        tKBase8.setBorderColor((String) hashMap.get("borderColor"));
                    }
                    if (hashMap.get("borderRadius") != null) {
                        tKBase8.setBorderRadius((int) trans((Number) hashMap.get("borderRadius")));
                    }
                    if (hashMap.get("borderStyle") != null) {
                        tKBase8.setBorderStyle((String) hashMap.get("borderStyle"));
                    }
                    if (hashMap.get("borderWidth") != null) {
                        tKBase8.setBorderWidth(trans((Number) hashMap.get("borderWidth")));
                    }
                    if (hashMap.get("bottomLeftRadius") != null) {
                        tKBase8.setBottomLeftRadius((int) trans((Number) hashMap.get("bottomLeftRadius")));
                    }
                    if (hashMap.get("bottomRightRadius") != null) {
                        tKBase8.setBottomRightRadius((int) trans((Number) hashMap.get("bottomRightRadius")));
                    }
                    if (hashMap.get(CriusAttrConstants.DISPLAY) != null) {
                        tKBase8.setDisplay((String) hashMap.get(CriusAttrConstants.DISPLAY));
                    }
                    if (hashMap.get("gradientBgColor") != null) {
                        tKBase8.setGradientBgColor((String) hashMap.get("gradientBgColor"));
                    }
                    if (hashMap.get(NativeConstants.OPACITY) != null) {
                        tKBase8.setOpacity(trans((Number) hashMap.get(NativeConstants.OPACITY)));
                    }
                    if (hashMap.get("shadow") != null) {
                        tKBase8.setShadow((String) hashMap.get("shadow"));
                    }
                    if (hashMap.get("topLeftRadius") != null) {
                        tKBase8.setTopLeftRadius((int) trans((Number) hashMap.get("topLeftRadius")));
                    }
                    if (hashMap.get("topRightRadius") != null) {
                        tKBase8.setTopRightRadius((int) trans((Number) hashMap.get("topRightRadius")));
                    }
                    obj3 = "visibility";
                    tKMarqueeText = tKBase8;
                    if (hashMap.get(obj3) == null) {
                        return;
                    }
                    tKMarqueeText.setVisibility((String) hashMap.get(obj3));
                    return;
                case '\r':
                    TKIndicator tKIndicator = (TKIndicator) obj;
                    if (hashMap.get("activeColor") != null) {
                        tKIndicator.setActiveColor((String) hashMap.get("activeColor"));
                    }
                    if (hashMap.get("backgroundColor") != null) {
                        tKIndicator.setBackgroundColor(hashMap.get("backgroundColor"));
                    }
                    if (hashMap.get("backgroundImage") != null) {
                        tKIndicator.setBackgroundImage((String) hashMap.get("backgroundImage"));
                    }
                    if (hashMap.get("borderColor") != null) {
                        tKIndicator.setBorderColor((String) hashMap.get("borderColor"));
                    }
                    if (hashMap.get("borderRadius") != null) {
                        tKIndicator.setBorderRadius((int) trans((Number) hashMap.get("borderRadius")));
                    }
                    if (hashMap.get("borderStyle") != null) {
                        tKIndicator.setBorderStyle((String) hashMap.get("borderStyle"));
                    }
                    if (hashMap.get("borderWidth") != null) {
                        tKIndicator.setBorderWidth(trans((Number) hashMap.get("borderWidth")));
                    }
                    if (hashMap.get("bottomLeftRadius") != null) {
                        tKIndicator.setBottomLeftRadius((int) trans((Number) hashMap.get("bottomLeftRadius")));
                    }
                    if (hashMap.get("bottomRightRadius") != null) {
                        tKIndicator.setBottomRightRadius((int) trans((Number) hashMap.get("bottomRightRadius")));
                    }
                    if (hashMap.get(CriusAttrConstants.DISPLAY) != null) {
                        tKIndicator.setDisplay((String) hashMap.get(CriusAttrConstants.DISPLAY));
                    }
                    if (hashMap.get("gradientBgColor") != null) {
                        tKIndicator.setGradientBgColor((String) hashMap.get("gradientBgColor"));
                    }
                    if (hashMap.get("inActiveColor") != null) {
                        tKIndicator.setInActiveColor((String) hashMap.get("inActiveColor"));
                    }
                    if (hashMap.get(AnimationProperty.MARGIN_TOP) != null) {
                        tKIndicator.setMarginTop((int) trans((Number) hashMap.get(AnimationProperty.MARGIN_TOP)));
                    }
                    if (hashMap.get(NativeConstants.OPACITY) != null) {
                        tKIndicator.setOpacity(trans((Number) hashMap.get(NativeConstants.OPACITY)));
                    }
                    if (hashMap.get(CriusAttrConstants.PADDING) != null) {
                        tKIndicator.setPadding((int) trans((Number) hashMap.get(CriusAttrConstants.PADDING)));
                    }
                    if (hashMap.get("shadow") != null) {
                        tKIndicator.setShadow((String) hashMap.get("shadow"));
                    }
                    if (hashMap.get("size") != null) {
                        tKIndicator.setSize((int) trans((Number) hashMap.get("size")));
                    }
                    if (hashMap.get("textSize") != null) {
                        tKIndicator.setTextSize((int) trans((Number) hashMap.get("textSize")));
                    }
                    if (hashMap.get("topLeftRadius") != null) {
                        tKIndicator.setTopLeftRadius((int) trans((Number) hashMap.get("topLeftRadius")));
                    }
                    if (hashMap.get("topRightRadius") != null) {
                        tKIndicator.setTopRightRadius((int) trans((Number) hashMap.get("topRightRadius")));
                    }
                    if (hashMap.get("type") != null) {
                        tKIndicator.setType((String) hashMap.get("type"));
                    }
                    obj3 = "visibility";
                    tKMarqueeText = tKIndicator;
                    if (hashMap.get(obj3) == null) {
                        return;
                    }
                    tKMarqueeText.setVisibility((String) hashMap.get(obj3));
                    return;
                case 14:
                    TKMarqueeText tKMarqueeText2 = (TKMarqueeText) obj;
                    if (hashMap.get("backgroundColor") != null) {
                        tKMarqueeText2.setBackgroundColor(hashMap.get("backgroundColor"));
                    }
                    if (hashMap.get("backgroundImage") != null) {
                        tKMarqueeText2.setBackgroundImage((String) hashMap.get("backgroundImage"));
                    }
                    if (hashMap.get("borderColor") != null) {
                        tKMarqueeText2.setBorderColor((String) hashMap.get("borderColor"));
                    }
                    if (hashMap.get("borderRadius") != null) {
                        tKMarqueeText2.setBorderRadius((int) trans((Number) hashMap.get("borderRadius")));
                    }
                    if (hashMap.get("borderStyle") != null) {
                        tKMarqueeText2.setBorderStyle((String) hashMap.get("borderStyle"));
                    }
                    if (hashMap.get("borderWidth") != null) {
                        tKMarqueeText2.setBorderWidth(trans((Number) hashMap.get("borderWidth")));
                    }
                    if (hashMap.get("bottomLeftRadius") != null) {
                        tKMarqueeText2.setBottomLeftRadius((int) trans((Number) hashMap.get("bottomLeftRadius")));
                    }
                    if (hashMap.get("bottomRightRadius") != null) {
                        tKMarqueeText2.setBottomRightRadius((int) trans((Number) hashMap.get("bottomRightRadius")));
                    }
                    if (hashMap.get("color") != null) {
                        tKMarqueeText2.setColor((String) hashMap.get("color"));
                    }
                    if (hashMap.get(CriusAttrConstants.DISPLAY) != null) {
                        tKMarqueeText2.setDisplay((String) hashMap.get(CriusAttrConstants.DISPLAY));
                    }
                    if (hashMap.get(TtmlNode.ATTR_TTS_FONT_SIZE) != null) {
                        tKMarqueeText2.setFontSize((int) trans((Number) hashMap.get(TtmlNode.ATTR_TTS_FONT_SIZE)));
                    }
                    if (hashMap.get(TtmlNode.ATTR_TTS_FONT_WEIGHT) != null) {
                        tKMarqueeText2.setFontWeight((String) hashMap.get(TtmlNode.ATTR_TTS_FONT_WEIGHT));
                    }
                    if (hashMap.get("gradientBgColor") != null) {
                        tKMarqueeText2.setGradientBgColor((String) hashMap.get("gradientBgColor"));
                    }
                    if (hashMap.get(NativeConstants.OPACITY) != null) {
                        tKMarqueeText2.setOpacity(trans((Number) hashMap.get(NativeConstants.OPACITY)));
                    }
                    if (hashMap.get("shadow") != null) {
                        tKMarqueeText2.setShadow((String) hashMap.get("shadow"));
                    }
                    if (hashMap.get("topLeftRadius") != null) {
                        tKMarqueeText2.setTopLeftRadius((int) trans((Number) hashMap.get("topLeftRadius")));
                    }
                    if (hashMap.get("topRightRadius") != null) {
                        tKMarqueeText2.setTopRightRadius((int) trans((Number) hashMap.get("topRightRadius")));
                    }
                    obj3 = "visibility";
                    tKMarqueeText = tKMarqueeText2;
                    if (hashMap.get(obj3) == null) {
                        return;
                    }
                    tKMarqueeText.setVisibility((String) hashMap.get(obj3));
                    return;
                case 15:
                    TKSwitch tKSwitch = (TKSwitch) obj;
                    if (hashMap.get("backgroundColor") != null) {
                        tKSwitch.setBackgroundColor(hashMap.get("backgroundColor"));
                    }
                    if (hashMap.get("backgroundImage") != null) {
                        tKSwitch.setBackgroundImage((String) hashMap.get("backgroundImage"));
                    }
                    if (hashMap.get("borderColor") != null) {
                        tKSwitch.setBorderColor((String) hashMap.get("borderColor"));
                    }
                    if (hashMap.get("borderRadius") != null) {
                        tKSwitch.setBorderRadius((int) trans((Number) hashMap.get("borderRadius")));
                    }
                    if (hashMap.get("borderStyle") != null) {
                        tKSwitch.setBorderStyle((String) hashMap.get("borderStyle"));
                    }
                    if (hashMap.get("borderWidth") != null) {
                        tKSwitch.setBorderWidth(trans((Number) hashMap.get("borderWidth")));
                    }
                    if (hashMap.get("bottomLeftRadius") != null) {
                        tKSwitch.setBottomLeftRadius((int) trans((Number) hashMap.get("bottomLeftRadius")));
                    }
                    if (hashMap.get("bottomRightRadius") != null) {
                        tKSwitch.setBottomRightRadius((int) trans((Number) hashMap.get("bottomRightRadius")));
                    }
                    if (hashMap.get(CriusAttrConstants.DISPLAY) != null) {
                        tKSwitch.setDisplay((String) hashMap.get(CriusAttrConstants.DISPLAY));
                    }
                    if (hashMap.get("gradientBgColor") != null) {
                        tKSwitch.setGradientBgColor((String) hashMap.get("gradientBgColor"));
                    }
                    if (hashMap.get("offColor") != null) {
                        tKSwitch.setOffColor((int) trans((Number) hashMap.get("offColor")));
                    }
                    if (hashMap.get("onColor") != null) {
                        tKSwitch.setOnColor((int) trans((Number) hashMap.get("onColor")));
                    }
                    if (hashMap.get(NativeConstants.OPACITY) != null) {
                        tKSwitch.setOpacity(trans((Number) hashMap.get(NativeConstants.OPACITY)));
                    }
                    if (hashMap.get("shadow") != null) {
                        tKSwitch.setShadow((String) hashMap.get("shadow"));
                    }
                    if (hashMap.get("thumbColor") != null) {
                        tKSwitch.setThumbColor((int) trans((Number) hashMap.get("thumbColor")));
                    }
                    if (hashMap.get("topLeftRadius") != null) {
                        tKSwitch.setTopLeftRadius((int) trans((Number) hashMap.get("topLeftRadius")));
                    }
                    if (hashMap.get("topRightRadius") != null) {
                        tKSwitch.setTopRightRadius((int) trans((Number) hashMap.get("topRightRadius")));
                    }
                    obj2 = "visibility";
                    tKText = tKSwitch;
                    if (hashMap.get(obj2) == null) {
                        return;
                    }
                    tKText.setVisibility((String) hashMap.get(obj2));
                    return;
                case 16:
                    TKText tKText2 = (TKText) obj;
                    if (hashMap.get("backgroundColor") != null) {
                        tKText2.setBackgroundColor(hashMap.get("backgroundColor"));
                    }
                    if (hashMap.get("backgroundImage") != null) {
                        tKText2.setBackgroundImage((String) hashMap.get("backgroundImage"));
                    }
                    if (hashMap.get("borderColor") != null) {
                        tKText2.setBorderColor((String) hashMap.get("borderColor"));
                    }
                    if (hashMap.get("borderRadius") != null) {
                        tKText2.setBorderRadius((int) trans((Number) hashMap.get("borderRadius")));
                    }
                    if (hashMap.get("borderStyle") != null) {
                        tKText2.setBorderStyle((String) hashMap.get("borderStyle"));
                    }
                    if (hashMap.get("borderWidth") != null) {
                        tKText2.setBorderWidth(trans((Number) hashMap.get("borderWidth")));
                    }
                    if (hashMap.get("bottomLeftRadius") != null) {
                        tKText2.setBottomLeftRadius((int) trans((Number) hashMap.get("bottomLeftRadius")));
                    }
                    if (hashMap.get("bottomRightRadius") != null) {
                        tKText2.setBottomRightRadius((int) trans((Number) hashMap.get("bottomRightRadius")));
                    }
                    if (hashMap.get("color") != null) {
                        tKText2.setColor((String) hashMap.get("color"));
                    }
                    if (hashMap.get(CriusAttrConstants.DISPLAY) != null) {
                        tKText2.setDisplay((String) hashMap.get(CriusAttrConstants.DISPLAY));
                    }
                    if (hashMap.get("fontFamily") != null) {
                        tKText2.setFontFamily((String) hashMap.get("fontFamily"));
                    }
                    if (hashMap.get(TtmlNode.ATTR_TTS_FONT_SIZE) != null) {
                        tKText2.setFontSize((int) trans((Number) hashMap.get(TtmlNode.ATTR_TTS_FONT_SIZE)));
                    }
                    if (hashMap.get(TtmlNode.ATTR_TTS_FONT_WEIGHT) != null) {
                        tKText2.setFontWeight((String) hashMap.get(TtmlNode.ATTR_TTS_FONT_WEIGHT));
                    }
                    if (hashMap.get("gradientBgColor") != null) {
                        tKText2.setGradientBgColor((String) hashMap.get("gradientBgColor"));
                    }
                    if (hashMap.get("includeFontPadding") != null) {
                        tKText2.setIncludeFontPadding(((Boolean) hashMap.get("includeFontPadding")).booleanValue());
                    }
                    if (hashMap.get("minimumTextScaleFactor") != null) {
                        tKText2.setMinimumScaleFactor((float) trans((Number) hashMap.get("minimumTextScaleFactor")));
                    }
                    if (hashMap.get(NativeConstants.OPACITY) != null) {
                        tKText2.setOpacity(trans((Number) hashMap.get(NativeConstants.OPACITY)));
                    }
                    if (hashMap.get("shadow") != null) {
                        tKText2.setShadow((String) hashMap.get("shadow"));
                    }
                    if (hashMap.get(TtmlNode.ATTR_TTS_TEXT_ALIGN) != null) {
                        tKText2.setTextAlign((String) hashMap.get(TtmlNode.ATTR_TTS_TEXT_ALIGN));
                    }
                    if (hashMap.get(TtmlNode.ATTR_TTS_TEXT_DECORATION) != null) {
                        tKText2.setTextDecoration((String) hashMap.get(TtmlNode.ATTR_TTS_TEXT_DECORATION));
                    }
                    if (hashMap.get("textLineClamp") != null) {
                        tKText2.setTextLineClamp((int) trans((Number) hashMap.get("textLineClamp")));
                    }
                    if (hashMap.get("textLineHeight") != null) {
                        tKText2.setTextLineHeight((Number) hashMap.get("textLineHeight"));
                    }
                    if (hashMap.get("textLineSpace") != null) {
                        tKText2.setTextLineSpace((Number) hashMap.get("textLineSpace"));
                    }
                    if (hashMap.get("textOverflow") != null) {
                        tKText2.setTextOverflow((String) hashMap.get("textOverflow"));
                    }
                    if (hashMap.get("topLeftRadius") != null) {
                        tKText2.setTopLeftRadius((int) trans((Number) hashMap.get("topLeftRadius")));
                    }
                    if (hashMap.get("topRightRadius") != null) {
                        tKText2.setTopRightRadius((int) trans((Number) hashMap.get("topRightRadius")));
                    }
                    obj2 = "visibility";
                    tKText = tKText2;
                    if (hashMap.get(obj2) == null) {
                        return;
                    }
                    tKText.setVisibility((String) hashMap.get(obj2));
                    return;
                case 17:
                    TKBase tKBase9 = (TKView) obj;
                    if (hashMap.get("backgroundColor") != null) {
                        tKBase9.setBackgroundColor(hashMap.get("backgroundColor"));
                    }
                    if (hashMap.get("backgroundImage") != null) {
                        tKBase9.setBackgroundImage((String) hashMap.get("backgroundImage"));
                    }
                    if (hashMap.get("borderColor") != null) {
                        tKBase9.setBorderColor((String) hashMap.get("borderColor"));
                    }
                    if (hashMap.get("borderRadius") != null) {
                        tKBase9.setBorderRadius((int) trans((Number) hashMap.get("borderRadius")));
                    }
                    if (hashMap.get("borderStyle") != null) {
                        tKBase9.setBorderStyle((String) hashMap.get("borderStyle"));
                    }
                    if (hashMap.get("borderWidth") != null) {
                        tKBase9.setBorderWidth(trans((Number) hashMap.get("borderWidth")));
                    }
                    if (hashMap.get("bottomLeftRadius") != null) {
                        tKBase9.setBottomLeftRadius((int) trans((Number) hashMap.get("bottomLeftRadius")));
                    }
                    if (hashMap.get("bottomRightRadius") != null) {
                        tKBase9.setBottomRightRadius((int) trans((Number) hashMap.get("bottomRightRadius")));
                    }
                    if (hashMap.get(CriusAttrConstants.DISPLAY) != null) {
                        tKBase9.setDisplay((String) hashMap.get(CriusAttrConstants.DISPLAY));
                    }
                    if (hashMap.get("gradientBgColor") != null) {
                        tKBase9.setGradientBgColor((String) hashMap.get("gradientBgColor"));
                    }
                    if (hashMap.get(NativeConstants.OPACITY) != null) {
                        tKBase9.setOpacity(trans((Number) hashMap.get(NativeConstants.OPACITY)));
                    }
                    if (hashMap.get("shadow") != null) {
                        tKBase9.setShadow((String) hashMap.get("shadow"));
                    }
                    if (hashMap.get("topLeftRadius") != null) {
                        tKBase9.setTopLeftRadius((int) trans((Number) hashMap.get("topLeftRadius")));
                    }
                    if (hashMap.get("topRightRadius") != null) {
                        tKBase9.setTopRightRadius((int) trans((Number) hashMap.get("topRightRadius")));
                    }
                    obj2 = "visibility";
                    tKText = tKBase9;
                    if (hashMap.get(obj2) == null) {
                        return;
                    }
                    tKText.setVisibility((String) hashMap.get(obj2));
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.tachikoma.core.manager.IProvider
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.tachikoma.core.manager.IProvider
    public HashMap<String, String> get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.tachikoma.core.manager.IProvider
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.tachikoma.core.manager.IProvider
    public Object of(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return null;
        }
        return invokeL.objValue;
    }

    @Override // com.tachikoma.core.manager.IProvider
    public HashMap<String, Object> retrieveEvent(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, obj)) == null) {
            return null;
        }
        return (HashMap) invokeLL.objValue;
    }
}
