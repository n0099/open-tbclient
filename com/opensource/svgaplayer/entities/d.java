package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;
import kotlin.h;
@h
/* loaded from: classes16.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] ooE = new int[ShapeEntity.ShapeType.values().length];
    public static final /* synthetic */ int[] ooF;
    public static final /* synthetic */ int[] ooG;

    static {
        ooE[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        ooE[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        ooE[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        ooE[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        ooF = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        ooF[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        ooF[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        ooF[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        ooG = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        ooG[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        ooG[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        ooG[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
