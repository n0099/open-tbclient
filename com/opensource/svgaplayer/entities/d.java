package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;
import kotlin.h;
@h
/* loaded from: classes8.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] nKI = new int[ShapeEntity.ShapeType.values().length];
    public static final /* synthetic */ int[] nKJ;
    public static final /* synthetic */ int[] nKK;

    static {
        nKI[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        nKI[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        nKI[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        nKI[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        nKJ = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        nKJ[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        nKJ[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        nKJ[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        nKK = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        nKK[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        nKK[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        nKK[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
