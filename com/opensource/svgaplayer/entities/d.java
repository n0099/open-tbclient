package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;
import kotlin.h;
@h
/* loaded from: classes15.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] oDW = new int[ShapeEntity.ShapeType.values().length];
    public static final /* synthetic */ int[] oDX;
    public static final /* synthetic */ int[] oDY;

    static {
        oDW[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        oDW[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        oDW[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        oDW[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        oDX = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        oDX[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        oDX[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        oDX[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        oDY = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        oDY[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        oDY[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        oDY[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
