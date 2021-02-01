package com.yy.mediaframework.beautystyle;
/* loaded from: classes4.dex */
public interface IBeautyStyleManager {
    IBeautyStyle changeStyle(Class<? extends IBeautyStyle> cls);

    IBeautyStyle getCurrentStyle();

    void registerStyle(IBeautyStyle iBeautyStyle);
}
