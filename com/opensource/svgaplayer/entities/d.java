package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;
import kotlin.h;
@h
/* loaded from: classes.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] nCa = new int[ShapeEntity.ShapeType.values().length];
    public static final /* synthetic */ int[] nCb;
    public static final /* synthetic */ int[] nCc;

    static {
        nCa[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        nCa[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        nCa[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        nCa[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        nCb = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        nCb[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        nCb[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        nCb[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        nCc = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        nCc[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        nCc[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        nCc[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
