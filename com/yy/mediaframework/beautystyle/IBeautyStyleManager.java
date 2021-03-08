package com.yy.mediaframework.beautystyle;
/* loaded from: classes6.dex */
public interface IBeautyStyleManager {
    IBeautyStyle changeStyle(Class<? extends IBeautyStyle> cls);

    IBeautyStyle getCurrentStyle();

    void registerStyle(IBeautyStyle iBeautyStyle);
}
