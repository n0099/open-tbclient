package com.tachikoma.core;

import com.alibaba.fastjson.parser.JSONLexer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.sapi2.SapiOptions;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.maxicode.decoder.DecodedBitStreamParser;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tachikoma.core.component.TKBase;
import com.tachikoma.core.component.anim.AnimationProperty;
import com.tachikoma.core.component.anim.TKBasicAnimation;
import com.tachikoma.core.component.anim.TKKeyframeAnimation;
import com.tachikoma.core.component.anim.TKSpringAnimation;
import com.tachikoma.core.component.button.StyleHelper;
import com.tachikoma.core.component.button.TKButton;
import com.tachikoma.core.component.imageview.TKImage;
import com.tachikoma.core.component.input.TKInput;
import com.tachikoma.core.component.input.TKTextArea;
import com.tachikoma.core.component.listview.TKIndicator;
import com.tachikoma.core.component.listview.TKListView;
import com.tachikoma.core.component.listview.TKRecyclerView;
import com.tachikoma.core.component.listview.TKViewPager;
import com.tachikoma.core.component.listview.TKWaterListView;
import com.tachikoma.core.component.network.Network;
import com.tachikoma.core.component.network.NetworkError;
import com.tachikoma.core.component.progressbar.KTProgressBarView;
import com.tachikoma.core.component.recyclerview.export.TKRefreshAnimatableView;
import com.tachikoma.core.component.recyclerview.export.TKRefreshControl;
import com.tachikoma.core.component.switchview.TKSwitch;
import com.tachikoma.core.component.text.SpanItem;
import com.tachikoma.core.component.text.TKMarqueeText;
import com.tachikoma.core.component.text.TKSpan;
import com.tachikoma.core.component.text.TKText;
import com.tachikoma.core.component.toast.TKToast;
import com.tachikoma.core.component.view.TKView;
import com.tachikoma.core.event.base.TKBaseEvent;
import com.tachikoma.core.event.guesture.TKDispatchEvent;
import com.tachikoma.core.event.guesture.TKDownEvent;
import com.tachikoma.core.event.guesture.TKLongPressEvent;
import com.tachikoma.core.event.guesture.TKPanEvent;
import com.tachikoma.core.event.guesture.TKPinchEvent;
import com.tachikoma.core.event.guesture.TKSwipeEvent;
import com.tachikoma.core.event.guesture.TKTapEvent;
import com.tachikoma.core.event.guesture.TKUpEvent;
import com.tachikoma.core.event.view.TKInputEvent;
import com.tachikoma.core.event.view.TKScrollEvent;
import com.tachikoma.core.event.view.TKSwitchEvent;
import com.tachikoma.core.manager.IProvider;
import com.yy.gslbsdk.db.DelayTB;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.CharUtils;
/* loaded from: classes3.dex */
public class PropertyProvider implements IProvider<ArrayList<String>> {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, ArrayList<String>> attributeMap;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(890243359, "Lcom/tachikoma/core/PropertyProvider;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(890243359, "Lcom/tachikoma/core/PropertyProvider;");
                return;
            }
        }
        attributeMap = new HashMap<>(49);
    }

    public PropertyProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static double trans(Number number) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, number)) == null) ? number.doubleValue() : invokeL.doubleValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tachikoma.core.manager.IProvider
    public void apply(String str, Object obj, HashMap<String, Object> hashMap) {
        char c2;
        TKInput tKInput;
        TKWaterListView tKWaterListView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, obj, hashMap) == null) {
            switch (str.hashCode()) {
                case -1834700363:
                    if (str.equals("com.tachikoma.core.component.toast.TKToast")) {
                        c2 = 17;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1815682644:
                    if (str.equals("com.tachikoma.core.component.listview.TKWaterListView")) {
                        c2 = ' ';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1674121254:
                    if (str.equals("com.tachikoma.core.component.network.Network")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1568538173:
                    if (str.equals("com.tachikoma.core.component.recyclerview.export.TKRefreshAnimatableView")) {
                        c2 = JSONLexer.EOI;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1490734452:
                    if (str.equals("com.tachikoma.core.component.switchview.TKSwitch")) {
                        c2 = '#';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1414476437:
                    if (str.equals("com.tachikoma.core.component.text.TKMarqueeText")) {
                        c2 = '\"';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1289269710:
                    if (str.equals("com.tachikoma.core.component.listview.TKRecyclerView")) {
                        c2 = DecodedBitStreamParser.FS;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1114153406:
                    if (str.equals("com.tachikoma.core.component.imageview.TKImage")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -785089643:
                    if (str.equals("com.tachikoma.core.event.guesture.TKTapEvent")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -698705626:
                    if (str.equals("com.tachikoma.core.component.progressbar.KTProgressBarView")) {
                        c2 = 27;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -665940655:
                    if (str.equals("com.tachikoma.core.component.button.TKButton")) {
                        c2 = 22;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -473380274:
                    if (str.equals("com.tachikoma.core.component.network.NetworkError")) {
                        c2 = CharUtils.CR;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -324017669:
                    if (str.equals("com.tachikoma.core.component.input.TKInput")) {
                        c2 = 25;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 58022346:
                    if (str.equals("com.tachikoma.core.component.text.SpanItem")) {
                        c2 = 31;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 100018365:
                    if (str.equals("com.tachikoma.core.component.recyclerview.export.TKRefreshControl")) {
                        c2 = DecodedBitStreamParser.RS;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 207479518:
                    if (str.equals("com.tachikoma.core.event.guesture.TKSwipeEvent")) {
                        c2 = '\n';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 283516449:
                    if (str.equals("com.tachikoma.core.event.guesture.TKUpEvent")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 374651097:
                    if (str.equals("com.tachikoma.core.event.view.TKInputEvent")) {
                        c2 = 11;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 591158801:
                    if (str.equals("com.tachikoma.core.component.listview.TKListView")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 753880526:
                    if (str.equals("com.tachikoma.core.component.text.TKSpan")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 753900465:
                    if (str.equals("com.tachikoma.core.component.text.TKText")) {
                        c2 = 18;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 776345307:
                    if (str.equals("com.tachikoma.core.event.guesture.TKPanEvent")) {
                        c2 = 16;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 791338032:
                    if (str.equals("com.tachikoma.core.component.listview.TKViewPager")) {
                        c2 = 24;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 801286025:
                    if (str.equals("com.tachikoma.core.component.input.TKTextArea")) {
                        c2 = '\f';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 854630252:
                    if (str.equals("com.tachikoma.core.event.base.TKBaseEvent")) {
                        c2 = 19;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1222308567:
                    if (str.equals("com.tachikoma.core.component.anim.TKSpringAnimation")) {
                        c2 = DecodedBitStreamParser.GS;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1266328598:
                    if (str.equals("com.tachikoma.core.component.anim.TKBasicAnimation")) {
                        c2 = 14;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1476104452:
                    if (str.equals("com.tachikoma.core.event.view.TKScrollEvent")) {
                        c2 = 23;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1540024573:
                    if (str.equals("com.tachikoma.core.event.view.TKSwitchEvent")) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1584334001:
                    if (str.equals("com.tachikoma.core.component.view.TKView")) {
                        c2 = 20;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1666774561:
                    if (str.equals("com.tachikoma.core.component.listview.TKIndicator")) {
                        c2 = '!';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1681697314:
                    if (str.equals("com.tachikoma.core.event.guesture.TKDispatchEvent")) {
                        c2 = 21;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1726485521:
                    if (str.equals("com.tachikoma.core.event.guesture.TKLongPressEvent")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1888937310:
                    if (str.equals("com.tachikoma.core.event.guesture.TKPinchEvent")) {
                        c2 = 15;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1962664954:
                    if (str.equals("com.tachikoma.core.event.guesture.TKDownEvent")) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2069490582:
                    if (str.equals("com.tachikoma.core.component.anim.TKKeyframeAnimation")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    TKImage tKImage = (TKImage) obj;
                    if (hashMap.get("lottieRes") != null) {
                        tKImage.lottieRes = (String) hashMap.get("lottieRes");
                    }
                    if (hashMap.get("lottiePath") != null) {
                        tKImage.lottiePath = (String) hashMap.get("lottiePath");
                    }
                    if (hashMap.get("viewID") != null) {
                        tKImage.setViewID((String) hashMap.get("viewID"));
                    }
                    if (hashMap.get("style") != null) {
                        tKImage.setStyle(new HashMap((Map) hashMap.get("style")));
                    }
                    if (hashMap.get(SapiOptions.KEY_CACHE_ENABLED) != null) {
                        tKImage.setEnabled(((Boolean) hashMap.get(SapiOptions.KEY_CACHE_ENABLED)).booleanValue());
                    }
                    if (hashMap.get("uri") != null) {
                        tKImage.setUri((String) hashMap.get("uri"));
                    }
                    if (hashMap.get("src") != null) {
                        tKImage.setSrc((String) hashMap.get("src"));
                    }
                    if (hashMap.get("blurRadius") != null) {
                        tKImage.setBlurRadius((int) trans((Number) hashMap.get("blurRadius")));
                        return;
                    }
                    return;
                case 1:
                    TKTapEvent tKTapEvent = (TKTapEvent) obj;
                    if (hashMap.get("motionType") != null) {
                        tKTapEvent.setState((int) trans((Number) hashMap.get("motionType")));
                    }
                    if (hashMap.get("type") != null) {
                        tKTapEvent.setType((String) hashMap.get("type"));
                    }
                    if (hashMap.get("data") != null) {
                        tKTapEvent.configWithData(new HashMap<>((Map) hashMap.get("data")));
                    }
                    if (hashMap.get("position") != null) {
                        tKTapEvent.setPosition(new HashMap<>((Map) hashMap.get("position")));
                        return;
                    }
                    return;
                case 2:
                    TKBase tKBase = (TKSpan) obj;
                    if (hashMap.get("lottieRes") != null) {
                        tKBase.lottieRes = (String) hashMap.get("lottieRes");
                    }
                    if (hashMap.get("lottiePath") != null) {
                        tKBase.lottiePath = (String) hashMap.get("lottiePath");
                    }
                    if (hashMap.get("viewID") != null) {
                        tKBase.setViewID((String) hashMap.get("viewID"));
                    }
                    if (hashMap.get("style") != null) {
                        tKBase.setStyle(new HashMap((Map) hashMap.get("style")));
                    }
                    tKWaterListView = tKBase;
                    if (hashMap.get(SapiOptions.KEY_CACHE_ENABLED) == null) {
                        return;
                    }
                    tKWaterListView.setEnabled(((Boolean) hashMap.get(SapiOptions.KEY_CACHE_ENABLED)).booleanValue());
                    return;
                case 3:
                    Network network = (Network) obj;
                    if (hashMap.get("scheme") != null) {
                        network.setScheme((String) hashMap.get("scheme"));
                    }
                    if (hashMap.get("timeoutInterval") != null) {
                        network.setInterval((int) trans((Number) hashMap.get("timeoutInterval")));
                    }
                    if (hashMap.get("host") != null) {
                        network.setHost((String) hashMap.get("host"));
                    }
                    if (hashMap.get("userInfo") != null) {
                        network.setUserInfo(new HashMap((Map) hashMap.get("userInfo")));
                    }
                    if (hashMap.get("bodyParameters") != null) {
                        network.setBody(new HashMap((Map) hashMap.get("bodyParameters")));
                    }
                    if (hashMap.get("path") != null) {
                        network.setPath((String) hashMap.get("path"));
                    }
                    if (hashMap.get(PushConstants.PARAMS) != null) {
                        network.setParams(new HashMap((Map) hashMap.get(PushConstants.PARAMS)));
                    }
                    if (hashMap.get("headers") != null) {
                        network.setHeader(new HashMap((Map) hashMap.get("headers")));
                        return;
                    }
                    return;
                case 4:
                    TKLongPressEvent tKLongPressEvent = (TKLongPressEvent) obj;
                    if (hashMap.get("motionType") != null) {
                        tKLongPressEvent.setState((int) trans((Number) hashMap.get("motionType")));
                    }
                    if (hashMap.get("type") != null) {
                        tKLongPressEvent.setType((String) hashMap.get("type"));
                    }
                    if (hashMap.get("data") != null) {
                        tKLongPressEvent.configWithData(new HashMap<>((Map) hashMap.get("data")));
                    }
                    if (hashMap.get("position") != null) {
                        tKLongPressEvent.setPosition(new HashMap<>((Map) hashMap.get("position")));
                        return;
                    }
                    return;
                case 5:
                    TKKeyframeAnimation tKKeyframeAnimation = (TKKeyframeAnimation) obj;
                    if (hashMap.get("needTranformIdentity") != null) {
                        tKKeyframeAnimation.setNeedTranformIdentity(((Boolean) hashMap.get("needTranformIdentity")).booleanValue());
                    }
                    if (hashMap.get("animValue") != null) {
                        tKKeyframeAnimation.setAnimValue(hashMap.get("animValue"));
                    }
                    if (hashMap.get(DelayTB.DELAY) != null) {
                        tKKeyframeAnimation.setDelay((float) trans((Number) hashMap.get(DelayTB.DELAY)));
                    }
                    if (hashMap.get("timingFunction") != null) {
                        tKKeyframeAnimation.setTimingFunction((String) hashMap.get("timingFunction"));
                    }
                    if (hashMap.get("duration") != null) {
                        tKKeyframeAnimation.setDuration((float) trans((Number) hashMap.get("duration")));
                    }
                    if (hashMap.get("animType") != null) {
                        tKKeyframeAnimation.setAnimType((String) hashMap.get("animType"));
                    }
                    if (hashMap.get("repeatCount") != null) {
                        tKKeyframeAnimation.setRepeatCount((int) trans((Number) hashMap.get("repeatCount")));
                    }
                    if (hashMap.get("autoReverse") != null) {
                        tKKeyframeAnimation.setAutoReverse(((Boolean) hashMap.get("autoReverse")).booleanValue());
                    }
                    if (hashMap.get("timeFunction") != null) {
                        tKKeyframeAnimation.setTimeFunction((String) hashMap.get("timeFunction"));
                    }
                    if (hashMap.get("keyframes") != null) {
                        tKKeyframeAnimation.setKeyframes(new ArrayList<>((List) hashMap.get("keyframes")));
                        return;
                    }
                    return;
                case 6:
                    TKUpEvent tKUpEvent = (TKUpEvent) obj;
                    if (hashMap.get("motionType") != null) {
                        tKUpEvent.setState((int) trans((Number) hashMap.get("motionType")));
                    }
                    if (hashMap.get("type") != null) {
                        tKUpEvent.setType((String) hashMap.get("type"));
                    }
                    if (hashMap.get("data") != null) {
                        tKUpEvent.configWithData(new HashMap<>((Map) hashMap.get("data")));
                    }
                    if (hashMap.get("position") != null) {
                        tKUpEvent.setPosition(new HashMap<>((Map) hashMap.get("position")));
                        return;
                    }
                    return;
                case 7:
                    TKBase tKBase2 = (TKListView) obj;
                    if (hashMap.get("lottieRes") != null) {
                        tKBase2.lottieRes = (String) hashMap.get("lottieRes");
                    }
                    if (hashMap.get("lottiePath") != null) {
                        tKBase2.lottiePath = (String) hashMap.get("lottiePath");
                    }
                    if (hashMap.get("viewID") != null) {
                        tKBase2.setViewID((String) hashMap.get("viewID"));
                    }
                    if (hashMap.get("style") != null) {
                        tKBase2.setStyle(new HashMap((Map) hashMap.get("style")));
                    }
                    tKWaterListView = tKBase2;
                    if (hashMap.get(SapiOptions.KEY_CACHE_ENABLED) == null) {
                        return;
                    }
                    tKWaterListView.setEnabled(((Boolean) hashMap.get(SapiOptions.KEY_CACHE_ENABLED)).booleanValue());
                    return;
                case '\b':
                    TKDownEvent tKDownEvent = (TKDownEvent) obj;
                    if (hashMap.get("motionType") != null) {
                        tKDownEvent.setState((int) trans((Number) hashMap.get("motionType")));
                    }
                    if (hashMap.get("type") != null) {
                        tKDownEvent.setType((String) hashMap.get("type"));
                    }
                    if (hashMap.get("data") != null) {
                        tKDownEvent.configWithData(new HashMap<>((Map) hashMap.get("data")));
                    }
                    if (hashMap.get("position") != null) {
                        tKDownEvent.setPosition(new HashMap<>((Map) hashMap.get("position")));
                        return;
                    }
                    return;
                case '\t':
                    TKSwitchEvent tKSwitchEvent = (TKSwitchEvent) obj;
                    if (hashMap.get("motionType") != null) {
                        tKSwitchEvent.setState((int) trans((Number) hashMap.get("motionType")));
                    }
                    if (hashMap.get("type") != null) {
                        tKSwitchEvent.setType((String) hashMap.get("type"));
                    }
                    if (hashMap.get("data") != null) {
                        tKSwitchEvent.configWithData(new HashMap<>((Map) hashMap.get("data")));
                    }
                    if (hashMap.get("state") != null) {
                        tKSwitchEvent.setState(((Boolean) hashMap.get("state")).booleanValue());
                        return;
                    }
                    return;
                case '\n':
                    TKSwipeEvent tKSwipeEvent = (TKSwipeEvent) obj;
                    if (hashMap.get("motionType") != null) {
                        tKSwipeEvent.setState((int) trans((Number) hashMap.get("motionType")));
                    }
                    if (hashMap.get("type") != null) {
                        tKSwipeEvent.setType((String) hashMap.get("type"));
                    }
                    if (hashMap.get("data") != null) {
                        tKSwipeEvent.configWithData(new HashMap<>((Map) hashMap.get("data")));
                    }
                    if (hashMap.get("direction") != null) {
                        tKSwipeEvent.setDirection((String) hashMap.get("direction"));
                        return;
                    }
                    return;
                case 11:
                    TKInputEvent tKInputEvent = (TKInputEvent) obj;
                    if (hashMap.get("motionType") != null) {
                        tKInputEvent.setState((int) trans((Number) hashMap.get("motionType")));
                    }
                    if (hashMap.get("type") != null) {
                        tKInputEvent.setType((String) hashMap.get("type"));
                    }
                    if (hashMap.get("data") != null) {
                        tKInputEvent.configWithData(new HashMap<>((Map) hashMap.get("data")));
                    }
                    if (hashMap.get("state") != null) {
                        tKInputEvent.setState((int) trans((Number) hashMap.get("state")));
                    }
                    if (hashMap.get("text") != null) {
                        tKInputEvent.setText((String) hashMap.get("text"));
                        return;
                    }
                    return;
                case '\f':
                    tKInput = (TKTextArea) obj;
                    if (hashMap.get("lottieRes") != null) {
                        tKInput.lottieRes = (String) hashMap.get("lottieRes");
                    }
                    if (hashMap.get("lottiePath") != null) {
                        tKInput.lottiePath = (String) hashMap.get("lottiePath");
                    }
                    if (hashMap.get("placeholder") != null) {
                        tKInput.setPlaceholder((String) hashMap.get("placeholder"));
                    }
                    if (hashMap.get("viewID") != null) {
                        tKInput.setViewID((String) hashMap.get("viewID"));
                    }
                    if (hashMap.get("style") != null) {
                        tKInput.setStyle(new HashMap((Map) hashMap.get("style")));
                    }
                    if (hashMap.get("focused") != null) {
                        tKInput.setFocused(((Boolean) hashMap.get("focused")).booleanValue());
                    }
                    if (hashMap.get(SapiOptions.KEY_CACHE_ENABLED) != null) {
                        tKInput.setEnabled(((Boolean) hashMap.get(SapiOptions.KEY_CACHE_ENABLED)).booleanValue());
                    }
                    if (hashMap.get("text") == null) {
                        return;
                    }
                    tKInput.setText((String) hashMap.get("text"));
                    return;
                case '\r':
                    NetworkError networkError = (NetworkError) obj;
                    if (hashMap.get("msg") != null) {
                        networkError.setMsg((String) hashMap.get("msg"));
                    }
                    if (hashMap.get("code") != null) {
                        networkError.responseCode = (int) trans((Number) hashMap.get("code"));
                        return;
                    }
                    return;
                case 14:
                    TKBasicAnimation tKBasicAnimation = (TKBasicAnimation) obj;
                    if (hashMap.get("needTranformIdentity") != null) {
                        tKBasicAnimation.setNeedTranformIdentity(((Boolean) hashMap.get("needTranformIdentity")).booleanValue());
                    }
                    if (hashMap.get("animValue") != null) {
                        tKBasicAnimation.setAnimValue(hashMap.get("animValue"));
                    }
                    if (hashMap.get(DelayTB.DELAY) != null) {
                        tKBasicAnimation.setDelay((float) trans((Number) hashMap.get(DelayTB.DELAY)));
                    }
                    if (hashMap.get("timingFunction") != null) {
                        tKBasicAnimation.setTimingFunction((String) hashMap.get("timingFunction"));
                    }
                    if (hashMap.get("duration") != null) {
                        tKBasicAnimation.setDuration((float) trans((Number) hashMap.get("duration")));
                    }
                    if (hashMap.get("animType") != null) {
                        tKBasicAnimation.setAnimType((String) hashMap.get("animType"));
                    }
                    if (hashMap.get("repeatCount") != null) {
                        tKBasicAnimation.setRepeatCount((int) trans((Number) hashMap.get("repeatCount")));
                    }
                    if (hashMap.get("autoReverse") != null) {
                        tKBasicAnimation.setAutoReverse(((Boolean) hashMap.get("autoReverse")).booleanValue());
                    }
                    if (hashMap.get("timeFunction") != null) {
                        tKBasicAnimation.setTimeFunction((String) hashMap.get("timeFunction"));
                        return;
                    }
                    return;
                case 15:
                    TKPinchEvent tKPinchEvent = (TKPinchEvent) obj;
                    if (hashMap.get("motionType") != null) {
                        tKPinchEvent.setState((int) trans((Number) hashMap.get("motionType")));
                    }
                    if (hashMap.get("type") != null) {
                        tKPinchEvent.setType((String) hashMap.get("type"));
                    }
                    if (hashMap.get("data") != null) {
                        tKPinchEvent.configWithData(new HashMap<>((Map) hashMap.get("data")));
                    }
                    if (hashMap.get(AnimationProperty.SCALE) != null) {
                        tKPinchEvent.setScale((float) trans((Number) hashMap.get(AnimationProperty.SCALE)));
                        return;
                    }
                    return;
                case 16:
                    TKPanEvent tKPanEvent = (TKPanEvent) obj;
                    if (hashMap.get("motionType") != null) {
                        tKPanEvent.setState((int) trans((Number) hashMap.get("motionType")));
                    }
                    if (hashMap.get("type") != null) {
                        tKPanEvent.setType((String) hashMap.get("type"));
                    }
                    if (hashMap.get("data") != null) {
                        tKPanEvent.configWithData(new HashMap<>((Map) hashMap.get("data")));
                    }
                    if (hashMap.get("translation") != null) {
                        tKPanEvent.setTranslation(new HashMap<>((Map) hashMap.get("translation")));
                        return;
                    }
                    return;
                case 17:
                    TKToast tKToast = (TKToast) obj;
                    if (hashMap.get("content") != null) {
                        tKToast.content = (String) hashMap.get("content");
                        return;
                    }
                    return;
                case 18:
                    TKText tKText = (TKText) obj;
                    if (hashMap.get("lottieRes") != null) {
                        tKText.lottieRes = (String) hashMap.get("lottieRes");
                    }
                    if (hashMap.get("lottiePath") != null) {
                        tKText.lottiePath = (String) hashMap.get("lottiePath");
                    }
                    if (hashMap.get("viewID") != null) {
                        tKText.setViewID((String) hashMap.get("viewID"));
                    }
                    if (hashMap.get("style") != null) {
                        tKText.setStyle(new HashMap((Map) hashMap.get("style")));
                    }
                    if (hashMap.get(SapiOptions.KEY_CACHE_ENABLED) != null) {
                        tKText.setEnabled(((Boolean) hashMap.get(SapiOptions.KEY_CACHE_ENABLED)).booleanValue());
                    }
                    if (hashMap.get("formattedText") != null) {
                        tKText.setFormattedText((String) hashMap.get("formattedText"));
                    }
                    if (hashMap.get("text") != null) {
                        tKText.setText((String) hashMap.get("text"));
                        return;
                    }
                    return;
                case 19:
                    TKBaseEvent tKBaseEvent = (TKBaseEvent) obj;
                    if (hashMap.get("motionType") != null) {
                        tKBaseEvent.setState((int) trans((Number) hashMap.get("motionType")));
                    }
                    if (hashMap.get("type") != null) {
                        tKBaseEvent.setType((String) hashMap.get("type"));
                    }
                    if (hashMap.get("data") != null) {
                        tKBaseEvent.configWithData(new HashMap<>((Map) hashMap.get("data")));
                        return;
                    }
                    return;
                case 20:
                    TKView tKView = (TKView) obj;
                    if (hashMap.get("lottieRes") != null) {
                        tKView.lottieRes = (String) hashMap.get("lottieRes");
                    }
                    if (hashMap.get("lottiePath") != null) {
                        tKView.lottiePath = (String) hashMap.get("lottiePath");
                    }
                    if (hashMap.get("viewID") != null) {
                        tKView.setViewID((String) hashMap.get("viewID"));
                    }
                    if (hashMap.get("style") != null) {
                        tKView.setStyle(new HashMap((Map) hashMap.get("style")));
                    }
                    if (hashMap.get(SapiOptions.KEY_CACHE_ENABLED) != null) {
                        tKView.setEnabled(((Boolean) hashMap.get(SapiOptions.KEY_CACHE_ENABLED)).booleanValue());
                    }
                    if (hashMap.get("clipChildren") != null) {
                        tKView.setClipChildren(((Boolean) hashMap.get("clipChildren")).booleanValue());
                        return;
                    }
                    return;
                case 21:
                    TKDispatchEvent tKDispatchEvent = (TKDispatchEvent) obj;
                    if (hashMap.get("motionType") != null) {
                        tKDispatchEvent.setState((int) trans((Number) hashMap.get("motionType")));
                    }
                    if (hashMap.get("type") != null) {
                        tKDispatchEvent.setType((String) hashMap.get("type"));
                    }
                    if (hashMap.get("data") != null) {
                        tKDispatchEvent.configWithData(new HashMap<>((Map) hashMap.get("data")));
                    }
                    if (hashMap.get("position") != null) {
                        tKDispatchEvent.setPosition(new HashMap<>((Map) hashMap.get("position")));
                        return;
                    }
                    return;
                case 22:
                    TKButton tKButton = (TKButton) obj;
                    if (hashMap.get("lottieRes") != null) {
                        tKButton.lottieRes = (String) hashMap.get("lottieRes");
                    }
                    if (hashMap.get("lottiePath") != null) {
                        tKButton.lottiePath = (String) hashMap.get("lottiePath");
                    }
                    if (hashMap.get("viewID") != null) {
                        tKButton.setViewID((String) hashMap.get("viewID"));
                    }
                    if (hashMap.get("style") != null) {
                        tKButton.setStyle(new HashMap((Map) hashMap.get("style")));
                    }
                    if (hashMap.get(SapiOptions.KEY_CACHE_ENABLED) != null) {
                        tKButton.setEnabled(((Boolean) hashMap.get(SapiOptions.KEY_CACHE_ENABLED)).booleanValue());
                    }
                    if (hashMap.get(StyleHelper.KEY_ONDISABLE) != null) {
                        tKButton.setDisabled(new HashMap((Map) hashMap.get(StyleHelper.KEY_ONDISABLE)));
                    }
                    if (hashMap.get(StyleHelper.KEY_ONPRESS) != null) {
                        tKButton.setPressed(new HashMap((Map) hashMap.get(StyleHelper.KEY_ONPRESS)));
                    }
                    if (hashMap.get("text") != null) {
                        tKButton.setText((String) hashMap.get("text"));
                        return;
                    }
                    return;
                case 23:
                    TKScrollEvent tKScrollEvent = (TKScrollEvent) obj;
                    if (hashMap.get("motionType") != null) {
                        tKScrollEvent.setState((int) trans((Number) hashMap.get("motionType")));
                    }
                    if (hashMap.get("type") != null) {
                        tKScrollEvent.setType((String) hashMap.get("type"));
                    }
                    if (hashMap.get("data") != null) {
                        tKScrollEvent.configWithData(new HashMap<>((Map) hashMap.get("data")));
                    }
                    if (hashMap.get("scrollOffsetX") != null) {
                        tKScrollEvent.setScrollOffsetX((float) trans((Number) hashMap.get("scrollOffsetX")));
                    }
                    if (hashMap.get("state") != null) {
                        tKScrollEvent.setState((int) trans((Number) hashMap.get("state")));
                    }
                    if (hashMap.get("dy") != null) {
                        tKScrollEvent.setDy((float) trans((Number) hashMap.get("dy")));
                    }
                    if (hashMap.get("scrollOffsetY") != null) {
                        tKScrollEvent.setScrollOffsetY((float) trans((Number) hashMap.get("scrollOffsetY")));
                    }
                    if (hashMap.get("dx") != null) {
                        tKScrollEvent.setDx((float) trans((Number) hashMap.get("dx")));
                        return;
                    }
                    return;
                case 24:
                    TKBase tKBase3 = (TKViewPager) obj;
                    if (hashMap.get("lottieRes") != null) {
                        tKBase3.lottieRes = (String) hashMap.get("lottieRes");
                    }
                    if (hashMap.get("lottiePath") != null) {
                        tKBase3.lottiePath = (String) hashMap.get("lottiePath");
                    }
                    if (hashMap.get("viewID") != null) {
                        tKBase3.setViewID((String) hashMap.get("viewID"));
                    }
                    if (hashMap.get("style") != null) {
                        tKBase3.setStyle(new HashMap((Map) hashMap.get("style")));
                    }
                    tKWaterListView = tKBase3;
                    if (hashMap.get(SapiOptions.KEY_CACHE_ENABLED) == null) {
                        return;
                    }
                    tKWaterListView.setEnabled(((Boolean) hashMap.get(SapiOptions.KEY_CACHE_ENABLED)).booleanValue());
                    return;
                case 25:
                    tKInput = (TKInput) obj;
                    if (hashMap.get("lottieRes") != null) {
                        tKInput.lottieRes = (String) hashMap.get("lottieRes");
                    }
                    if (hashMap.get("lottiePath") != null) {
                        tKInput.lottiePath = (String) hashMap.get("lottiePath");
                    }
                    if (hashMap.get("viewID") != null) {
                        tKInput.setViewID((String) hashMap.get("viewID"));
                    }
                    if (hashMap.get("style") != null) {
                        tKInput.setStyle(new HashMap((Map) hashMap.get("style")));
                    }
                    if (hashMap.get(SapiOptions.KEY_CACHE_ENABLED) != null) {
                        tKInput.setEnabled(((Boolean) hashMap.get(SapiOptions.KEY_CACHE_ENABLED)).booleanValue());
                    }
                    if (hashMap.get("placeholder") != null) {
                        tKInput.setPlaceholder((String) hashMap.get("placeholder"));
                    }
                    if (hashMap.get("focused") != null) {
                        tKInput.setFocused(((Boolean) hashMap.get("focused")).booleanValue());
                    }
                    if (hashMap.get("text") == null) {
                        return;
                    }
                    tKInput.setText((String) hashMap.get("text"));
                    return;
                case 26:
                    TKBase tKBase4 = (TKRefreshAnimatableView) obj;
                    if (hashMap.get("lottieRes") != null) {
                        tKBase4.lottieRes = (String) hashMap.get("lottieRes");
                    }
                    if (hashMap.get("lottiePath") != null) {
                        tKBase4.lottiePath = (String) hashMap.get("lottiePath");
                    }
                    if (hashMap.get("viewID") != null) {
                        tKBase4.setViewID((String) hashMap.get("viewID"));
                    }
                    if (hashMap.get("style") != null) {
                        tKBase4.setStyle(new HashMap((Map) hashMap.get("style")));
                    }
                    tKWaterListView = tKBase4;
                    if (hashMap.get(SapiOptions.KEY_CACHE_ENABLED) == null) {
                        return;
                    }
                    tKWaterListView.setEnabled(((Boolean) hashMap.get(SapiOptions.KEY_CACHE_ENABLED)).booleanValue());
                    return;
                case 27:
                    KTProgressBarView kTProgressBarView = (KTProgressBarView) obj;
                    if (hashMap.get("lottieRes") != null) {
                        kTProgressBarView.lottieRes = (String) hashMap.get("lottieRes");
                    }
                    if (hashMap.get("lottiePath") != null) {
                        kTProgressBarView.lottiePath = (String) hashMap.get("lottiePath");
                    }
                    if (hashMap.get("viewID") != null) {
                        kTProgressBarView.setViewID((String) hashMap.get("viewID"));
                    }
                    if (hashMap.get("style") != null) {
                        kTProgressBarView.setStyle(new HashMap((Map) hashMap.get("style")));
                    }
                    if (hashMap.get(SapiOptions.KEY_CACHE_ENABLED) != null) {
                        kTProgressBarView.setEnabled(((Boolean) hashMap.get(SapiOptions.KEY_CACHE_ENABLED)).booleanValue());
                    }
                    if (hashMap.get("animating") != null) {
                        kTProgressBarView.setAnimating(((Boolean) hashMap.get("animating")).booleanValue());
                    }
                    if (hashMap.get("color") != null) {
                        kTProgressBarView.setColor((String) hashMap.get("color"));
                    }
                    if (hashMap.get("progress") != null) {
                        kTProgressBarView.setProgress(trans((Number) hashMap.get("progress")));
                        return;
                    }
                    return;
                case 28:
                    TKRecyclerView tKRecyclerView = (TKRecyclerView) obj;
                    if (hashMap.get("lottieRes") != null) {
                        tKRecyclerView.lottieRes = (String) hashMap.get("lottieRes");
                    }
                    if (hashMap.get("lottiePath") != null) {
                        tKRecyclerView.lottiePath = (String) hashMap.get("lottiePath");
                    }
                    if (hashMap.get("viewID") != null) {
                        tKRecyclerView.setViewID((String) hashMap.get("viewID"));
                    }
                    if (hashMap.get("style") != null) {
                        tKRecyclerView.setStyle(new HashMap((Map) hashMap.get("style")));
                    }
                    if (hashMap.get(SapiOptions.KEY_CACHE_ENABLED) != null) {
                        tKRecyclerView.setEnabled(((Boolean) hashMap.get(SapiOptions.KEY_CACHE_ENABLED)).booleanValue());
                    }
                    if (hashMap.get("endReachedThreshold") != null) {
                        tKRecyclerView.mOnEndReachedThreshold = (int) trans((Number) hashMap.get("endReachedThreshold"));
                        return;
                    }
                    return;
                case 29:
                    TKSpringAnimation tKSpringAnimation = (TKSpringAnimation) obj;
                    if (hashMap.get("needTranformIdentity") != null) {
                        tKSpringAnimation.setNeedTranformIdentity(((Boolean) hashMap.get("needTranformIdentity")).booleanValue());
                    }
                    if (hashMap.get("animValue") != null) {
                        tKSpringAnimation.setAnimValue(hashMap.get("animValue"));
                    }
                    if (hashMap.get(DelayTB.DELAY) != null) {
                        tKSpringAnimation.setDelay((float) trans((Number) hashMap.get(DelayTB.DELAY)));
                    }
                    if (hashMap.get("timingFunction") != null) {
                        tKSpringAnimation.setTimingFunction((String) hashMap.get("timingFunction"));
                    }
                    if (hashMap.get("duration") != null) {
                        tKSpringAnimation.setDuration((float) trans((Number) hashMap.get("duration")));
                    }
                    if (hashMap.get("animType") != null) {
                        tKSpringAnimation.setAnimType((String) hashMap.get("animType"));
                    }
                    if (hashMap.get("repeatCount") != null) {
                        tKSpringAnimation.setRepeatCount((int) trans((Number) hashMap.get("repeatCount")));
                    }
                    if (hashMap.get("autoReverse") != null) {
                        tKSpringAnimation.setAutoReverse(((Boolean) hashMap.get("autoReverse")).booleanValue());
                    }
                    if (hashMap.get("timeFunction") != null) {
                        tKSpringAnimation.setTimeFunction((String) hashMap.get("timeFunction"));
                    }
                    if (hashMap.get("damping") != null) {
                        tKSpringAnimation.setDamping((float) trans((Number) hashMap.get("damping")));
                    }
                    if (hashMap.get("stiffness") != null) {
                        tKSpringAnimation.setStiffness((float) trans((Number) hashMap.get("stiffness")));
                        return;
                    }
                    return;
                case 30:
                    TKBase tKBase5 = (TKRefreshControl) obj;
                    if (hashMap.get("lottieRes") != null) {
                        tKBase5.lottieRes = (String) hashMap.get("lottieRes");
                    }
                    if (hashMap.get("lottiePath") != null) {
                        tKBase5.lottiePath = (String) hashMap.get("lottiePath");
                    }
                    if (hashMap.get("viewID") != null) {
                        tKBase5.setViewID((String) hashMap.get("viewID"));
                    }
                    if (hashMap.get("style") != null) {
                        tKBase5.setStyle(new HashMap((Map) hashMap.get("style")));
                    }
                    tKWaterListView = tKBase5;
                    if (hashMap.get(SapiOptions.KEY_CACHE_ENABLED) == null) {
                        return;
                    }
                    tKWaterListView.setEnabled(((Boolean) hashMap.get(SapiOptions.KEY_CACHE_ENABLED)).booleanValue());
                    return;
                case 31:
                    SpanItem spanItem = (SpanItem) obj;
                    if (hashMap.get("lottieRes") != null) {
                        spanItem.lottieRes = (String) hashMap.get("lottieRes");
                    }
                    if (hashMap.get("lottiePath") != null) {
                        spanItem.lottiePath = (String) hashMap.get("lottiePath");
                    }
                    if (hashMap.get("viewID") != null) {
                        spanItem.setViewID((String) hashMap.get("viewID"));
                    }
                    if (hashMap.get("style") != null) {
                        spanItem.setStyle(new HashMap((Map) hashMap.get("style")));
                    }
                    if (hashMap.get(SapiOptions.KEY_CACHE_ENABLED) != null) {
                        spanItem.setEnabled(((Boolean) hashMap.get(SapiOptions.KEY_CACHE_ENABLED)).booleanValue());
                    }
                    if (hashMap.get(ShaderParams.IMAGE_WIDTH) != null) {
                        spanItem.imageWidth = (int) trans((Number) hashMap.get(ShaderParams.IMAGE_WIDTH));
                    }
                    if (hashMap.get("spanType") != null) {
                        spanItem.spanType = (String) hashMap.get("spanType");
                    }
                    if (hashMap.get("size") != null) {
                        spanItem.size = (int) trans((Number) hashMap.get("size"));
                    }
                    if (hashMap.get(AnimationProperty.MARGIN_LEFT) != null) {
                        spanItem.marginLeft = (float) trans((Number) hashMap.get(AnimationProperty.MARGIN_LEFT));
                    }
                    if (hashMap.get("url") != null) {
                        spanItem.url = (String) hashMap.get("url");
                    }
                    if (hashMap.get("offsetY") != null) {
                        spanItem.offsetY = (float) trans((Number) hashMap.get("offsetY"));
                    }
                    if (hashMap.get("end") != null) {
                        spanItem.end = (int) trans((Number) hashMap.get("end"));
                    }
                    if (hashMap.get(SpanItem.TYPE_TEXT_STYLE) != null) {
                        spanItem.textStyle = (String) hashMap.get(SpanItem.TYPE_TEXT_STYLE);
                    }
                    if (hashMap.get(ShaderParams.IMAGE_HEIGHT) != null) {
                        spanItem.imageHeight = (int) trans((Number) hashMap.get(ShaderParams.IMAGE_HEIGHT));
                    }
                    if (hashMap.get("index") != null) {
                        spanItem.index = (int) trans((Number) hashMap.get("index"));
                    }
                    if (hashMap.get("color") != null) {
                        spanItem.setColor((String) hashMap.get("color"));
                    }
                    if (hashMap.get(AnimationProperty.MARGIN_RIGHT) != null) {
                        spanItem.marginRight = (float) trans((Number) hashMap.get(AnimationProperty.MARGIN_RIGHT));
                    }
                    if (hashMap.get("offsetX") != null) {
                        spanItem.offsetX = (int) trans((Number) hashMap.get("offsetX"));
                    }
                    if (hashMap.get("start") != null) {
                        spanItem.start = (int) trans((Number) hashMap.get("start"));
                    }
                    if (hashMap.get("imageUrl") != null) {
                        spanItem.imageUrl = (String) hashMap.get("imageUrl");
                    }
                    if (hashMap.get(SpanItem.TYPE_FONT_FAMILY) != null) {
                        spanItem.fontFamily = (String) hashMap.get(SpanItem.TYPE_FONT_FAMILY);
                        return;
                    }
                    return;
                case ' ':
                    TKWaterListView tKWaterListView2 = (TKWaterListView) obj;
                    if (hashMap.get("lottieRes") != null) {
                        tKWaterListView2.lottieRes = (String) hashMap.get("lottieRes");
                    }
                    if (hashMap.get("lottiePath") != null) {
                        tKWaterListView2.lottiePath = (String) hashMap.get("lottiePath");
                    }
                    if (hashMap.get("viewID") != null) {
                        tKWaterListView2.setViewID((String) hashMap.get("viewID"));
                    }
                    if (hashMap.get("endReachedThreshold") != null) {
                        tKWaterListView2.mOnEndReachedThreshold = (int) trans((Number) hashMap.get("endReachedThreshold"));
                    }
                    if (hashMap.get("style") != null) {
                        tKWaterListView2.setStyle(new HashMap((Map) hashMap.get("style")));
                    }
                    tKWaterListView = tKWaterListView2;
                    if (hashMap.get(SapiOptions.KEY_CACHE_ENABLED) == null) {
                        return;
                    }
                    tKWaterListView.setEnabled(((Boolean) hashMap.get(SapiOptions.KEY_CACHE_ENABLED)).booleanValue());
                    return;
                case '!':
                    TKBase tKBase6 = (TKIndicator) obj;
                    if (hashMap.get("lottieRes") != null) {
                        tKBase6.lottieRes = (String) hashMap.get("lottieRes");
                    }
                    if (hashMap.get("lottiePath") != null) {
                        tKBase6.lottiePath = (String) hashMap.get("lottiePath");
                    }
                    if (hashMap.get("viewID") != null) {
                        tKBase6.setViewID((String) hashMap.get("viewID"));
                    }
                    if (hashMap.get("style") != null) {
                        tKBase6.setStyle(new HashMap((Map) hashMap.get("style")));
                    }
                    tKWaterListView = tKBase6;
                    if (hashMap.get(SapiOptions.KEY_CACHE_ENABLED) == null) {
                        return;
                    }
                    tKWaterListView.setEnabled(((Boolean) hashMap.get(SapiOptions.KEY_CACHE_ENABLED)).booleanValue());
                    return;
                case '\"':
                    TKMarqueeText tKMarqueeText = (TKMarqueeText) obj;
                    if (hashMap.get("lottieRes") != null) {
                        tKMarqueeText.lottieRes = (String) hashMap.get("lottieRes");
                    }
                    if (hashMap.get("lottiePath") != null) {
                        tKMarqueeText.lottiePath = (String) hashMap.get("lottiePath");
                    }
                    if (hashMap.get("viewID") != null) {
                        tKMarqueeText.setViewID((String) hashMap.get("viewID"));
                    }
                    if (hashMap.get("style") != null) {
                        tKMarqueeText.setStyle(new HashMap((Map) hashMap.get("style")));
                    }
                    if (hashMap.get(SapiOptions.KEY_CACHE_ENABLED) != null) {
                        tKMarqueeText.setEnabled(((Boolean) hashMap.get(SapiOptions.KEY_CACHE_ENABLED)).booleanValue());
                    }
                    if (hashMap.get("text") != null) {
                        tKMarqueeText.setText((String) hashMap.get("text"));
                        return;
                    }
                    return;
                case '#':
                    TKSwitch tKSwitch = (TKSwitch) obj;
                    if (hashMap.get("lottieRes") != null) {
                        tKSwitch.lottieRes = (String) hashMap.get("lottieRes");
                    }
                    if (hashMap.get("lottiePath") != null) {
                        tKSwitch.lottiePath = (String) hashMap.get("lottiePath");
                    }
                    if (hashMap.get("viewID") != null) {
                        tKSwitch.setViewID((String) hashMap.get("viewID"));
                    }
                    if (hashMap.get("style") != null) {
                        tKSwitch.setStyle(new HashMap((Map) hashMap.get("style")));
                    }
                    if (hashMap.get(SapiOptions.KEY_CACHE_ENABLED) != null) {
                        tKSwitch.setEnabled(((Boolean) hashMap.get(SapiOptions.KEY_CACHE_ENABLED)).booleanValue());
                    }
                    if (hashMap.get("checked") != null) {
                        tKSwitch.setChecked(((Boolean) hashMap.get("checked")).booleanValue());
                        return;
                    }
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
            attributeMap.clear();
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
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("lottieRes");
            arrayList.add("lottiePath");
            arrayList.add("viewID");
            arrayList.add("style");
            arrayList.add(SapiOptions.KEY_CACHE_ENABLED);
            arrayList.add("uri");
            arrayList.add("src");
            arrayList.add("blurRadius");
            attributeMap.put("com_tachikoma_core_component_imageview_TKImage", arrayList);
            ArrayList<String> arrayList2 = new ArrayList<>();
            arrayList2.add("motionType");
            arrayList2.add("type");
            arrayList2.add("data");
            arrayList2.add("position");
            attributeMap.put("com_tachikoma_core_event_guesture_TKTapEvent", arrayList2);
            ArrayList<String> arrayList3 = new ArrayList<>();
            arrayList3.add("lottieRes");
            arrayList3.add("lottiePath");
            arrayList3.add("viewID");
            arrayList3.add("style");
            arrayList3.add(SapiOptions.KEY_CACHE_ENABLED);
            attributeMap.put("com_tachikoma_core_component_text_TKSpan", arrayList3);
            ArrayList<String> arrayList4 = new ArrayList<>();
            arrayList4.add("scheme");
            arrayList4.add("timeoutInterval");
            arrayList4.add("host");
            arrayList4.add("userInfo");
            arrayList4.add("bodyParameters");
            arrayList4.add("path");
            arrayList4.add(PushConstants.PARAMS);
            arrayList4.add("headers");
            attributeMap.put("com_tachikoma_core_component_network_Network", arrayList4);
            ArrayList<String> arrayList5 = new ArrayList<>();
            arrayList5.add("motionType");
            arrayList5.add("type");
            arrayList5.add("data");
            arrayList5.add("position");
            attributeMap.put("com_tachikoma_core_event_guesture_TKLongPressEvent", arrayList5);
            ArrayList<String> arrayList6 = new ArrayList<>();
            arrayList6.add("needTranformIdentity");
            arrayList6.add("animValue");
            arrayList6.add(DelayTB.DELAY);
            arrayList6.add("timingFunction");
            arrayList6.add("duration");
            arrayList6.add("animType");
            arrayList6.add("repeatCount");
            arrayList6.add("autoReverse");
            arrayList6.add("timeFunction");
            arrayList6.add("keyframes");
            attributeMap.put("com_tachikoma_core_component_anim_TKKeyframeAnimation", arrayList6);
            ArrayList<String> arrayList7 = new ArrayList<>();
            arrayList7.add("motionType");
            arrayList7.add("type");
            arrayList7.add("data");
            arrayList7.add("position");
            attributeMap.put("com_tachikoma_core_event_guesture_TKUpEvent", arrayList7);
            ArrayList<String> arrayList8 = new ArrayList<>();
            arrayList8.add("lottieRes");
            arrayList8.add("lottiePath");
            arrayList8.add("viewID");
            arrayList8.add("style");
            arrayList8.add(SapiOptions.KEY_CACHE_ENABLED);
            attributeMap.put("com_tachikoma_core_component_listview_TKListView", arrayList8);
            ArrayList<String> arrayList9 = new ArrayList<>();
            arrayList9.add("motionType");
            arrayList9.add("type");
            arrayList9.add("data");
            arrayList9.add("position");
            attributeMap.put("com_tachikoma_core_event_guesture_TKDownEvent", arrayList9);
            ArrayList<String> arrayList10 = new ArrayList<>();
            arrayList10.add("motionType");
            arrayList10.add("type");
            arrayList10.add("data");
            arrayList10.add("state");
            attributeMap.put("com_tachikoma_core_event_view_TKSwitchEvent", arrayList10);
            ArrayList<String> arrayList11 = new ArrayList<>();
            arrayList11.add("motionType");
            arrayList11.add("type");
            arrayList11.add("data");
            arrayList11.add("direction");
            attributeMap.put("com_tachikoma_core_event_guesture_TKSwipeEvent", arrayList11);
            ArrayList<String> arrayList12 = new ArrayList<>();
            arrayList12.add("motionType");
            arrayList12.add("type");
            arrayList12.add("data");
            arrayList12.add("state");
            arrayList12.add("text");
            attributeMap.put("com_tachikoma_core_event_view_TKInputEvent", arrayList12);
            ArrayList<String> arrayList13 = new ArrayList<>();
            arrayList13.add("lottieRes");
            arrayList13.add("lottiePath");
            arrayList13.add("placeholder");
            arrayList13.add("viewID");
            arrayList13.add("style");
            arrayList13.add("focused");
            arrayList13.add(SapiOptions.KEY_CACHE_ENABLED);
            arrayList13.add("text");
            attributeMap.put("com_tachikoma_core_component_input_TKTextArea", arrayList13);
            ArrayList<String> arrayList14 = new ArrayList<>();
            arrayList14.add("msg");
            arrayList14.add("code");
            attributeMap.put("com_tachikoma_core_component_network_NetworkError", arrayList14);
            ArrayList<String> arrayList15 = new ArrayList<>();
            arrayList15.add("needTranformIdentity");
            arrayList15.add("animValue");
            arrayList15.add(DelayTB.DELAY);
            arrayList15.add("timingFunction");
            arrayList15.add("duration");
            arrayList15.add("animType");
            arrayList15.add("repeatCount");
            arrayList15.add("autoReverse");
            arrayList15.add("timeFunction");
            attributeMap.put("com_tachikoma_core_component_anim_TKBasicAnimation", arrayList15);
            ArrayList<String> arrayList16 = new ArrayList<>();
            arrayList16.add("motionType");
            arrayList16.add("type");
            arrayList16.add("data");
            arrayList16.add(AnimationProperty.SCALE);
            attributeMap.put("com_tachikoma_core_event_guesture_TKPinchEvent", arrayList16);
            ArrayList<String> arrayList17 = new ArrayList<>();
            arrayList17.add("motionType");
            arrayList17.add("type");
            arrayList17.add("data");
            arrayList17.add("translation");
            attributeMap.put("com_tachikoma_core_event_guesture_TKPanEvent", arrayList17);
            ArrayList<String> arrayList18 = new ArrayList<>();
            arrayList18.add("content");
            attributeMap.put("com_tachikoma_core_component_toast_TKToast", arrayList18);
            ArrayList<String> arrayList19 = new ArrayList<>();
            arrayList19.add("lottieRes");
            arrayList19.add("lottiePath");
            arrayList19.add("viewID");
            arrayList19.add("style");
            arrayList19.add(SapiOptions.KEY_CACHE_ENABLED);
            arrayList19.add("formattedText");
            arrayList19.add("text");
            attributeMap.put("com_tachikoma_core_component_text_TKText", arrayList19);
            ArrayList<String> arrayList20 = new ArrayList<>();
            arrayList20.add("motionType");
            arrayList20.add("type");
            arrayList20.add("data");
            attributeMap.put("com_tachikoma_core_event_base_TKBaseEvent", arrayList20);
            ArrayList<String> arrayList21 = new ArrayList<>();
            arrayList21.add("lottieRes");
            arrayList21.add("lottiePath");
            arrayList21.add("viewID");
            arrayList21.add("style");
            arrayList21.add(SapiOptions.KEY_CACHE_ENABLED);
            arrayList21.add("clipChildren");
            attributeMap.put("com_tachikoma_core_component_view_TKView", arrayList21);
            ArrayList<String> arrayList22 = new ArrayList<>();
            arrayList22.add("motionType");
            arrayList22.add("type");
            arrayList22.add("data");
            arrayList22.add("position");
            attributeMap.put("com_tachikoma_core_event_guesture_TKDispatchEvent", arrayList22);
            ArrayList<String> arrayList23 = new ArrayList<>();
            arrayList23.add("lottieRes");
            arrayList23.add("lottiePath");
            arrayList23.add("viewID");
            arrayList23.add("style");
            arrayList23.add(SapiOptions.KEY_CACHE_ENABLED);
            arrayList23.add(StyleHelper.KEY_ONDISABLE);
            arrayList23.add(StyleHelper.KEY_ONPRESS);
            arrayList23.add("text");
            attributeMap.put("com_tachikoma_core_component_button_TKButton", arrayList23);
            ArrayList<String> arrayList24 = new ArrayList<>();
            arrayList24.add("motionType");
            arrayList24.add("type");
            arrayList24.add("data");
            arrayList24.add("scrollOffsetX");
            arrayList24.add("state");
            arrayList24.add("dy");
            arrayList24.add("scrollOffsetY");
            arrayList24.add("dx");
            attributeMap.put("com_tachikoma_core_event_view_TKScrollEvent", arrayList24);
            ArrayList<String> arrayList25 = new ArrayList<>();
            arrayList25.add("lottieRes");
            arrayList25.add("lottiePath");
            arrayList25.add("viewID");
            arrayList25.add("style");
            arrayList25.add(SapiOptions.KEY_CACHE_ENABLED);
            attributeMap.put("com_tachikoma_core_component_listview_TKViewPager", arrayList25);
            ArrayList<String> arrayList26 = new ArrayList<>();
            arrayList26.add("lottieRes");
            arrayList26.add("lottiePath");
            arrayList26.add("viewID");
            arrayList26.add("style");
            arrayList26.add(SapiOptions.KEY_CACHE_ENABLED);
            arrayList26.add("placeholder");
            arrayList26.add("focused");
            arrayList26.add("text");
            attributeMap.put("com_tachikoma_core_component_input_TKInput", arrayList26);
            ArrayList<String> arrayList27 = new ArrayList<>();
            arrayList27.add("lottieRes");
            arrayList27.add("lottiePath");
            arrayList27.add("viewID");
            arrayList27.add("style");
            arrayList27.add(SapiOptions.KEY_CACHE_ENABLED);
            attributeMap.put("com_tachikoma_core_component_recyclerview_export_TKRefreshAnimatableView", arrayList27);
            ArrayList<String> arrayList28 = new ArrayList<>();
            arrayList28.add("lottieRes");
            arrayList28.add("lottiePath");
            arrayList28.add("viewID");
            arrayList28.add("style");
            arrayList28.add(SapiOptions.KEY_CACHE_ENABLED);
            arrayList28.add("animating");
            arrayList28.add("color");
            arrayList28.add("progress");
            attributeMap.put("com_tachikoma_core_component_progressbar_KTProgressBarView", arrayList28);
            ArrayList<String> arrayList29 = new ArrayList<>();
            arrayList29.add("lottieRes");
            arrayList29.add("lottiePath");
            arrayList29.add("viewID");
            arrayList29.add("style");
            arrayList29.add(SapiOptions.KEY_CACHE_ENABLED);
            arrayList29.add("endReachedThreshold");
            attributeMap.put("com_tachikoma_core_component_listview_TKRecyclerView", arrayList29);
            ArrayList<String> arrayList30 = new ArrayList<>();
            arrayList30.add("needTranformIdentity");
            arrayList30.add("animValue");
            arrayList30.add(DelayTB.DELAY);
            arrayList30.add("timingFunction");
            arrayList30.add("duration");
            arrayList30.add("animType");
            arrayList30.add("repeatCount");
            arrayList30.add("autoReverse");
            arrayList30.add("timeFunction");
            arrayList30.add("damping");
            arrayList30.add("stiffness");
            attributeMap.put("com_tachikoma_core_component_anim_TKSpringAnimation", arrayList30);
            ArrayList<String> arrayList31 = new ArrayList<>();
            arrayList31.add("lottieRes");
            arrayList31.add("lottiePath");
            arrayList31.add("viewID");
            arrayList31.add("style");
            arrayList31.add(SapiOptions.KEY_CACHE_ENABLED);
            attributeMap.put("com_tachikoma_core_component_recyclerview_export_TKRefreshControl", arrayList31);
            ArrayList<String> arrayList32 = new ArrayList<>();
            arrayList32.add("lottieRes");
            arrayList32.add("lottiePath");
            arrayList32.add("viewID");
            arrayList32.add("style");
            arrayList32.add(SapiOptions.KEY_CACHE_ENABLED);
            arrayList32.add(ShaderParams.IMAGE_WIDTH);
            arrayList32.add("spanType");
            arrayList32.add("size");
            arrayList32.add(AnimationProperty.MARGIN_LEFT);
            arrayList32.add("url");
            arrayList32.add("offsetY");
            arrayList32.add("end");
            arrayList32.add(SpanItem.TYPE_TEXT_STYLE);
            arrayList32.add(ShaderParams.IMAGE_HEIGHT);
            arrayList32.add("index");
            arrayList32.add("color");
            arrayList32.add(AnimationProperty.MARGIN_RIGHT);
            arrayList32.add("offsetX");
            arrayList32.add("start");
            arrayList32.add("imageUrl");
            arrayList32.add(SpanItem.TYPE_FONT_FAMILY);
            attributeMap.put("com_tachikoma_core_component_text_SpanItem", arrayList32);
            ArrayList<String> arrayList33 = new ArrayList<>();
            arrayList33.add("lottieRes");
            arrayList33.add("lottiePath");
            arrayList33.add("viewID");
            arrayList33.add("endReachedThreshold");
            arrayList33.add("style");
            arrayList33.add(SapiOptions.KEY_CACHE_ENABLED);
            attributeMap.put("com_tachikoma_core_component_listview_TKWaterListView", arrayList33);
            ArrayList<String> arrayList34 = new ArrayList<>();
            arrayList34.add("lottieRes");
            arrayList34.add("lottiePath");
            arrayList34.add("viewID");
            arrayList34.add("style");
            arrayList34.add(SapiOptions.KEY_CACHE_ENABLED);
            attributeMap.put("com_tachikoma_core_component_listview_TKIndicator", arrayList34);
            ArrayList<String> arrayList35 = new ArrayList<>();
            arrayList35.add("lottieRes");
            arrayList35.add("lottiePath");
            arrayList35.add("viewID");
            arrayList35.add("style");
            arrayList35.add(SapiOptions.KEY_CACHE_ENABLED);
            arrayList35.add("text");
            attributeMap.put("com_tachikoma_core_component_text_TKMarqueeText", arrayList35);
            ArrayList<String> arrayList36 = new ArrayList<>();
            arrayList36.add("lottieRes");
            arrayList36.add("lottiePath");
            arrayList36.add("viewID");
            arrayList36.add("style");
            arrayList36.add(SapiOptions.KEY_CACHE_ENABLED);
            arrayList36.add("checked");
            attributeMap.put("com_tachikoma_core_component_switchview_TKSwitch", arrayList36);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tachikoma.core.manager.IProvider
    public ArrayList<String> of(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? attributeMap.get(str) : (ArrayList) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tachikoma.core.manager.IProvider
    public HashMap<String, Object> retrieveEvent(String str, Object obj) {
        InterceptResult invokeLL;
        char c2;
        HashMap<String, Float> hashMap;
        Object obj2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, obj)) == null) {
            HashMap<String, Object> hashMap2 = new HashMap<>();
            switch (str.hashCode()) {
                case -785089643:
                    if (str.equals("com.tachikoma.core.event.guesture.TKTapEvent")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 207479518:
                    if (str.equals("com.tachikoma.core.event.guesture.TKSwipeEvent")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 283516449:
                    if (str.equals("com.tachikoma.core.event.guesture.TKUpEvent")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 374651097:
                    if (str.equals("com.tachikoma.core.event.view.TKInputEvent")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 776345307:
                    if (str.equals("com.tachikoma.core.event.guesture.TKPanEvent")) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 854630252:
                    if (str.equals("com.tachikoma.core.event.base.TKBaseEvent")) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1476104452:
                    if (str.equals("com.tachikoma.core.event.view.TKScrollEvent")) {
                        c2 = 11;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1540024573:
                    if (str.equals("com.tachikoma.core.event.view.TKSwitchEvent")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1681697314:
                    if (str.equals("com.tachikoma.core.event.guesture.TKDispatchEvent")) {
                        c2 = '\n';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1726485521:
                    if (str.equals("com.tachikoma.core.event.guesture.TKLongPressEvent")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1888937310:
                    if (str.equals("com.tachikoma.core.event.guesture.TKPinchEvent")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1962664954:
                    if (str.equals("com.tachikoma.core.event.guesture.TKDownEvent")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    TKTapEvent tKTapEvent = (TKTapEvent) obj;
                    hashMap2.put("motionType", Integer.valueOf(tKTapEvent.state));
                    hashMap2.put("type", tKTapEvent.type);
                    hashMap2.put("data", tKTapEvent.mData);
                    hashMap = tKTapEvent.mPosition;
                    hashMap2.put("position", hashMap);
                    break;
                case 1:
                    TKLongPressEvent tKLongPressEvent = (TKLongPressEvent) obj;
                    hashMap2.put("motionType", Integer.valueOf(tKLongPressEvent.state));
                    hashMap2.put("type", tKLongPressEvent.type);
                    hashMap2.put("data", tKLongPressEvent.mData);
                    hashMap = tKLongPressEvent.mPosition;
                    hashMap2.put("position", hashMap);
                    break;
                case 2:
                    TKUpEvent tKUpEvent = (TKUpEvent) obj;
                    hashMap2.put("motionType", Integer.valueOf(tKUpEvent.state));
                    hashMap2.put("type", tKUpEvent.type);
                    hashMap2.put("data", tKUpEvent.mData);
                    hashMap = tKUpEvent.mPosition;
                    hashMap2.put("position", hashMap);
                    break;
                case 3:
                    TKDownEvent tKDownEvent = (TKDownEvent) obj;
                    hashMap2.put("motionType", Integer.valueOf(tKDownEvent.state));
                    hashMap2.put("type", tKDownEvent.type);
                    hashMap2.put("data", tKDownEvent.mData);
                    hashMap = tKDownEvent.mPosition;
                    hashMap2.put("position", hashMap);
                    break;
                case 4:
                    TKSwitchEvent tKSwitchEvent = (TKSwitchEvent) obj;
                    hashMap2.put("motionType", Boolean.valueOf(tKSwitchEvent.state));
                    hashMap2.put("type", tKSwitchEvent.type);
                    hashMap2.put("data", tKSwitchEvent.mData);
                    hashMap2.put("state", Boolean.valueOf(tKSwitchEvent.state));
                    break;
                case 5:
                    TKSwipeEvent tKSwipeEvent = (TKSwipeEvent) obj;
                    hashMap2.put("motionType", Integer.valueOf(tKSwipeEvent.state));
                    hashMap2.put("type", tKSwipeEvent.type);
                    hashMap2.put("data", tKSwipeEvent.mData);
                    obj2 = tKSwipeEvent.direction;
                    str2 = "direction";
                    hashMap2.put(str2, obj2);
                    break;
                case 6:
                    TKInputEvent tKInputEvent = (TKInputEvent) obj;
                    hashMap2.put("motionType", Integer.valueOf(tKInputEvent.state));
                    hashMap2.put("type", tKInputEvent.type);
                    hashMap2.put("data", tKInputEvent.mData);
                    hashMap2.put("state", Integer.valueOf(tKInputEvent.state));
                    obj2 = tKInputEvent.text;
                    str2 = "text";
                    hashMap2.put(str2, obj2);
                    break;
                case 7:
                    TKPinchEvent tKPinchEvent = (TKPinchEvent) obj;
                    hashMap2.put("motionType", Integer.valueOf(tKPinchEvent.state));
                    hashMap2.put("type", tKPinchEvent.type);
                    hashMap2.put("data", tKPinchEvent.mData);
                    obj2 = Float.valueOf(tKPinchEvent.scale);
                    str2 = AnimationProperty.SCALE;
                    hashMap2.put(str2, obj2);
                    break;
                case '\b':
                    TKPanEvent tKPanEvent = (TKPanEvent) obj;
                    hashMap2.put("motionType", Integer.valueOf(tKPanEvent.state));
                    hashMap2.put("type", tKPanEvent.type);
                    hashMap2.put("data", tKPanEvent.mData);
                    obj2 = tKPanEvent.mTranslation;
                    str2 = "translation";
                    hashMap2.put(str2, obj2);
                    break;
                case '\t':
                    TKBaseEvent tKBaseEvent = (TKBaseEvent) obj;
                    hashMap2.put("motionType", Integer.valueOf(tKBaseEvent.state));
                    hashMap2.put("type", tKBaseEvent.type);
                    hashMap2.put("data", tKBaseEvent.mData);
                    break;
                case '\n':
                    TKDispatchEvent tKDispatchEvent = (TKDispatchEvent) obj;
                    hashMap2.put("motionType", Integer.valueOf(tKDispatchEvent.state));
                    hashMap2.put("type", tKDispatchEvent.type);
                    hashMap2.put("data", tKDispatchEvent.mData);
                    hashMap = tKDispatchEvent.mPosition;
                    hashMap2.put("position", hashMap);
                    break;
                case 11:
                    TKScrollEvent tKScrollEvent = (TKScrollEvent) obj;
                    hashMap2.put("motionType", Integer.valueOf(tKScrollEvent.state));
                    hashMap2.put("type", tKScrollEvent.type);
                    hashMap2.put("data", tKScrollEvent.mData);
                    hashMap2.put("scrollOffsetX", Float.valueOf(tKScrollEvent.scrollOffsetX));
                    hashMap2.put("state", Integer.valueOf(tKScrollEvent.state));
                    hashMap2.put("dy", Float.valueOf(tKScrollEvent.dy));
                    hashMap2.put("scrollOffsetY", Float.valueOf(tKScrollEvent.scrollOffsetY));
                    obj2 = Float.valueOf(tKScrollEvent.dx);
                    str2 = "dx";
                    hashMap2.put(str2, obj2);
                    break;
            }
            return hashMap2;
        }
        return (HashMap) invokeLL.objValue;
    }
}
