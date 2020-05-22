package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;
import kotlin.h;
@h
/* loaded from: classes.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] neX = new int[ShapeEntity.ShapeType.values().length];
    public static final /* synthetic */ int[] neY;
    public static final /* synthetic */ int[] neZ;

    static {
        neX[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        neX[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        neX[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        neX[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        neY = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        neY[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        neY[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        neY[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        neZ = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        neZ[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        neZ[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        neZ[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
