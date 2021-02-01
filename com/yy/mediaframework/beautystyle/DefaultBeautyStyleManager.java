package com.yy.mediaframework.beautystyle;

import com.yy.mediaframework.utils.YMFLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class DefaultBeautyStyleManager implements IBeautyStyleManager {
    protected IBeautyStyle mCurrentStyle;
    protected Map<Class<? extends IBeautyStyle>, IBeautyStyle> mMap = new HashMap();

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.util.Map<java.lang.Class<? extends com.yy.mediaframework.beautystyle.IBeautyStyle>, com.yy.mediaframework.beautystyle.IBeautyStyle> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yy.mediaframework.beautystyle.IBeautyStyleManager
    public void registerStyle(IBeautyStyle iBeautyStyle) {
        if (this.mCurrentStyle == null) {
            this.mCurrentStyle = iBeautyStyle;
        }
        this.mMap.put(iBeautyStyle.getClass(), iBeautyStyle);
    }

    @Override // com.yy.mediaframework.beautystyle.IBeautyStyleManager
    public IBeautyStyle changeStyle(Class<? extends IBeautyStyle> cls) {
        IBeautyStyle iBeautyStyle = this.mMap.get(cls);
        if (iBeautyStyle == null) {
            YMFLog.error(this, "[Beauty  ]", "Can not find beauty styleClass:" + cls);
            return null;
        }
        this.mCurrentStyle = iBeautyStyle;
        return this.mCurrentStyle;
    }

    @Override // com.yy.mediaframework.beautystyle.IBeautyStyleManager
    public IBeautyStyle getCurrentStyle() {
        return this.mCurrentStyle;
    }
}
