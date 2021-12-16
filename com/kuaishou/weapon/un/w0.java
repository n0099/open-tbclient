package com.kuaishou.weapon.un;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tbadk.core.util.RomTypeUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
/* loaded from: classes3.dex */
public class w0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int A = 211;
    public static final int A0 = 86;
    public static final int A1 = 1;
    public static final int A2 = 41;
    public static final int A3 = 6023;
    public static final int A4 = 8025;
    public static final int A5 = 8077;
    public static final int A6 = 13010;
    public static final int A7 = 9085;
    public static final int A8 = 9033;
    public static final int B = 166;
    public static final int B0 = 192;
    public static final int B1 = 2;
    public static final int B2 = 42;
    public static final int B3 = 51;
    public static final int B4 = 8026;
    public static final int B5 = 8078;
    public static final int B6 = 13011;
    public static final int B7 = 9086;
    public static final int B8 = 9034;
    public static final int C = 230;
    public static final int C0 = 11;
    public static final int C1 = 3;
    public static final int C2 = 43;
    public static final int C3 = 4000;
    public static final int C4 = 8027;
    public static final int C5 = 8079;
    public static final int C6 = 13012;
    public static final int C7 = 9087;
    public static final int C8 = 9035;
    public static final int D = 256;
    public static final int D0 = 13;
    public static final int D1 = 1;
    public static final int D2 = 11;
    public static final int D3 = 4001;
    public static final int D4 = 8028;
    public static final int D5 = 8080;
    public static final int D6 = 9036;
    public static final int D7 = 9088;
    public static final int D8 = 49;
    public static final int E = 126;
    public static final int E0 = 3;
    public static final int E1 = 2;
    public static final int E2 = 12;
    public static final int E3 = 4002;
    public static final int E4 = 8029;
    public static final int E5 = 8081;
    public static final int E6 = 9037;
    public static final int E7 = 9089;
    public static final int E8 = 50;
    public static final int F = 261;
    public static final int F0 = 1;
    public static final int F1 = 3;
    public static final int F2 = 13;
    public static final int F3 = 4003;
    public static final int F4 = 8030;
    public static final int F5 = 8000;
    public static final int F6 = 9038;
    public static final int F7 = 9090;
    public static final int F8 = 13000;
    public static final int G = 70;
    public static final int G0 = 2;
    public static final int G1 = 4;
    public static final int G2 = 14;
    public static final int G3 = 4004;
    public static final int G4 = 8031;
    public static final int G5 = 11001;
    public static final int G6 = 9039;
    public static final int G7 = 9091;
    public static final int G8 = 11000;
    public static final int H = 96;
    public static final int H0 = 12;
    public static final int H1 = 5;
    public static final int H2 = 15;
    public static final int H3 = 4005;
    public static final int H4 = 8032;
    public static final int H5 = 11002;
    public static final int H6 = 9040;
    public static final int H7 = 9092;
    public static final int H8 = 2001;
    public static final int I = 148;
    public static final int I0 = 4;
    public static final int I1 = 6;
    public static final int I2 = 16;
    public static final int I3 = 4006;
    public static final int I4 = 8033;
    public static final int I5 = 12001;
    public static final int I6 = 9041;
    public static final int I7 = 9093;
    public static final int I8 = 2002;
    public static final int J = 97;
    public static final int J0 = 8;
    public static final int J1 = 7;
    public static final int J2 = 17;
    public static final int J3 = 4007;
    public static final int J4 = 8034;
    public static final int J5 = 2000;
    public static final int J6 = 9042;
    public static final int J7 = 9094;
    public static final int J8 = 2003;
    public static final int K = 181;
    public static final int K0 = 9;
    public static final int K1 = 8;
    public static final int K2 = 18;
    public static final int K3 = 4008;
    public static final int K4 = 8035;
    public static final int K5 = 10001;
    public static final int K6 = 9043;
    public static final int K7 = 9095;
    public static final int K8 = 2004;
    public static final int L = 231;
    public static final int L0 = 10;
    public static final int L1 = 9;
    public static final int L2 = 19;
    public static final int L3 = 4009;
    public static final int L4 = 8036;
    public static final int L5 = 10002;
    public static final int L6 = 9044;
    public static final int L7 = 9096;
    public static final int L8 = 2005;
    public static final int M = 191;
    public static final int M0 = 5;
    public static final int M1 = 10;
    public static final int M2 = 20;
    public static final int M3 = 4010;
    public static final int M4 = 8037;
    public static final int M5 = 10003;
    public static final int M6 = 9045;
    public static final int M7 = 9097;
    public static final int M8 = 2006;
    public static final int N = 111;
    public static final int N0 = 7;
    public static final int N1 = 15000;
    public static final int N2 = 21;
    public static final int N3 = 4011;
    public static final int N4 = 8038;
    public static final int N5 = 10004;
    public static final int N6 = 9046;
    public static final int N7 = 9098;
    public static final int N8 = 2008;
    public static final int O = 271;
    public static final int O0 = 6;
    public static final int O1 = 14000;
    public static final int O2 = 22;
    public static final int O3 = 4012;
    public static final int O4 = 8039;
    public static final int O5 = 10005;
    public static final int O6 = 9047;
    public static final int O7 = 9099;
    public static final int O8 = 2007;
    public static final int P = 80;
    public static final int P0 = 25;
    public static final int P1 = 14001;
    public static final int P2 = 23;
    public static final int P3 = 17000;
    public static final int P4 = 8040;
    public static final int P5 = 10006;
    public static final int P6 = 9048;
    public static final int P7 = 9100;
    public static final int P8 = 2009;
    public static final int Q = 224;
    public static final int Q0 = 55;
    public static final int Q1 = 14002;
    public static final int Q2 = 24;
    public static final int Q3 = 17001;
    public static final int Q4 = 8041;
    public static final int Q5 = 10007;
    public static final int Q6 = 9049;
    public static final int Q7 = 9101;
    public static final int Q8 = 2010;
    public static final int R = 217;
    public static final int R0 = 57;
    public static final int R1 = 14003;
    public static final int R2 = 25;
    public static final int R3 = 17002;
    public static final int R4 = 8042;
    public static final int R5 = 10008;
    public static final int R6 = 9050;
    public static final int R7 = 9102;
    public static final int R8 = 2011;
    public static final int S = 195;
    public static final int S0 = 59;
    public static final int S1 = 14004;
    public static final int S2 = 26;
    public static final int S3 = 17003;
    public static final int S4 = 8043;
    public static final int S5 = 7003;
    public static final int S6 = 9051;
    public static final int S7 = 9104;
    public static final int S8 = 10000;
    public static final int T = 66;
    public static final int T0 = 78;
    public static final int T1 = 14005;
    public static final int T2 = 27;
    public static final int T3 = 17004;
    public static final int T4 = 8044;
    public static final int T5 = 7004;
    public static final int T6 = 9052;
    public static final int T7 = 9103;
    public static final int T8 = 0;
    public static final int U = 114;
    public static final int U0 = 81;
    public static final int U1 = 14006;
    public static final int U2 = 28;
    public static final int U3 = 17005;
    public static final int U4 = 8045;
    public static final int U5 = 7005;
    public static final int U6 = 9053;
    public static final int U7 = 9001;
    public static final int V = 120;
    public static final int V0 = 83;
    public static final int V1 = 14007;
    public static final int V2 = 29;
    public static final int V3 = 17006;
    public static final int V4 = 8046;
    public static final int V5 = 7006;
    public static final int V6 = 9054;
    public static final int V7 = 9002;
    public static final int W = 268;
    public static final int W0 = 89;
    public static final int W1 = 14008;
    public static final int W2 = 3000;
    public static final int W3 = 17007;
    public static final int W4 = 8047;
    public static final int W5 = 7007;
    public static final int W6 = 9055;
    public static final int W7 = 9003;
    public static final int X = 204;
    public static final int X0 = 91;
    public static final int X1 = 14009;
    public static final int X2 = 3001;
    public static final int X3 = 12000;
    public static final int X4 = 8048;
    public static final int X5 = 7001;
    public static final int X6 = 9056;
    public static final int X7 = 9004;
    public static final int Y = 246;
    public static final int Y0 = 102;
    public static final int Y1 = 1000;
    public static final int Y2 = 3002;
    public static final int Y3 = 7000;
    public static final int Y4 = 8049;
    public static final int Y5 = 7002;
    public static final int Y6 = 9057;
    public static final int Y7 = 9005;
    public static final int Z = 245;
    public static final int Z0 = 150;
    public static final int Z1 = 16000;
    public static final int Z2 = 3003;
    public static final int Z3 = 5;
    public static final int Z4 = 8050;
    public static final int Z5 = 9000;
    public static final int Z6 = 9058;
    public static final int Z7 = 9006;
    public static final int a = 1;
    public static final int a0 = 220;
    public static final int a1 = 162;
    public static final int a2 = 16001;
    public static final int a3 = 3004;
    public static final int a4 = 32;
    public static final int a5 = 8051;
    public static final int a6 = 5000;
    public static final int a7 = 9059;
    public static final int a8 = 9007;

    /* renamed from: b  reason: collision with root package name */
    public static final int f57471b = 24;
    public static final int b0 = 65;
    public static final int b1 = 199;
    public static final int b2 = 16002;
    public static final int b3 = 3005;
    public static final int b4 = 44;
    public static final int b5 = 8052;
    public static final int b6 = 5001;
    public static final int b7 = 9060;
    public static final int b8 = 9008;

    /* renamed from: c  reason: collision with root package name */
    public static final int f57472c = 22;
    public static final int c0 = 214;
    public static final int c1 = 232;
    public static final int c2 = 1001;
    public static final int c3 = 3006;
    public static final int c4 = 8001;
    public static final int c5 = 8053;
    public static final int c6 = 5002;
    public static final int c7 = 9061;
    public static final int c8 = 9009;

    /* renamed from: d  reason: collision with root package name */
    public static final int f57473d = 2;
    public static final int d0 = 168;
    public static final int d1 = 240;
    public static final int d2 = 45;
    public static final int d3 = 3007;
    public static final int d4 = 8002;
    public static final int d5 = 8054;
    public static final int d6 = 5003;
    public static final int d7 = 9062;
    public static final int d8 = 9010;

    /* renamed from: e  reason: collision with root package name */
    public static final int f57474e = 130;
    public static final int e0 = 186;
    public static final int e1 = 62;
    public static final int e2 = 15001;
    public static final int e3 = 39;
    public static final int e4 = 8003;
    public static final int e5 = 8055;
    public static final int e6 = 5004;
    public static final int e7 = 9063;
    public static final int e8 = 9011;

    /* renamed from: f  reason: collision with root package name */
    public static final int f57475f = 218;
    public static final int f0 = 85;
    public static final String f1 = "Actions";
    public static final int f2 = 15002;
    public static final int f3 = 10;
    public static final int f4 = 8004;
    public static final int f5 = 8056;
    public static final int f6 = 5005;
    public static final int f7 = 9064;
    public static final int f8 = 9012;

    /* renamed from: g  reason: collision with root package name */
    public static final int f57476g = 193;
    public static final int g0 = 267;
    public static final String g1 = "Allwinner";
    public static final int g2 = 46;
    public static final int g3 = 6003;
    public static final int g4 = 8005;
    public static final int g5 = 8057;
    public static final int g6 = 5006;
    public static final int g7 = 9065;
    public static final int g8 = 9013;

    /* renamed from: h  reason: collision with root package name */
    public static final int f57477h = 212;
    public static final int h0 = 221;
    public static final String h1 = "AMD";
    public static final int h2 = 47;
    public static final int h3 = 6004;
    public static final int h4 = 8006;
    public static final int h5 = 8058;
    public static final int h6 = 5007;
    public static final int h7 = 9066;
    public static final int h8 = 9014;

    /* renamed from: i  reason: collision with root package name */
    public static final int f57478i = 173;
    public static final int i0 = 242;
    public static final String i1 = "AMLogic";
    public static final int i2 = 48;
    public static final int i3 = 6005;
    public static final int i4 = 8007;
    public static final int i5 = 8059;
    public static final int i6 = 5008;
    public static final int i7 = 9067;
    public static final int i8 = 9015;

    /* renamed from: j  reason: collision with root package name */
    public static final int f57479j = 248;
    public static final int j0 = 285;
    public static final String j1 = "ARM";
    public static final int j2 = 33;
    public static final int j3 = 6006;
    public static final int j4 = 8008;
    public static final int j5 = 8060;
    public static final int j6 = 5009;
    public static final int j7 = 9068;
    public static final int j8 = 9016;

    /* renamed from: k  reason: collision with root package name */
    public static final int f57480k = 222;
    public static final int k0 = 235;
    public static final String k1 = "Broadcom";
    public static final int k2 = 34;
    public static final int k3 = 6007;
    public static final int k4 = 8009;
    public static final int k5 = 8061;
    public static final int k6 = 5010;
    public static final int k7 = 9069;
    public static final int k8 = 9017;
    public static final int l = 76;
    public static final int l0 = 207;
    public static final String l1 = "DEC";
    public static final int l2 = 35;
    public static final int l3 = 6008;
    public static final int l4 = 8010;
    public static final int l5 = 8062;
    public static final int l6 = 5011;
    public static final int l7 = 9070;
    public static final int l8 = 9018;
    public static final int m = 61;
    public static final int m0 = 266;
    public static final String m1 = "Freescale";
    public static final int m2 = 36;
    public static final int m3 = 6009;
    public static final int m4 = 8011;
    public static final int m5 = 8063;
    public static final int m6 = 5012;
    public static final int m7 = 9071;
    public static final int m8 = 9019;
    public static final int n = 145;
    public static final int n0 = 165;
    public static final String n1 = "HiSilicon";
    public static final int n2 = 37;
    public static final int n3 = 6011;
    public static final int n4 = 8012;
    public static final int n5 = 8064;
    public static final int n6 = 5013;
    public static final int n7 = 9072;
    public static final int n8 = 9020;
    public static final int o = 139;
    public static final int o0 = 241;
    public static final String o1 = "Intel";
    public static final int o2 = 38;
    public static final int o3 = 6012;
    public static final int o4 = 8013;
    public static final int o5 = 8065;
    public static final int o6 = 6001;
    public static final int o7 = 9073;
    public static final int o8 = 9024;
    public static final int p = 112;
    public static final int p0 = 157;
    public static final String p1 = "Leadcore";
    public static final int p2 = 1;
    public static final int p3 = 6013;
    public static final int p4 = 8014;
    public static final int p5 = 8066;
    public static final int p6 = 6002;
    public static final int p7 = 9074;
    public static final int p8 = 9025;
    public static final int q = 252;
    public static final int q0 = 52;
    public static final String q1 = "LG";
    public static final int q2 = 2;
    public static final int q3 = 6014;
    public static final int q4 = 8015;
    public static final int q5 = 8067;
    public static final int q6 = 6000;
    public static final int q7 = 9075;
    public static final int q8 = 9021;
    public static final int r = 93;
    public static final int r0 = 94;
    public static final String r1 = "Marvell";
    public static final int r2 = 3;
    public static final int r3 = 6015;
    public static final int r4 = 8016;
    public static final int r5 = 8068;
    public static final int r6 = 13001;
    public static final int r7 = 9076;
    public static final int r8 = 9022;
    public static final int s = 216;
    public static final int s0 = 159;
    public static final String s1 = "MediaTek";
    public static final int s2 = 6;
    public static final int s3 = 6016;
    public static final int s4 = 8017;
    public static final int s5 = 8069;
    public static final int s6 = 13002;
    public static final int s7 = 9077;
    public static final int s8 = 9023;
    public static final int t = 117;
    public static final int t0 = 118;
    public static final String t1 = "nVIDIA";
    public static final int t2 = 7;
    public static final int t3 = 6017;
    public static final int t4 = 8018;
    public static final int t5 = 8070;
    public static final int t6 = 13003;
    public static final int t7 = 9078;
    public static final int t8 = 9026;
    public static final int u = 177;
    public static final int u0 = 113;
    public static final String u1 = "Qualcomm";
    public static final int u2 = 8;
    public static final int u3 = 6018;
    public static final int u4 = 8019;
    public static final int u5 = 8071;
    public static final int u6 = 13004;
    public static final int u7 = 9079;
    public static final int u8 = 9027;
    public static final int v = 158;
    public static final int v0 = 75;
    public static final String v1 = "RockChip";
    public static final int v2 = 4;
    public static final int v3 = 6010;
    public static final int v4 = 8020;
    public static final int v5 = 8072;
    public static final int v6 = 13005;
    public static final int v7 = 9080;
    public static final int v8 = 9028;
    public static final int w = 169;
    public static final int w0 = 278;
    public static final String w1 = "Samsung";
    public static final int w2 = 9;
    public static final int w3 = 6019;
    public static final int w4 = 8021;
    public static final int w5 = 8073;
    public static final int w6 = 13006;
    public static final int w7 = 9081;
    public static final int w8 = 9029;
    public static final int x = 175;
    public static final int x0 = 143;
    public static final String x1 = "Spreadtrum";
    public static final int x2 = 30;
    public static final int x3 = 6020;
    public static final int x4 = 8022;
    public static final int x5 = 8074;
    public static final int x6 = 13007;
    public static final int x7 = 9082;
    public static final int x8 = 9030;
    public static final int y = 275;
    public static final int y0 = 124;
    public static final String y1 = "ST-Ericsson";
    public static final int y2 = 31;
    public static final int y3 = 6021;
    public static final int y4 = 8023;
    public static final int y5 = 8075;
    public static final int y6 = 13008;
    public static final int y7 = 9083;
    public static final int y8 = 9031;
    public static final int z = 227;
    public static final int z0 = 282;
    public static final String z1 = "Texas Instruments";
    public static final int z2 = 40;
    public static final int z3 = 6022;
    public static final int z4 = 8024;
    public static final int z5 = 8076;
    public static final int z6 = 13009;
    public static final int z7 = 9084;
    public static final int z8 = 9032;
    public transient /* synthetic */ FieldHolder $fh;

    public w0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i9 = newInitContext.flag;
            if ((i9 & 1) != 0) {
                int i10 = i9 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                if (b(21)) {
                    return a(21).startsWith("CRR-");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).startsWith("SM-G361");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            try {
                if (b(47)) {
                    String a9 = a(47);
                    if (!a9.equals("C1904") && !a9.equals("C1905") && !a9.equals("C2004")) {
                        if (!a9.equals("C2005")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                if (b(21)) {
                    return a(21).equals("M2-801L");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).startsWith("SM-G531");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            try {
                if (b(47)) {
                    String a9 = a(47);
                    if (!a9.equals("E2303") && !a9.equals("E2306") && !a9.equals("E2312") && !a9.equals("E2333") && !a9.equals("E2353")) {
                        if (!a9.equals("E2363")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            try {
                if (b(21)) {
                    return a(21).startsWith("GEM-");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).startsWith("SM-J100");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            try {
                if (b(47)) {
                    String a9 = a(47);
                    if (!a9.equals("D6502") && !a9.equals("D6503") && !a9.equals("D6543")) {
                        if (!a9.equals("L50W")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            try {
                if (b(21)) {
                    return a(21).equals("NEXUS 6P");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).startsWith("SM-J110");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            try {
                if (b(47)) {
                    String a9 = a(47);
                    if (!a9.equals("D6603") && !a9.equals("D6616") && !a9.equals("D6633") && !a9.equals("D6643") && !a9.equals("D6646")) {
                        if (!a9.equals("D6653")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            try {
                if (b(21)) {
                    return a(21).startsWith("GRA-");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).startsWith("SM-J200");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            try {
                if (b(47)) {
                    String a9 = a(47);
                    if (!a9.equals("D5803")) {
                        if (!a9.equals("D5833")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            try {
                if (b(21)) {
                    return a(21).startsWith("ALE-");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).startsWith("SM-J320");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            try {
                if (b(47)) {
                    String a9 = a(47);
                    if (!a9.equals("D6533")) {
                        if (!a9.equals("D6553")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            try {
                if (b(240)) {
                    return a(240).equals("MATZ LIVE3");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).startsWith("SM-J500");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            try {
                if (b(47)) {
                    String a9 = a(47);
                    if (!a9.equals("SGP712")) {
                        if (!a9.equals("SGP771")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            try {
                if (b(78)) {
                    return a(78).equals("E6782");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).startsWith("SM-J700");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            try {
                if (b(47)) {
                    String a9 = a(47);
                    if (!a9.equals("E6603") && !a9.equals("E6633") && !a9.equals("E6653")) {
                        if (!a9.equals("E6683")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            try {
                if (b(30)) {
                    String a9 = a(30);
                    if (!a9.equals("D800") && !a9.equals("D801") && !a9.equals("D802") && !a9.equals("D802TA") && !a9.equals("D803") && !a9.equals("D805") && !a9.equals("F320K") && !a9.equals("F320L") && !a9.equals("F320S") && !a9.equals("L-01F") && !a9.equals("LS980")) {
                        if (!a9.equals("VS980")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            try {
                if (b(45)) {
                    String a9 = a(45);
                    if (!a9.equals("GT-N8000") && !a9.equals("GT-N8010")) {
                        if (!a9.equals("GT-N8020")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            try {
                if (b(47)) {
                    String a9 = a(47);
                    if (!a9.equals("E5803")) {
                        if (!a9.equals("E5823")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            try {
                if (b(30)) {
                    String a9 = a(30);
                    if (!a9.equals("D610") && !a9.equals("D618") && !a9.equals("D620") && !a9.equals("D620K")) {
                        if (!a9.equals("D620R")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).equals("SM-N900");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
            try {
                if (b(47)) {
                    String a9 = a(47);
                    if (!a9.equals("E6833") && !a9.equals("E6853")) {
                        if (!a9.equals("E6883")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            try {
                if (b(30)) {
                    String a9 = a(30);
                    if (!a9.equals("D850") && !a9.equals("D851") && !a9.equals("D852G") && !a9.equals("D855") && !a9.equals("D856") && !a9.equals("D857") && !a9.equals("D858") && !a9.equals("D859") && !a9.equals("F400K") && !a9.equals("F400L") && !a9.equals("F400S") && !a9.equals("F460K") && !a9.equals("F460L") && !a9.equals("F460S") && !a9.equals("LS990")) {
                        if (!a9.equals("VS985")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).equals("SM-N900A");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) {
            try {
                if (b(199)) {
                    return a(199).equals("QTAQZ3");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            try {
                if (b(30)) {
                    String a9 = a(30);
                    if (!a9.equals("D722") && !a9.equals("D722K") && !a9.equals("D722V")) {
                        if (!a9.equals("D724")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).equals("SM-N9002");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) {
            try {
                if (b(89)) {
                    return a(89).equals("SMART ULTRA 6");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
            try {
                if (b(30)) {
                    return a(30).equals("F490L");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).equals("SM-N9005");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            try {
                if (b(55)) {
                    String a9 = a(55);
                    if (!a9.equals("MI 4C") && !a9.equals("MI-4C")) {
                        if (!a9.equals("MI 4LTE")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) {
            try {
                if (b(30)) {
                    return a(30).equals("H735");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) {
            try {
                if (b(45)) {
                    String a9 = a(45);
                    if (!a9.startsWith("SM-N910")) {
                        if (!a9.startsWith("SM-N916")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) {
            try {
                if (b(55)) {
                    return a(55).equals("MI 5");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65579, null)) == null) {
            try {
                if (b(30)) {
                    String a9 = a(30);
                    if (!a9.equals("F500S") && !a9.equals("H810") && !a9.equals("H815") && !a9.equals("H818") && !a9.equals("LS991") && !a9.equals("US991")) {
                        if (!a9.equals("VS986")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).startsWith("SM-N920");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65581, null)) == null) {
            try {
                if (b(55)) {
                    return a(55).equals("REDMI 3");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) {
            try {
                if (b(30)) {
                    String a9 = a(30);
                    if (!a9.equals("H950") && !a9.equals("H955") && !a9.equals("LS996")) {
                        if (!a9.equals("US995")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).startsWith("SM-N915");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) {
            try {
                if (b(55)) {
                    return a(55).equals("REDMI NOTE 3");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) {
            try {
                if (b(30)) {
                    String a9 = a(30);
                    if (!a9.equals("V495")) {
                        if (!a9.equals("V496")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65586, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).equals("SM-N915F");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65587, null)) == null) {
            try {
                if (b(162)) {
                    return a(162).equals("YU5010");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65588, null)) == null) {
            try {
                if (b(30)) {
                    return a(30).equals("MS330");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65589, null)) == null) {
            try {
                if (b(45)) {
                    String a9 = a(45);
                    if (!a9.equals("SM-P900") && !a9.equals("SM-P901")) {
                        if (!a9.equals("SM-P905")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65590, null)) == null) {
            try {
                if (b(59)) {
                    return a(59).equals("T610");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65591, null)) == null) {
            try {
                if (b(30)) {
                    String a9 = a(30);
                    if (!a9.equals("D405") && !a9.equals("D405N")) {
                        if (!a9.equals("D410")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65592, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).equals("GT-I9301I");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65593, null)) == null) {
            try {
                if (b(59)) {
                    return a(59).equals("BLADE Q LUX");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65594, null)) == null) {
            try {
                if (b(30)) {
                    String a9 = a(30);
                    if (!a9.equals("H345")) {
                        if (!a9.equals("MS345")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65595, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).startsWith("GT-I950");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65596, null)) == null) {
            try {
                if (b(59)) {
                    return a(59).equals("BLADE X9");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65597, null)) == null) {
            try {
                if (b(30)) {
                    return a(30).equals("NEXUS 4");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65598, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).equals("GT-I9500");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65599, null)) == null) {
            try {
                if (b(59)) {
                    return a(59).equals("Z936L");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65600, null)) == null) {
            try {
                if (b(30)) {
                    String a9 = a(30);
                    if (!a9.equals("NEXUS 5")) {
                        if (!a9.equals("NEXUS 5 CAF")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65601, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).equals("GT-I9295");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65602, null)) == null) {
            try {
                if (b(59)) {
                    return a(59).equals("Z812");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65603, null)) == null) {
            try {
                if (b(30)) {
                    return a(30).equals("D415");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65604, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).equals("SPH-L720");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65605, null)) == null) {
            try {
                if (b(59)) {
                    return a(59).equals("N9132");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65606, null)) == null) {
            try {
                if (b(30)) {
                    return a(30).equals("H343");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65607, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).equals("SCH-I545");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65608, null)) == null) {
            try {
                if (b(59)) {
                    return a(59).equals("N9518");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65609, null)) == null) {
            try {
                if (b(30)) {
                    return a(30).equals("VS810PP");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65610, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).startsWith("GT-I9505");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65611, null)) == null) {
            try {
                if (b(59)) {
                    return a(59).equals("N939SC");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65612, null)) == null) {
            try {
                if (b(30)) {
                    return a(30).equals("LS665");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65613, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).equals("GT-I9515");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65614, null)) == null) {
            try {
                return Build.VERSION.SDK_INT >= 4 ? Build.MANUFACTURER.trim() : "";
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"DefaultLocale"})
    public static String a(float f9, boolean z9) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65615, null, new Object[]{Float.valueOf(f9), Boolean.valueOf(z9)})) == null) {
            try {
                return z9 ? f9 < 10.0f ? Float.toString(Math.round(f9 * 100.0f) / 100.0f) : f9 < 100.0f ? Float.toString(Math.round(f9 * 10.0f) / 10.0f) : Integer.toString(Math.round(f9)) : f9 < 10.0f ? String.format("%.2f", Float.valueOf(f9)) : f9 < 100.0f ? String.format("%.1f", Float.valueOf(f9)) : String.format("%d", Integer.valueOf(Math.round(f9)));
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static String a(int i9) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65616, null, i9)) == null) ? "" : (String) invokeI.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65617, null, context)) == null) {
            try {
                long round = Math.round(((Double) Class.forName("com.android.internal.os.PowerProfile").getMethod("getAveragePower", String.class).invoke(Class.forName("com.android.internal.os.PowerProfile").getConstructor(Context.class).newInstance(context), "battery.capacity")).doubleValue());
                return round + "mAh";
            } catch (Throwable th) {
                a(th);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static void a(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65618, null, th) == null) {
        }
    }

    public static boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65619, null)) == null) {
            try {
                if (b(30)) {
                    return a(30).equals("LS675");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65620, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).startsWith("SM-G900");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65621, null)) == null) {
            try {
                if (!d() && !e() && !f() && !k() && !l() && !p() && !n() && !o() && !q() && !s() && !y() && !G() && !H() && !d0() && !f0() && !g0() && !i0() && !J() && !L() && !O() && !N() && !P() && !Q() && !R() && !S() && !T() && !U() && !V() && !W() && !X() && !Y() && !Z() && !a0() && !b0() && !c0() && !k0() && !l0() && !m0() && !n0() && !o0() && !q0() && !r0() && !s0() && !u0() && !x0() && !S0() && !A1() && !B1() && !F1() && !G1() && !H1() && !I1() && !J1() && !L1() && !M1() && !O1() && !P1() && !Q1() && !R1() && !S1() && !T1() && !U1() && !V1() && !W1() && !X1() && !Y1()) {
                    if (j0()) {
                        return 100;
                    }
                    if (K()) {
                        return -100;
                    }
                    if (I()) {
                        return -10;
                    }
                    if (!v0() && !J0() && !K0() && !M0() && !U0() && !V0() && !W0() && !X0() && !Y0() && !Z0() && !e1() && !b1() && !c1() && !d1() && !g1()) {
                        if (!g() && !h() && !i() && !j() && !m() && !w() && !x() && !z() && !A() && !B() && !C() && !E() && !F() && !e0() && !w0() && !y0() && !z0() && !A0() && !B0() && !C0() && !D0() && !E0() && !F0() && !G0() && !H0() && !N0() && !O0() && !I0() && !Q0() && !R0() && !p1() && !q1() && !T0() && !a1() && !i1() && !k1() && !l1() && !m1() && !n1() && !r1() && !t1() && !s1() && !u1() && !v1() && !z1() && !w1() && !x1() && !y1()) {
                            if (!K1()) {
                                return 1;
                            }
                        }
                        return 1000;
                    }
                    return -1000;
                }
                return -1;
            } catch (Throwable unused) {
                return 1;
            }
        }
        return invokeV.intValue;
    }

    @SuppressLint({"NewApi"})
    public static String b(Context context) {
        BatteryManager batteryManager;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65622, null, context)) == null) {
            try {
                return (Build.VERSION.SDK_INT < 21 || (batteryManager = (BatteryManager) context.getSystemService("batterymanager")) == null) ? "0%" : a(Math.abs(b() * batteryManager.getIntProperty(2)) / 1000.0f, false);
            } catch (Throwable th) {
                a(th);
                return "0%";
            }
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"DefaultLocale"})
    public static boolean b(int i9) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65623, null, i9)) == null) {
            try {
                switch (i9) {
                    case 5:
                        return a().toUpperCase().equals("ACER");
                    case 7:
                        return a().toUpperCase().equals("ASUS");
                    case 20:
                        return a().toUpperCase().equals("HTC");
                    case 21:
                        return Build.BRAND.trim().toUpperCase().equals("HUAWEI") || a().toUpperCase().equals("HUAWEI");
                    case 25:
                        return a().toUpperCase().equals("KARBONN");
                    case 29:
                        return a().toUpperCase().equals("LENOVO");
                    case 30:
                        return a().toUpperCase().equals("LGE");
                    case 31:
                        return a().toUpperCase().equals("MEIZU");
                    case 33:
                        return a().toUpperCase().equals("MOTOROLA");
                    case 38:
                        return a().toUpperCase().equals("NVIDIA");
                    case 40:
                        return a().toUpperCase().equals(RomTypeUtil.ROM_ONEPLUS);
                    case 41:
                        return a().toUpperCase().equals("OPPO");
                    case 45:
                        return a().toUpperCase().equals(g.f57226j);
                    case 47:
                        return a().toUpperCase().equals("SONY");
                    case 55:
                        return a().toUpperCase().equals("XIAOMI");
                    case 57:
                        return a().toUpperCase().startsWith("YOTA ") || Build.BRAND.trim().toUpperCase().equals("YOTAPHONE");
                    case 59:
                        String upperCase = a().toUpperCase();
                        return upperCase.equals("ZTE") || upperCase.equals(RomUtils.ROM_NUBIA);
                    case 78:
                        return a().toUpperCase().equals("KYOCERA");
                    case 81:
                        return Build.BRAND.trim().toUpperCase().equals("COOLPAD") || a().toUpperCase().equals("COOLPAD");
                    case 83:
                        return a().toUpperCase().equals("ELEPHONE");
                    case 89:
                        return a().toUpperCase().equals("VODAFONE");
                    case 91:
                        return a().toUpperCase().equals("MICROMAX");
                    case 102:
                        return a().toUpperCase().equals("BQ");
                    case 150:
                        return a().toUpperCase().equals("DIGMA");
                    case 162:
                        return a().toUpperCase().equals("YU");
                    case 199:
                        return Build.BRAND.trim().toUpperCase().equals("VERIZON") || a().toUpperCase().equals("VERIZON");
                    case c1 /* 232 */:
                        return a().toUpperCase().equals("GOOGLE");
                    case 240:
                        return a().toUpperCase().equals("KRUGER");
                    default:
                        return false;
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    public static boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65624, null)) == null) {
            try {
                if (b(30)) {
                    String a9 = a(30);
                    if (!a9.equals("F600K") && !a9.equals("F600L") && !a9.equals("F600S") && !a9.equals("H900") && !a9.equals("H901") && !a9.equals("H960") && !a9.equals("H960YK") && !a9.equals("H968")) {
                        if (!a9.equals("VS990")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65625, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).startsWith("SM-G870");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static String c() {
        BufferedReader bufferedReader;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65626, null)) == null) {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/sys/class/power_supply/usb/online")), 1000);
            } catch (Throwable unused) {
                bufferedReader = null;
            }
            try {
                String readLine = bufferedReader.readLine();
                try {
                    bufferedReader.close();
                } catch (Throwable unused2) {
                }
                return readLine;
            } catch (Throwable unused3) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                        return "";
                    } catch (Throwable unused4) {
                        return "";
                    }
                }
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65627, null, context)) == null) {
            try {
                int intExtra = g(context).getIntExtra("plugged", -1);
                return intExtra != 1 ? intExtra != 2 ? intExtra != 4 ? "" : "Wireless charger" : "USB charger" : "AC charger";
            } catch (Throwable th) {
                a(th);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65628, null)) == null) {
            try {
                if (b(30)) {
                    return a(30).equals("LS751");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65629, null)) == null) {
            try {
                if (b(45)) {
                    String a9 = a(45);
                    if (!a9.equals("SM-G900P") && !a9.equals("SM-G900R4")) {
                        if (!a9.equals("SM-G900V")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65630, null, context)) == null) {
            try {
                int intExtra = g(context).getIntExtra("status", -1);
                return intExtra != 2 ? intExtra != 3 ? intExtra != 4 ? intExtra != 5 ? "unknow" : "full" : "not charging" : "discharging" : "charging";
            } catch (Throwable unused) {
                return "unknow";
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65631, null)) == null) {
            try {
                if (b(5)) {
                    return a(5).equals("T01");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65632, null)) == null) {
            try {
                if (b(29)) {
                    String a9 = a(29);
                    if (!a9.equals("S90-A")) {
                        if (!a9.equals("S90-U")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65633, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).equals("SM-G900FD");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static int e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65634, null, context)) == null) {
            try {
                int intExtra = g(context).getIntExtra("health", -1);
                if (intExtra != 2) {
                    if (intExtra != 3) {
                        if (intExtra != 4) {
                            if (intExtra != 5) {
                                return intExtra != 7 ? 6 : 1;
                            }
                            return 5;
                        }
                        return 2;
                    }
                    return 4;
                }
                return 3;
            } catch (Throwable th) {
                a(th);
                return -1;
            }
        }
        return invokeL.intValue;
    }

    @SuppressLint({"DefaultLocale"})
    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65635, null)) == null) {
            try {
                String upperCase = a().toUpperCase();
                if (upperCase.equals("TCL") || upperCase.equals("TCL ALCATEL ONETOUCH")) {
                    String a9 = a(62);
                    if (!a9.equals("6039A") && !a9.equals("6039H") && !a9.equals("6039J") && !a9.equals("6039K") && !a9.equals("6039S")) {
                        if (!a9.equals("6039Y")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65636, null)) == null) {
            try {
                if (b(29)) {
                    String a9 = a(29);
                    if (!a9.equals("TAB S8-50F")) {
                        if (!a9.equals("TAB S8-50L")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65637, null)) == null) {
            try {
                if (b(45)) {
                    String a9 = a(45);
                    if (!a9.equals("SM-G900A") && !a9.equals("SM-G900F") && !a9.equals("SM-G900H") && !a9.equals("SM-G900M")) {
                        if (!a9.equals("SM-G900T")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65638, null, context)) == null) {
            try {
                Intent g9 = g(context);
                int intExtra = g9 != null ? (int) ((g9.getIntExtra("level", -1) / g9.getIntExtra(AnimationProperty.SCALE, -1)) * 100.0f) : 0;
                return intExtra + "%";
            } catch (Throwable th) {
                a(th);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"DefaultLocale"})
    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65639, null)) == null) {
            try {
                String upperCase = a().toUpperCase();
                if (upperCase.equals("TCL") || upperCase.equals("TCL ALCATEL ONETOUCH")) {
                    String a9 = a(62);
                    if (!a9.equals("6045B") && !a9.equals("6045I") && !a9.equals("6045K") && !a9.equals("6045O")) {
                        if (!a9.equals("6045Y")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65640, null)) == null) {
            try {
                if (b(29)) {
                    return a(29).equals("P1A42");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65641, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).startsWith("SM-G906");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static Intent g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65642, null, context)) == null) ? context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")) : (Intent) invokeL.objValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65643, null)) == null) {
            try {
                if (b(7)) {
                    return a(7).equals("K007");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65644, null)) == null) {
            try {
                if (b(29)) {
                    return a(29).equals("K920");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65645, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).startsWith("SM-G901");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65646, null, context)) == null) {
            try {
                String stringExtra = g(context).getStringExtra("technology");
                return TextUtils.isEmpty(stringExtra) ? "unknown" : stringExtra;
            } catch (Throwable th) {
                a(th);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65647, null)) == null) {
            try {
                if (b(7)) {
                    return a(7).equals("K01H");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65648, null)) == null) {
            try {
                if (b(29)) {
                    return a(29).equals("B8080-H");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65649, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).startsWith("SM-G860");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static String i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65650, null, context)) == null) {
            try {
                int intExtra = g(context).getIntExtra("temperature", 0);
                return (intExtra / 10.0f) + "℃";
            } catch (Throwable th) {
                a(th);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65651, null)) == null) {
            try {
                if (b(7)) {
                    return a(7).equals("K015");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65652, null)) == null) {
            try {
                if (b(29)) {
                    String a9 = a(29);
                    if (!a9.equals("YOGA TABLET 2-830F") && !a9.equals("YOGA TABLET 2-830L")) {
                        if (!a9.equals("YOGA TABLET 2-830LC")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65653, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).startsWith("SM-G920");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65654, null, context)) == null) {
            try {
                int intExtra = g(context).getIntExtra("voltage", 0);
                return String.valueOf(intExtra / 100.0f) + "V";
            } catch (Throwable th) {
                a(th);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65655, null)) == null) {
            try {
                if (b(7)) {
                    return a(7).equals("NEXUS 7");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65656, null)) == null) {
            try {
                if (b(31)) {
                    String a9 = a(31);
                    if (!a9.equals("M2NOTE")) {
                        if (!a9.equals("M2 NOTE")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65657, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).startsWith("SM-G890");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static int k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65658, null, context)) == null) {
            try {
                return g(context).getIntExtra("plugged", 0) == 0 ? 0 : 1;
            } catch (Throwable unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65659, null)) == null) {
            try {
                if (b(7)) {
                    String a9 = a(7);
                    if (!a9.startsWith("Z00E") && !a9.equals("Z00ED")) {
                        if (!a9.equals("Z00RD")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65660, null)) == null) {
            try {
                if (b(91)) {
                    return a(91).equals("E471");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65661, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).startsWith("SM-G925");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65662, null)) == null) {
            try {
                if (b(7)) {
                    String a9 = a(7);
                    if (!a9.equals("Z00T") && !a9.equals("Z00U")) {
                        if (!a9.equals("Z00UD")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65663, null, context)) == null) {
            try {
                return g(context).getIntExtra("plugged", -1) == 1;
            } catch (Throwable th) {
                a(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65664, null)) == null) {
            try {
                if (b(91)) {
                    return a(91).equals("Q415");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65665, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).startsWith("SM-G928");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65666, null)) == null) {
            try {
                if (b(7)) {
                    String a9 = a(7);
                    if (!a9.startsWith("P01T")) {
                        if (!a9.equals("P01T_1")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65667, null)) == null) {
            try {
                if (b(33)) {
                    return a(33).equals("XT1025");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65668, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).startsWith("SM-G930");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65669, null)) == null) {
            try {
                if (b(102)) {
                    return a(102).equals("AQUARIS M5");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65670, null)) == null) {
            try {
                if (b(33)) {
                    String a9 = a(33);
                    if (!a9.equals("XT1003") && !a9.equals("XT1028") && !a9.equals("XT1031") && !a9.equals("XT1032") && !a9.equals("XT1033") && !a9.equals("XT1034")) {
                        if (!a9.equals("XT1035")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65671, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).startsWith("SM-G935");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65672, null)) == null) {
            try {
                if (b(102)) {
                    return a(102).equals("AQUARIS X5");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65673, null)) == null) {
            try {
                if (b(33)) {
                    String a9 = a(33);
                    if (!a9.equals("XT1063") && !a9.equals("XT1064") && !a9.equals("XT1068") && !a9.equals("XT1069") && !a9.equals("XT1072")) {
                        if (!a9.equals("XT1078")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65674, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).equals("GT-S7562");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65675, null)) == null) {
            try {
                if (b(8)) {
                    return a(8).startsWith("STV100-");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65676, null)) == null) {
            try {
                if (b(33)) {
                    return a(33).equals("MOTOG3");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65677, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).equals("GT-I9300");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65678, null)) == null) {
            try {
                if (b(81)) {
                    return a(81).equals("3320A");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65679, null)) == null) {
            try {
                if (b(33)) {
                    return a(33).equals("XT1008");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65680, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).equals("GT-I8190");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65681, null)) == null) {
            try {
                if (b(150)) {
                    return a(150).equals("OPTIMA S10.0 3G TT1010MG");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65682, null)) == null) {
            try {
                if (b(33)) {
                    String a9 = a(33);
                    if (!a9.equals("XT1049") && !a9.equals("XT1050") && !a9.equals("XT1052") && !a9.equals("XT1053") && !a9.equals("XT1055") && !a9.equals("XT1056") && !a9.equals("XT1058")) {
                        if (!a9.equals("XT1060")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65683, null)) == null) {
            try {
                if (b(45)) {
                    String a9 = a(45);
                    if (!a9.equals("SM-T310") && !a9.equals("SM-T311")) {
                        if (!a9.equals("SM-T315")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65684, null)) == null) {
            try {
                if (b(83)) {
                    return a(83).equals("TRUNK 1");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65685, null)) == null) {
            try {
                if (b(33)) {
                    String a9 = a(33);
                    if (!a9.equals("XT1092") && !a9.equals("XT1093") && !a9.equals("XT1094") && !a9.equals("XT1095") && !a9.equals("XT1096")) {
                        if (!a9.equals("XT1097")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65686, null)) == null) {
            try {
                if (b(45)) {
                    String a9 = a(45);
                    if (!a9.equals("SM-T530") && !a9.equals("SM-T531") && !a9.equals("SM-T533")) {
                        if (!a9.equals("SM-T535")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65687, null)) == null) {
            try {
                if (b(20)) {
                    return a(20).equals("NEXUS 9");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65688, null)) == null) {
            try {
                if (b(33)) {
                    return a(33).equals("NEXUS 6");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65689, null)) == null) {
            try {
                if (b(45)) {
                    String a9 = a(45);
                    if (!a9.equals("SM-T330") && !a9.equals("SM-T331")) {
                        if (!a9.equals("SM-T335")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65690, null)) == null) {
            try {
                if (b(20)) {
                    String a9 = a(20);
                    if (!a9.startsWith("0PAJ") && !a9.equals("ONE_E8") && !a9.equals("ONE E8") && !a9.equals("ONE_E8 DUAL SIM") && !a9.startsWith("0P6B") && !a9.equals("6525LVW") && !a9.equals("831C") && !a9.equals("ONE_M8") && !a9.equals("ONE M8")) {
                        if (!a9.equals("ONE_M8 DUAL SIM")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65691, null)) == null) {
            try {
                if (b(40)) {
                    String a9 = a(40);
                    if (!a9.equals("A2001") && !a9.equals("A2003")) {
                        if (!a9.equals("A2005")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65692, null)) == null) {
            try {
                if (b(45)) {
                    String a9 = a(45);
                    if (!a9.equals("SM-T350") && !a9.equals("SM-T351")) {
                        if (!a9.equals("SM-T355")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65693, null)) == null) {
            try {
                if (b(20)) {
                    return a(20).equals("ONE X");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65694, null)) == null) {
            try {
                if (b(40)) {
                    return a(40).equals("A0001");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65695, null)) == null) {
            try {
                if (b(45)) {
                    String a9 = a(45);
                    if (!a9.equals("SM-T550")) {
                        if (!a9.equals("SM-T555")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65696, null)) == null) {
            try {
                if (b(21)) {
                    return a(21).startsWith("P7-L");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65697, null)) == null) {
            try {
                if (b(41)) {
                    String a9 = a(41);
                    if (!a9.equals("FIND7")) {
                        if (!a9.equals("FIND 7")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65698, null)) == null) {
            try {
                if (b(45)) {
                    String a9 = a(45);
                    if (!a9.equals("SM-T800") && !a9.equals("SM-T805")) {
                        if (!a9.equals("SM-T805W")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65699, null)) == null) {
            try {
                if (b(21)) {
                    return a(21).startsWith("CHM-");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65700, null)) == null) {
            try {
                if (b((int) g0)) {
                    return a((int) g0).equals("8692-I02");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65701, null)) == null) {
            try {
                if (b(45)) {
                    String a9 = a(45);
                    if (!a9.equals("SM-T710")) {
                        if (!a9.equals("SM-T715")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65702, null)) == null) {
            try {
                if (b(21)) {
                    return a(21).startsWith("KIW-");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65703, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).startsWith("SM-A510");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65704, null)) == null) {
            try {
                if (b(45)) {
                    String a9 = a(45);
                    if (!a9.equals("SM-T810")) {
                        if (!a9.equals("SM-T815")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65705, null)) == null) {
            try {
                if (b(21)) {
                    return a(21).startsWith("PLK-");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65706, null)) == null) {
            try {
                if (b(45)) {
                    return a(45).startsWith("SM-G850");
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65707, null)) == null) {
            try {
                if (b(45)) {
                    String a9 = a(45);
                    if (!a9.equals("SM-T700") && !a9.equals("SM-T705")) {
                        if (!a9.equals("SM-T705Y")) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
