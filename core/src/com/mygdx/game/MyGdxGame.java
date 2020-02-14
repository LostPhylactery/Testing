package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;


public class MyGdxGame implements ApplicationListener {
	SpriteBatch batch;
	Texture rock;

	private Rectangle rockRectangle;
	private Rectangle cloudRectangle;

	private OrthographicCamera camera;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		rock = new Texture("rock.png");

		float rockWidth = rock.getWidth() / 500.0f;
		float rockHeight = rock.getHeight() / 500.0f;

		rockRectangle = new Rectangle(0.0f, 0.0f, rockWidth, rockHeight);

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 10, 5);
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render () {
		batch.setProjectionMatrix(camera.combined);
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			rockRectangle.x += 0.1f;
		}
		if(Gdx.input.isKeyPressed((Input.Keys.LEFT))) {
			rockRectangle.x -= 0.1f;
		}

		batch.begin();
		batch.draw(rock, rockRectangle.x, rockRectangle.y, rockRectangle.width, rockRectangle.height);
		batch.end();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose () {
		batch.dispose();
		rock.dispose();
	}
}
