package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;
import kotlin.h;
@h
/* loaded from: classes15.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] pvs = new int[ShapeEntity.ShapeType.values().length];
    public static final /* synthetic */ int[] pvt;
    public static final /* synthetic */ int[] pvu;

    static {
        pvs[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        pvs[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        pvs[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        pvs[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        pvt = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        pvt[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        pvt[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        pvt[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        pvu = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        pvu[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        pvu[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        pvu[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
