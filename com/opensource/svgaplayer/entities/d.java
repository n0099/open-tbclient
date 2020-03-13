package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;
import kotlin.h;
@h
/* loaded from: classes.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] nms = new int[ShapeEntity.ShapeType.values().length];
    public static final /* synthetic */ int[] nmt;
    public static final /* synthetic */ int[] nmu;

    static {
        nms[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        nms[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        nms[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        nms[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        nmt = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        nmt[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        nmt[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        nmt[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        nmu = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        nmu[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        nmu[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        nmu[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
