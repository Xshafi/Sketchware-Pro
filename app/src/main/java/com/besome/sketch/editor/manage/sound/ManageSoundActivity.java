package com.besome.sketch.editor.manage.sound;

import a.a.a.By;
import a.a.a.MA;
import a.a.a.Pv;
import a.a.a.Qp;
import a.a.a.Qv;
import a.a.a.Xf;
import a.a.a.Yv;
import a.a.a.gg;
import a.a.a.ow;
import a.a.a.to;
import a.a.a.xB;
import a.a.a.xo;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.besome.sketch.lib.base.BaseAppCompatActivity;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.material.tabs.TabLayout;

public class ManageSoundActivity extends BaseAppCompatActivity implements ViewPager.e, to {
    public final int k = 2;
    public String l;
    public Toolbar m;
    public ViewPager n;
    public TabLayout o;
    public ow p;
    public Yv q;

    @Override
    public void a(int i) {
    }

    @Override
    public void a(int i, float f, int i2) {
    }

    @Override
    public void d(int i) {
        new a(getApplicationContext()).execute(new Void[0]);
    }

    public void f(int i) {
        this.n.setCurrentItem(i);
    }

    public Yv l() {
        return this.q;
    }

    public ow m() {
        return this.p;
    }

    @Override
    public void onBackPressed() {
        ow owVar = this.p;
        if (owVar.k) {
            owVar.a(false);
            return;
        }
        k();
        try {
            this.p.f();
            this.q.d();
            if (this.j.h()) {
                new Handler().postDelayed(new Qv(this), 500L);
            } else {
                xo.a(getApplicationContext());
            }
        } catch (Exception e) {
            e.printStackTrace();
            h();
        }
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!super.j()) {
            finish();
        }
        setContentView(2131427564);
        this.m = (Toolbar) findViewById(2131231847);
        a(this.m);
        findViewById(2131231370).setVisibility(8);
        d().a(xB.b().a(getApplicationContext(), 2131625137));
        d().e(true);
        d().d(true);
        this.m.setNavigationOnClickListener(new Pv(this));
        if (bundle == null) {
            this.l = getIntent().getStringExtra("sc_id");
        } else {
            this.l = bundle.getString("sc_id");
        }
        this.o = (TabLayout) findViewById(2131231781);
        this.n = (ViewPager) findViewById(2131232325);
        this.n.setAdapter(new b(getSupportFragmentManager()));
        this.n.setOffscreenPageLimit(2);
        this.n.a(this);
        this.o.setupWithViewPager(this.n);
        xo.a((to) this);
    }

    @Override
    public void onDestroy() {
        xo.i();
        super.onDestroy();
    }

    @Override
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!super.j()) {
            finish();
        }
        this.d.setScreenName(ManageSoundActivity.class.getSimpleName().toString());
        this.d.send(new HitBuilders.ScreenViewBuilder().build());
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("sc_id", this.l);
        super.onSaveInstanceState(bundle);
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void b(int i) {
        if (i == 0) {
            this.q.d();
        } else {
            this.p.f();
        }
    }

    class b extends gg {
        public String[] f;

        public b(Xf xf) {
            super(xf);
            this.f = new String[2];
            this.f[0] = xB.b().a(ManageSoundActivity.this.getApplicationContext(), 2131625288).toUpperCase();
            this.f[1] = xB.b().a(ManageSoundActivity.this.getApplicationContext(), 2131625287).toUpperCase();
        }

        @Override
        public int a() {
            return 2;
        }

        @Override
        public Object a(ViewGroup viewGroup, int i) {
            Fragment fragment = (Fragment) super.a(viewGroup, i);
            if (i != 0) {
                ManageSoundActivity.this.q = (Yv) fragment;
            } else {
                ManageSoundActivity.this.p = (ow) fragment;
            }
            return fragment;
        }

        @Override
        public Fragment c(int i) {
            if (i != 0) {
                return new Yv();
            }
            return new ow();
        }

        @Override
        public CharSequence a(int i) {
            return this.f[i];
        }
    }

    class a extends MA {
        public a(Context context) {
            super(context);
            ManageSoundActivity.this.a(this);
        }

        @Override
        public void a() {
            ManageSoundActivity.this.h();
            ManageSoundActivity.this.setResult(-1);
            ManageSoundActivity.this.finish();
            Qp.g().d();
        }

        @Override
        public void b() {
            try {
                publishProgress("Now processing..");
                ManageSoundActivity.this.p.h();
            } catch (Exception e) {
                e.printStackTrace();
                throw new By(xB.b().a(this.a, 2131624916));
            }
        }

        @Override
        public void a(String str) {
            ManageSoundActivity.this.h();
        }
    }
}